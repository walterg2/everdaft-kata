package everdaft.combat;

import everdaft.entities.Combatant;

public class BasicAttack implements Attack {

	private Combatant attacker;
	private Combatant defender;
	private AttackOutcome status;

	public BasicAttack(Combatant attacker, Combatant defender) {
		this.attacker = attacker;
		this.defender = defender;
	}

	public Combatant getAttacker() {
		return attacker;
	}

	public void setAttacker(Combatant attacker) {
		this.attacker = attacker;
	}

	public Combatant getDefender() {
		return defender;
	}

	public void setDefender(Combatant defender) {
		this.defender = defender;
	}

	public AttackOutcome getStatus() {
		return status;
	}

	public void setStatus(AttackOutcome status) {
		this.status = status;
	}

	public void execute(int roll) {

		// determine hit or miss and apply damage
		if (roll + attacker.getAttackModifier() >= defender.getArmorClass()) {

			// do more damage on a critical hit
			if (roll == 20) {
				
				this.status = AttackOutcome.CRITICAL;
				if (2 + attacker.getDamageModifier() * 2 > 0) {
					defender.damage(2 + attacker.getDamageModifier() * 2);
				} else {
					defender.damage(1);
				}

			} else {

				this.status = AttackOutcome.HIT;
				if (1 + attacker.getDamageModifier() > 0) {
					defender.damage(1 + attacker.getDamageModifier());
				} else {
					defender.damage(1);
				}
			}

		} else {
			this.status = AttackOutcome.MISS;
		}

	}

}
