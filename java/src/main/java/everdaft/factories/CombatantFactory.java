package everdaft.factories;

import everdaft.entities.CombatantType;
import everdaft.entities.Combatant;
import everdaft.entities.Monster;
import everdaft.entities.NonPlayerCharacter;
import everdaft.entities.PlayerCharacter;
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
