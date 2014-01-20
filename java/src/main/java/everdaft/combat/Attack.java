package everdaft.combat;

public interface Attack {

	void execute(int roll);

	AttackStatus getStatus();

}
