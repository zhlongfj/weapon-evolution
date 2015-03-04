package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/3/3.
 */
public class NormalStatus extends Status{
    public NormalStatus(PrintStream out) {
        super(out, 0, "");
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        return;
    }

    @Override
    protected boolean canTriggerEffect() {
        return false;
    }

    @Override
    protected void cumulativeEffect(Status status) {
        return;
    }

    @Override
    protected void reset() {
        return;
    }
}
