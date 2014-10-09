package everdaft.factories;

import everdaft.beans.Combatant;
import everdaft.beans.CombatantType;
import everdaft.beans.Monster;
import everdaft.beans.NonPlayerCharacter;
import everdaft.beans.PlayerCharacter;
import everdaft.exceptions.EverdaftException;

public class CombatantFactory {

    public static Combatant createCombatant(CombatantType type) throws EverdaftException {
        Combatant combatant = null;
        switch (type) {
            case PC:
                combatant = new PlayerCharacter();
                break;

            case NPC:
                combatant = new NonPlayerCharacter();
                break;

            case MONSTER:
                combatant = new Monster();
                break;

            default:
                throw new EverdaftException();

        }
        return combatant;
    }
}
