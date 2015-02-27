package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/27.
 */
public abstract class Status {
    protected PrintStream out;

    protected Status(PrintStream out) {
        this.out = out;
    }

    public abstract void attack(Player player);
}
