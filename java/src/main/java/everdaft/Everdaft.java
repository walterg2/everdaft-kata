package everdaft;

import everdaft.beans.Combatant;
import everdaft.beans.CombatantType;
import everdaft.exceptions.CombatServiceException;
import everdaft.exceptions.EverdaftException;
import everdaft.factories.CombatServiceFactory;
import everdaft.factories.CombatantFactory;
import everdaft.services.CombatRequest;
import everdaft.services.CombatResponse;
import everdaft.services.CombatService;

public class Everdaft {

    public static void main(String[] args) throws CombatServiceException {
        Everdaft app = new Everdaft();
        app.execute();
    }

    public void execute() throws CombatServiceException {

        Combatant attacker = null;
        Combatant defender = null;

        try {
            attacker = CombatantFactory.createCombatant(CombatantType.PC);
            defender = CombatantFactory.createCombatant(CombatantType.NPC);
        } catch (EverdaftException e) {
        }

        CombatRequest request = new CombatRequest();
        request.setAttacker(attacker);
        request.setDefender(defender);
        request.setRoll(15);

        CombatService combatService = CombatServiceFactory.createCombatService();
        CombatResponse response = combatService.attack(request);

        System.out.format("Attack was a %s", response.getOutcome());
    }
}
