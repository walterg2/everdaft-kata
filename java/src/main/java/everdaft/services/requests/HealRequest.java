package everdaft.services.requests;

import everdaft.beans.Combatant;

public class HealRequest {
	
	private Combatant healer;
	private Combatant recipient;
	private int pointsToHeal;

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

	public int getPointsToHeal() {
		return pointsToHeal;
	}

	public void setPointsToHeal(int pointsToHeal) {
		this.pointsToHeal = pointsToHeal;
	}
}
