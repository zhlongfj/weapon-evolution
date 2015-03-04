package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public abstract class Status {
    protected PrintStream out;
    protected Random random;
    private int attackPoint;

    protected Status(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public int retrieveHarmPoint(Player player1, Player player2) {
        return player2.retrieveHarmPoint(player1.getAttackPoint() + attackPoint);
    }

    public boolean canAttack() {
        return true;
    }

    public abstract boolean canTriggerEffect();

    public abstract void delayAttack(Player player1, Player player2);

    public abstract void cumulativeEffect(Status status);

    public abstract void reset();

    public String retrieveHarmAndEffectDescription(Player player1, Player player2) {
        return retrieveHarmDescription(player1, player2);
    }

    protected String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,";
    }

}
