package everdaft.beans;

public class NonPlayerCharacter extends Character implements Combatant {

    @Override
    public CombatantType getType() {
        return CombatantType.NPC;
    }

}
