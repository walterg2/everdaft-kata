package everdaft.services;

import everdaft.exceptions.CombatServiceException;

public interface CombatService {
    CombatResponse attack(CombatRequest request) throws CombatServiceException;
}
