package everdaft.beans;

public class ScoreAndModifier {

	private int score;
	private int modifier;

	public ScoreAndModifier(int i, int j) {
		this.setScore(i);
		this.setModifier(j);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}

}
