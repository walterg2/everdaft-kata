package everdaft.entities;

import java.util.HashMap;

import everdaft.abilities.Ability;
import everdaft.abilities.ModifierCalculator;
import everdaft.alignments.Alignment;
import everdaft.exceptions.AbilityException;
import everdaft.exceptions.AbilityNotFoundException;
import everdaft.exceptions.AbilityScoreOutOfRangeException;

public abstract class Character implements Combatant {

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
        name = "Bob";
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

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return getAbilityModifier(Ability.STR);
    }

    public int getDexterity() {
        return getAbilityModifier(Ability.DEX);
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
        currentHitPoints -= points;
    }

    public void heal(int points) {
        currentHitPoints += points;
        if (hitPoints < 1)
            hitPoints = 1;
        if (currentHitPoints > hitPoints)
            currentHitPoints = hitPoints;
    }

    public boolean isAlive() {
        return currentHitPoints > 0;
    }

    public void setAbilityScore(Ability ability, int score) throws AbilityException {

        ScoreAndModifier scoreAndMod = this.abilities.get(ability);

        if (scoreAndMod == null) {
            throw new AbilityNotFoundException(ability);
        } else {

            // calculate the modifier
            int modifier = calculateModifier(ability, score);
            scoreAndMod.setScore(score);
            scoreAndMod.setModifier(modifier);

            // apply changes to CON
            if (ability == Ability.CON) {
                int damage = hitPoints - currentHitPoints;
                hitPoints = 5 + modifier;
                currentHitPoints = hitPoints - damage;
            }

            // apply changes to DEX
            if (ability == Ability.DEX) {
                armorClass = 10 + modifier;
            }

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
