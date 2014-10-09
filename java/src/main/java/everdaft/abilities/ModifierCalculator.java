package everdaft.abilities;

import everdaft.beans.AbilityType;
import everdaft.exceptions.AbilityScoreOutOfRangeException;

public class ModifierCalculator {

	public int calculate(AbilityType ability, int score) throws AbilityScoreOutOfRangeException {
		int mod;
		switch (score) {
			case 1:
				mod = -5; break;
			case 2:
			case 3:
				mod = -4; break;
			case 4:
			case 5:
				mod = -3; break;
			case 6:
			case 7:
				mod = -2; break;
			case 8:
			case 9:
				mod = -1; break;
			case 10:
			case 11:
				mod = 0; break;
			case 12:
			case 13:
				mod = +1; break;
			case 14:
			case 15:
				mod = +2; break;
			case 16:
			case 17:
				mod = +3; break;
			case 18:
			case 19:
				mod = +4; break;
			case 20:
				mod = +5; break;
			default:
				throw new AbilityScoreOutOfRangeException(ability, score);
		}
		return mod;
	}

}
