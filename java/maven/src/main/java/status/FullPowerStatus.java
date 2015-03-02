package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class FullPowerStatus extends Status{
    private final int attackPointTimes = 3;
    public FullPowerStatus(PrintStream out, Random random) {
        super(out, random, 2);
        times = 0;

    }

    @Override
    public int retrieveHarmPoint(Player player1, Player player2) {
        return retrieveBaseHarmPoint(player1, player2) * attackPointTimes;
    }

    @Override
    protected void attackReal(Player player1, Player player2) {

    }

    public boolean canAttack() {
        return false;
    }

    @Override
    public String retrieveHarmDescription(Player player1, Player player2) {
        return player1.getName() + "发动了全力一击,"
                + player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,";
    }

  }
