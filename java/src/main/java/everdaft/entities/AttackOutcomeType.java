package everdaft.entities;

public enum AttackOutcomeType {

	HIT("Hit"), MISS("Miss"), CRITICAL("Critical Hit");

	private final String desc;

	AttackOutcomeType(final String desc) {
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
