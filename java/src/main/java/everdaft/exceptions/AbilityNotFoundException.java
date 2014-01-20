package everdaft.exceptions;

import everdaft.abilities.Ability;

public class AbilityNotFoundException extends AbilityException {

	public AbilityNotFoundException(Ability ability) {
		super(ability);
	}

	@Override
	public String getMessage() {
		return "Ability not found: " + getAbility().getDescription();
	}
	
	
}
