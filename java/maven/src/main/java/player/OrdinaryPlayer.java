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
        healthPoint -= attackedPoint;
    }

    private String retrieveDescription(Player player) {
        return getNameWithProfession() + "攻击了" + player.getNameWithProfession() + ","
                + player.getName() + "受到了" + player.retrieveHarmPoint(attackPoint) + "点伤害,"
                 + player.getName() + "剩余生命:" + player.getHealthPoint();
    }

    @Override
    public int retrieveHarmPoint(int harmPoint) {
        return harmPoint;
    }

    @Override
    public void attack(Player player2) {
        status.attack(this, player2);
        if (status.canAttack()) {
            player2.reduceHealthPoint(player2.retrieveHarmPoint(attackPoint));
            out.println(retrieveDescription(player2));
        }
    }
}
