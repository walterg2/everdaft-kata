package everdaft.entities;

import java.util.HashMap;

import everdaft.abilities.Ability;
import everdaft.abilities.ModifierCalculator;
import everdaft.alignments.Alignment;
import everdaft.exceptions.AbilityException;
import everdaft.exceptions.AbilityNotFoundException;
import everdaft.exceptions.AbilityScoreOutOfRangeException;

public class Character {

	private String name;
	private Alignment alignment;
	private int armorClass;
	private int hitPoints;
	private int currentHitPoints;
	
	private HashMap<Ability, ScoreAndModifier> abilities = new HashMap<Ability, ScoreAndModifier>();

	public Character() {
		
		// setup initial ability scores
		abilities.put(Ability.STR, new ScoreAndModifier(10, 0));
		abilities.put(Ability.DEX, new ScoreAndModifier(10, 0));
		abilities.put(Ability.CON, new ScoreAndModifier(10, 0));
		abilities.put(Ability.INT, new ScoreAndModifier(10, 0));
		abilities.put(Ability.WIS, new ScoreAndModifier(10, 0));
		abilities.put(Ability.CHA, new ScoreAndModifier(10, 0));
		
		// default name and alignment
		name = "New Character";
		alignment = Alignment.NEUTRAL;
		
		// armor class and hit points
		armorClass = 10;
		hitPoints = 5;
		currentHitPoints = 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public HashMap<Ability, ScoreAndModifier> getAbilities() {
		return abilities;
	}

	public void setAbilities(HashMap<Ability, ScoreAndModifier> abilities) {
		this.abilities = abilities;
	}
	
	public int getCurrentHitPoints() {
		return currentHitPoints;
	}

	public void damage(int points) {
		currentHitPoints -= this.getHitPoints();
	}
	
	public void setAbilityScore(Ability ability, int score) throws AbilityException {
		ScoreAndModifier scoreAndMod = this.abilities.get(ability);
		if (scoreAndMod == null) {
			throw new AbilityNotFoundException(ability);
		} else {
			int modifier = calculateModifier(ability, score);
			scoreAndMod.setScore(score);
			scoreAndMod.setModifier(modifier);
		}
	}
	
	public int getAbilityModifier(Ability ability) {
		ScoreAndModifier scoreAndMod = this.abilities.get(ability);
		if (scoreAndMod == null) {
			throw new IllegalArgumentException();
		}
		return scoreAndMod.getModifier();
	}

	private int calculateModifier(Ability ability, int score) throws AbilityScoreOutOfRangeException {
		ModifierCalculator calc = new ModifierCalculator();
		return calc.calculate(ability, score);
	}

}
