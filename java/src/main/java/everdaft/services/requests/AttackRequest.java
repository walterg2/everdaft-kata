package everdaft.services.requests;

import everdaft.beans.Combatant;

public class AttackRequest {

    private Combatant attacker;
    private Combatant defender;
    private int roll;

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

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

}
