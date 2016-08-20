package everdaft.beans;

public enum AbilityType {
	STR("Strength"), DEX("Dexterity"), CON("Constitution"), INT("Intelligence"), WIS("Wisdom"), CHA("Charisma");
	
	private final String desc;

	AbilityType(final String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return desc;
	}

	public String getDescription() {
		return desc;
	}

}
