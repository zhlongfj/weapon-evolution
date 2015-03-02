package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public class PoisonStatus extends Status {
    private int harmPoint;

    public PoisonStatus(PrintStream out, Random random) {
        super(out, random, 2);
        times = 2;
        harmPoint = 2;
    }

    public boolean canTriggerEffect() {
        return random.nextInt(2) == 0 ? true : false;
    }

    @Override
    protected void delayAttackReal(Player player1, Player player2) {
        player1.reduceHealthPoint(harmPoint);
        out.println(player1.getName() + "受到" + harmPoint + "点毒性伤害,"
                + player1.getName() + "剩余生命:" + player1.getHealthPoint());
    }

    @Override
    public String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,"
                + player2.getName() + "中毒了,";
    }

   }
