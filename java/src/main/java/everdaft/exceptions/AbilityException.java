package everdaft.exceptions;

import everdaft.abilities.Ability;

public class AbilityException extends EverdaftException {

	private Ability ability;
	
	public AbilityException(Ability ability) {
		setAbility(ability);
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	@Override
	public String getMessage() {
		return "Ability exception: " + getAbility().getDescription();
	}
	
}
