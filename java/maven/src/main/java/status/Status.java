package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public abstract class Status {
    protected PrintStream out;
    protected int times;
    protected Random random;
    private int attackPoint;

    protected Status(PrintStream out, Random random, int attackPoint) {
        this.out = out;
        this.random = random;
        this.attackPoint = attackPoint;
    }

    public void attack(Player player1, Player player2) {
        times--;
        if (times >= 0) {
            attackReal(player1, player2);
        }
    }

    //public abstract boolean canTriggerEffect();

    public int retrieveHarmPoint(Player player1, Player player2) {
        return retrieveBaseHarmPoint(player1, player2);
    }

    protected int retrieveBaseHarmPoint(Player player1, Player player2) {
        return player2.retrieveHarmPoint(player1.getAttackPoint() + attackPoint);
    }

    protected abstract void attackReal(Player player1, Player player2);
    public boolean canAttack() {
        return true;
    }
    public abstract String retrieveHarmDescription(Player player1, Player player2);
}
