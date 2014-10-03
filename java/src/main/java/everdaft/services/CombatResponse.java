package everdaft.services;

import everdaft.combat.AttackOutcome;
import everdaft.entities.Combatant;

public class CombatResponse {

    private Combatant attacker;
    private Combatant defender;
    private AttackOutcome outcome;

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

    public AttackOutcome getOutcome() {
        return outcome;
    }

    public void setOutcome(AttackOutcome outcome) {
        this.outcome = outcome;
    }

}
