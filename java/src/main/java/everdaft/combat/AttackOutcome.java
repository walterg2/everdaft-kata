package everdaft.combat;

public enum AttackOutcome {

	HIT("Hit"), MISS("Miss"), CRITICAL("Critical Hit");

	private final String desc;

	AttackOutcome(final String desc) {
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
