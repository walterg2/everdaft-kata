package everdaft.entities;

public interface Combatant {

    CombatantType getType();

    void damage(int points);

}
