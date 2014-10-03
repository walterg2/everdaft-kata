package everdaft.services;

import everdaft.entities.AttackOutcomeType;
import everdaft.entities.Combatant;

public class CombatResponse {

    private Combatant attacker;
    private Combatant defender;
    private AttackOutcomeType outcome;

    public Combatant getAttacker() {
        return attacker;
    }

    public void setAttacker(Combatant attacker) {
        this.attacker = attacker;
    }

    public Combatant getDefender() {
        return defender;
    }

    public void setDefender(Combatant defender) {
        this.defender = defender;
    }

    public AttackOutcomeType getOutcome() {
        return outcome;
    }

    public void setOutcome(AttackOutcomeType outcome) {
        this.outcome = outcome;
    }

}
