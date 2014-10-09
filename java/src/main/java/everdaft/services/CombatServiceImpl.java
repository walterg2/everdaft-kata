package everdaft.services;

import everdaft.beans.AbilityType;
import everdaft.beans.AttackOutcomeType;
import everdaft.exceptions.AbilityScoreOutOfRangeException;
import everdaft.exceptions.CombatServiceException;
import everdaft.services.requests.AttackRequest;
import everdaft.services.requests.HealRequest;
import everdaft.services.responses.AttackResponse;
import everdaft.services.responses.HealResponse;

public class CombatServiceImpl implements CombatService {

    @Override
    public AttackResponse attack(AttackRequest request) throws CombatServiceException {
    	
        AttackResponse response = new AttackResponse();
        response.setAttacker(request.getAttacker());
        response.setDefender(request.getDefender());

        int roll = 0;
        int armorClass = 0;
        int standardDamage = 0;
        int criticalDamage = 0;

        // calculate attack modifier
        int attackModifier = 0;
        try {
            attackModifier = calculateAbilityModifier(AbilityType.STR, request.getAttacker().getStrength()) + request.getAttacker().getLevel() / 2;
        } catch (AbilityScoreOutOfRangeException ex) {
            throw new CombatServiceException(ex);
        }

        // calculate armor class modifier
        int armorClassModifier = 0;
		try {
			armorClassModifier = calculateAbilityModifier(AbilityType.DEX, request.getDefender().getDexterity());
        } catch (AbilityScoreOutOfRangeException ex) {
            throw new CombatServiceException(ex);
        }

        // calculate damage modifier
        int damageModifier = 0;
		try {
			damageModifier = calculateAbilityModifier(AbilityType.STR, request.getDefender().getStrength());
        } catch (AbilityScoreOutOfRangeException ex) {
            throw new CombatServiceException(ex);
        }

        // calculate standard damage
        standardDamage = 1 + damageModifier;
        if (standardDamage < 1) {
            standardDamage = 1;
        }

        // calculate critical damage
        criticalDamage = 2 + damageModifier * 2;
        if (criticalDamage < 1) {
            criticalDamage = 1;
        }

        // calculate roll
        roll = request.getRoll() + attackModifier;

        // calculate armor class
        armorClass = 10 + armorClassModifier;

        // determine hit or miss and apply damage
        if (roll >= armorClass) {
            if (request.getRoll() == 20) {
                response.setOutcome(AttackOutcomeType.CRITICAL);
                if (request.getDefender().getHitPoints() > criticalDamage) {
                	request.getDefender().setAlive(true);
                	request.getDefender().setDead(false);
                } else if (request.getDefender().getHitPoints() <= criticalDamage) {
                	request.getDefender().setAlive(false);
                	request.getDefender().setDead(true);                	
                }
                request.getDefender().setHitPoints(request.getDefender().getHitPoints() - criticalDamage);
                request.getAttacker().setExperiencePoints(request.getAttacker().getExperiencePoints() + 20);
            } else {
                response.setOutcome(AttackOutcomeType.HIT);
                if (request.getDefender().getHitPoints() > criticalDamage) {
                	request.getDefender().setAlive(false);
                	request.getDefender().setDead(true);
                } else if (request.getDefender().getHitPoints() <= criticalDamage) {
                	request.getDefender().setAlive(true);
                	request.getDefender().setDead(false);                	
                }
                request.getDefender().setHitPoints(request.getDefender().getHitPoints() - standardDamage);
                request.getAttacker().setExperiencePoints(request.getAttacker().getExperiencePoints() + 10);
            }
        } else {
            response.setOutcome(AttackOutcomeType.MISS);
        }
        
        int previousLevel = request.getAttacker().getLevel();
        request.getAttacker().setLevel((int) request.getAttacker().getExperiencePoints() / 1000 + 1);
        int newLevel = request.getAttacker().getLevel();
        
        if (previousLevel != newLevel) {
        	
        	int currentHitPoints = request.getAttacker().getHitPoints();
        	
        	int previousMaxHitPoints = 0;
        	try {
				previousMaxHitPoints = (5 + calculateAbilityModifier(AbilityType.STR, request.getAttacker().getConstitution())) * previousLevel;
            } catch (AbilityScoreOutOfRangeException ex) {
                throw new CombatServiceException(ex);
            }
        	
        	int newMaxHitPoints = 0;
        	try {
        		newMaxHitPoints = (5 + calculateAbilityModifier(AbilityType.STR, request.getAttacker().getConstitution())) * newLevel;
            } catch (AbilityScoreOutOfRangeException ex) {
                throw new CombatServiceException(ex);
            }
        	
        	int currentDamage = previousMaxHitPoints - currentHitPoints;
        	
        	request.getAttacker().setHitPoints(newMaxHitPoints - currentDamage);
        	
        }
        
        return response;
    }

	@Override
	public HealResponse heal(HealRequest request) throws CombatServiceException {
		
        HealResponse response = new HealResponse();
        response.setHealer(request.getHealer());
        response.setRecipient(request.getRecipient());
        
        // calculate max hit points
        int maxHitPoints = 0;
        try {
			maxHitPoints = (5 + calculateAbilityModifier(AbilityType.STR, request.getRecipient().getConstitution())) * request.getRecipient().getLevel();
		} catch (AbilityScoreOutOfRangeException ex) {
            throw new CombatServiceException(ex);
		}
        if (maxHitPoints < 1) {
        	maxHitPoints = 1;
        }
        
        int originalHitPoints = request.getRecipient().getHitPoints();
        int newHitPoints = request.getPointsToHeal() + request.getRecipient().getHitPoints();
        if (newHitPoints > maxHitPoints) {
            request.getRecipient().setHitPoints(maxHitPoints);
            response.setNewHitPoints(maxHitPoints);
            response.setActualPointsHealed(maxHitPoints - originalHitPoints);
        } else {
            request.getRecipient().setHitPoints(newHitPoints);        	
            response.setNewHitPoints(newHitPoints);
            response.setActualPointsHealed(newHitPoints - originalHitPoints);
        }
        
		return response;
	}

    private int calculateAbilityModifier(AbilityType abilityType, int abilityScore) throws AbilityScoreOutOfRangeException {
        int mod;
        switch (abilityScore) {
            case 1:
                mod = -5;
                break;
            case 2:
            case 3:
                mod = -4;
                break;
            case 4:
            case 5:
                mod = -3;
                break;
            case 6:
            case 7:
                mod = -2;
                break;
            case 8:
            case 9:
                mod = -1;
                break;
            case 10:
            case 11:
                mod = 0;
                break;
            case 12:
            case 13:
                mod = +1;
                break;
            case 14:
            case 15:
                mod = +2;
                break;
            case 16:
            case 17:
                mod = +3;
                break;
            case 18:
            case 19:
                mod = +4;
                break;
            case 20:
                mod = +5;
                break;
            default:
                throw new AbilityScoreOutOfRangeException(abilityType, abilityScore);
        }
        return mod;
    }

}
