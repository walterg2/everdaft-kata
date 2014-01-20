package everdaft.entities;


public class PlayerCharacter extends Character implements Combatant {
	
	private String playerName = "Alice";

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
