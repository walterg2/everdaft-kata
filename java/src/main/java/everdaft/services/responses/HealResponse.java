package everdaft.services.responses;

import everdaft.beans.Combatant;

public class HealResponse {

	private Combatant healer;
	private Combatant recipient;
	private int newHitPoints;
	private int actualPointsHealed;

	public Combatant getHealer() {
		return healer;
	}

	public void setHealer(Combatant healer) {
		this.healer = healer;
	}

	public Combatant getRecipient() {
		return recipient;
	}

	public void setRecipient(Combatant recipient) {
		this.recipient = recipient;
	}

	public int getNewHitPoints() {
		return newHitPoints;
	}

	public void setNewHitPoints(int newHitPoints) {
		this.newHitPoints = newHitPoints;
	}

	public int getActualPointsHealed() {
		return actualPointsHealed;
	}

	public void setActualPointsHealed(int actualPointsHealed) {
		this.actualPointsHealed = actualPointsHealed;
	}

}
