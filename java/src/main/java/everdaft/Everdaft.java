package everdaft;

import everdaft.combat.Attack;
import everdaft.combat.BasicAttack;
import everdaft.entities.Combatant;
import everdaft.entities.NonPlayerCharacter;
import everdaft.entities.PlayerCharacter;

public class Everdaft {

	/**
	 * The main method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Everdaft app = new Everdaft();
		app.execute();
	}
	
	public void execute() {
		Combatant attacker = new PlayerCharacter();
		Combatant defender = new NonPlayerCharacter();
		Attack attack = new BasicAttack(attacker, defender);
		attack.execute(10);
		System.out.format("Attack was a %s", attack.getStatus());
	}

}
