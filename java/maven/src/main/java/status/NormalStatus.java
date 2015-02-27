package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/27.
 */
public class NormalStatus extends Status {
    public NormalStatus(PrintStream out) {
        super(out);
    }

    @Override
    public void attack(Player player) {
        return;
    }
}
