package everdaft.combat;

import everdaft.entities.Combatant;

public class BasicAttack implements Attack {

	private Combatant attacker;
	private Combatant defender;
	private AttackStatus status;

	public BasicAttack(Combatant attacker, Combatant defender) {
		this.attacker = attacker;
		this.defender = defender;
	}

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
	
	public AttackStatus getStatus() {
		return status;
	}

	public void setStatus(AttackStatus status) {
		this.status = status;
	}

	public void execute(int roll) {
	}

}
