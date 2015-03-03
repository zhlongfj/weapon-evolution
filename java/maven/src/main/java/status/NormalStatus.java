package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public class NormalStatus extends Status {

    public NormalStatus(int attackPoint, PrintStream out, Random random) {
        super(out, random, attackPoint);
        initState(0, "", 0);
    }

    public boolean canTriggerEffect() {
        return false;
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
