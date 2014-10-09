package everdaft.beans;

public enum AlignmentType {
	GOOD("Good"), NEUTRAL("Neutral"), EVIL("Evil");
	
	private final String desc;

	AlignmentType(final String desc) {
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
