package everdaft.exceptions;

import everdaft.beans.AbilityType;

public class AbilityScoreOutOfRangeException extends AbilityException {

	private int score;
	
	public AbilityScoreOutOfRangeException(AbilityType ability, int score) {
		super(ability);
		setScore(score);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String getMessage() {
		return "Ability out of range exception. Treid to set " + getAbility().getDescription() + " to " + getScore();
	}
	
	
}
