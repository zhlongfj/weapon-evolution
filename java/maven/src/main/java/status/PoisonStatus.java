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
        effect = "中毒了";
        triggerEffectOdds = 2;
    }

    public String retrieveHarmAndEffectDescription(Player player1, Player player2) {
        return super.retrieveHarmDescription(player1, player2) + retrieveEffectDescription(player2);
    }

    @Override
    protected void delayAttackReal(Player player1, Player player2) {
        player1.reduceHealthPoint(harmPoint);
        out.println(player1.getName() + "受到" + harmPoint + "点毒性伤害,"
                + player1.getName() + "剩余生命:" + player1.getHealthPoint());
    }
   }
