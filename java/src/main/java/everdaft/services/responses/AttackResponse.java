package everdaft.services.responses;

import everdaft.beans.AttackOutcomeType;
import everdaft.beans.Combatant;

public class AttackResponse {

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
