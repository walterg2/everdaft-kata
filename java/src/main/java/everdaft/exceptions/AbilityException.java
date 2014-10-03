package everdaft.exceptions;

import everdaft.entities.AbilityType;

public class AbilityException extends EverdaftException {

	private AbilityType ability;
	
	public AbilityException(AbilityType ability) {
		setAbility(ability);
	}

	public AbilityType getAbility() {
		return ability;
	}

	public void setAbility(AbilityType ability) {
		this.ability = ability;
	}

	@Override
	public String getMessage() {
		return "Ability exception: " + getAbility().getDescription();
	}
	
}
