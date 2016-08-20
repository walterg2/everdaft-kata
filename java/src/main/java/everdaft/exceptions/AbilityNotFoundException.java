package everdaft.exceptions;

import everdaft.beans.AbilityType;

public class AbilityNotFoundException extends AbilityException {

	public AbilityNotFoundException(AbilityType ability) {
		super(ability);
	}

	@Override
	public String getMessage() {
		return "Ability not found: " + getAbility().getDescription();
	}
	
	
}
