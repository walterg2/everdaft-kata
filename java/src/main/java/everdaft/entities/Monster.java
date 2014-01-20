package everdaft.entities;


public class Monster implements Combatant {

	public int getArmorClass() {
		return 10;
	}

	public void damage(int points) {
	}

	public int getDamageModifier() {
		return 0;
	}

	public int getAttackModifier() {
		return 0;
	}

}
