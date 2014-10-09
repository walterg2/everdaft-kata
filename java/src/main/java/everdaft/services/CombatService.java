package everdaft.services;

import everdaft.exceptions.CombatServiceException;
import everdaft.services.requests.AttackRequest;
import everdaft.services.requests.HealRequest;
import everdaft.services.responses.AttackResponse;
import everdaft.services.responses.HealResponse;

public interface CombatService {
    AttackResponse attack(AttackRequest request) throws CombatServiceException;
    HealResponse heal(HealRequest request) throws CombatServiceException;
}
