package everdaft.services;

import everdaft.entities.Combatant;

public class CombatRequest {

	private Combatant attacker;
	private Combatant defender;
	
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

}
