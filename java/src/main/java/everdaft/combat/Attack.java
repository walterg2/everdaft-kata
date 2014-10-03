package everdaft.combat;

import everdaft.entities.Combatant;

public interface Attack {

	void execute(int roll);

	AttackOutcome getStatus();
	Combatant getAttacker();
	Combatant getDefender();

}
