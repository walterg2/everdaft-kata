package everdaft.entities;

public enum CombatantType {

	PC("Player Character"), NPC("Non-player Character"), MONSTER("Monster");
	
	private final String desc;

	CombatantType(final String desc) {
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
