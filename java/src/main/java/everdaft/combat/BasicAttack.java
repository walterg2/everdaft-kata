package everdaft.combat;

import everdaft.entities.Combatant;

public class BasicAttack implements Attack {

	public BasicAttack(Combatant attacker, Combatant defender) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public AttackStatus getStatus() {
		return AttackStatus.HIT;
	}

}
