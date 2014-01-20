package everdaft.entities;

public interface Combatant {

	int getArmorClass();

	void damage(int points);

	int getDamageModifier();

	int getAttackModifier();

}
