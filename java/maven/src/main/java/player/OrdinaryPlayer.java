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
    public void attack(Player player2) {
        player2.reduceHealthPoint(getAttackPoint());
        out.println(profession + name + "攻击了" + player2.getProfession() + player2.getName() + ","
                + player2.getName() + "受到了" + player2.getHarmPoint() + "点伤害,"
                + player2.getName() + "剩余生命:" + player2.getHealthPoint());
    }

    @Override
    public void reduceHealthPoint(int attackedPoint) {
        this.harmPoint = attackedPoint;
        healthPoint -= attackedPoint;
    }

    @Override
    protected int getAttackPoint() {
        return attackPoint;
    }
}
