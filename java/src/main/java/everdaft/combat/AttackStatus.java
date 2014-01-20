package everdaft.combat;

public enum AttackStatus {

	HIT("Hit"), MISS("Miss"), CRITICAL("Critical Hit");

	private final String desc;

	AttackStatus(final String desc) {
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
