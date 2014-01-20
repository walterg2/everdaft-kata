package everdaft.alignments;

public enum Alignment {
	GOOD("Good"), NEUTRAL("Neutral"), EVIL("Evil");
	
	private final String desc;

	Alignment(final String desc) {
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
