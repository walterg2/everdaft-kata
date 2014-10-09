package everdaft.services;

import everdaft.beans.AbilityType;
import everdaft.beans.AttackOutcomeType;
import everdaft.beans.Monster;
import everdaft.beans.NonPlayerCharacter;
import everdaft.beans.PlayerCharacter;
import everdaft.exceptions.AbilityScoreOutOfRangeException;
import everdaft.exceptions.CombatServiceException;

public class CombatServiceImpl implements CombatService {

    @Override
    public CombatResponse attack(CombatRequest request) throws CombatServiceException {
        CombatResponse response = new CombatResponse();

        response.setAttacker(request.getAttacker());
        response.setDefender(request.getDefender());

        int roll = 0;
        int armorClass = 0;
        int standardDamage = 0;
        int criticalDamage = 0;

        try {

            // calculate attack modifier
            int attackModifier = 0;
            if (request.getAttacker() instanceof PlayerCharacter) {
                PlayerCharacter character = (PlayerCharacter) request.getAttacker();
                attackModifier = calculateAbilityModifier(AbilityType.STR, character.getStrength());
            } else if (request.getAttacker() instanceof NonPlayerCharacter) {
                NonPlayerCharacter character = (NonPlayerCharacter) request.getAttacker();
                attackModifier = calculateAbilityModifier(AbilityType.STR, character.getStrength());
            } else {
                Monster monster = (Monster) request.getAttacker();
                attackModifier = monster.getDamageModifier();
            }

            // calculate armor class modifier
            int armorClassModifier = 0;
            if (request.getDefender() instanceof PlayerCharacter) {
                PlayerCharacter character = (PlayerCharacter) request.getDefender();
                armorClass = calculateAbilityModifier(AbilityType.DEX, character.getDexterity());
            } else if (request.getDefender() instanceof NonPlayerCharacter) {
                NonPlayerCharacter character = (NonPlayerCharacter) request.getDefender();
                armorClass = calculateAbilityModifier(AbilityType.DEX, character.getDexterity());
            } else {
                Monster monster = (Monster) request.getAttacker();
                armorClass = monster.getArmorClass();
            }

            // calculate damage modifier
            int damageModifier = 0;
            if (request.getDefender() instanceof PlayerCharacter) {
                PlayerCharacter character = (PlayerCharacter) request.getDefender();
                damageModifier = calculateAbilityModifier(AbilityType.STR, character.getStrength());
            } else if (request.getDefender() instanceof NonPlayerCharacter) {
                NonPlayerCharacter character = (NonPlayerCharacter) request.getDefender();
                damageModifier = calculateAbilityModifier(AbilityType.DEX, character.getStrength());
            } else {
                Monster monster = (Monster) request.getAttacker();
                damageModifier = monster.getDamageModifier();
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

        } catch (AbilityScoreOutOfRangeException ex) {
            throw new CombatServiceException(ex);
        }

        // determine hit or miss and apply damage
        if (roll >= armorClass) {
            if (request.getRoll() == 20) {
                response.setOutcome(AttackOutcomeType.CRITICAL);
                request.getDefender().damage(criticalDamage);
            } else {
                response.setOutcome(AttackOutcomeType.HIT);
                request.getDefender().damage(standardDamage);
            }
        } else {
            response.setOutcome(AttackOutcomeType.MISS);
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
