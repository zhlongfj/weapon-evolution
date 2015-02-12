package player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/12.
 */
public class OrdinaryPlayer extends Player {

    private int attackPoint;

    public OrdinaryPlayer(PrintStream out, String name, int healthPoint, int attackPoint) {
        super(out, name, healthPoint, attackPoint);
        this.attackPoint = attackPoint;

        profession = "普通人";
    }

    @Override
    public boolean canAttack() {
        return healthPoint > 0 ? true : false;
    }

    @Override
    public void reduceHealthPoint(int attackedPoint) {
        this.attackedPoint = attackedPoint;
        healthPoint -= attackedPoint;
    }

    @Override
    protected int getAttackPoint() {
        return attackPoint;
    }
}