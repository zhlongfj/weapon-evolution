package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public class StickStatus extends Status {

    public StickStatus(PrintStream out, Random random) {
        super(4);
    }

    public boolean canTriggerEffect() {
        return false;
    }

    @Override
    public void reset() {
        return;
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        return;
    }

    @Override
    public void cumulativeEffect(Status status) {
        return;
    }
}
