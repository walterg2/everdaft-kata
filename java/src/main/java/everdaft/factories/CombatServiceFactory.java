package everdaft.factories;

import everdaft.services.CombatService;
import everdaft.services.CombatServiceImpl;

public class CombatServiceFactory {

    private static CombatService combatService;

    public static CombatService createCombatService() {
        if (combatService != null) {
            return combatService;
        } else {
            combatService = new CombatServiceImpl();
        }
        return combatService;
    }

}
