package everdaft;

import everdaft.beans.Combatant;
import everdaft.exceptions.CombatServiceException;
import everdaft.factories.CombatServiceFactory;
import everdaft.factories.CombatantFactory;
import everdaft.services.CombatService;
import everdaft.services.requests.AttackRequest;
import everdaft.services.responses.AttackResponse;

public class Everdaft {

	public static void main(String[] args) throws CombatServiceException {
		Everdaft app = new Everdaft();
		app.execute();
	}

	public void execute() throws CombatServiceException {

		Combatant attacker = null;
		Combatant defender = null;

		attacker = CombatantFactory.createCombatant();
		defender = CombatantFactory.createCombatant();

		AttackRequest request = new AttackRequest();
		request.setAttacker(attacker);
		request.setDefender(defender);
		request.setRoll(15);

		CombatService combatService = CombatServiceFactory.createCombatService();
		AttackResponse response = combatService.attack(request);

		System.out.format("Attack was a %s", response.getOutcome());
	}
}
