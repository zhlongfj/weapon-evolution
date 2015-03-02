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
        times = 0;
        effect = "";
    }

    public boolean canTriggerEffect() {
        return false;
    }

    @Override
    protected void delayAttackReal(Player player1, Player player2) {
        return;
    }
}
