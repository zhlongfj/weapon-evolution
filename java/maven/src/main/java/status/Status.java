package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/27.
 */
public abstract class Status {
    protected PrintStream out;
    protected int times;
    protected Status(PrintStream out) {
        this.out = out;
    }

    public abstract void attack(Player player1, Player player2);
    public abstract boolean canAttack();
    public abstract String retrieveHarmDescription(Player player1, Player player2);
    public abstract int retrieveHarmPoint(int attackPoint, Player player);
}
