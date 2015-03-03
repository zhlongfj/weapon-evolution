package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class VertigoStatus extends Status{
    public VertigoStatus(PrintStream out, Random random) {
        super(out, random, 2);
        initState(2, "晕倒了", 2);
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        if (times-- > 0) {
            out.println(player1.getName() + "晕倒了,无法攻击,眩晕还剩:" + times + "轮");
        } else {
            times = initialEffectTimes;
            player1.setStatus(new NormalStatus(0, out, null));
        }
    }

    public String retrieveHarmAndEffectDescription(Player player1, Player player2) {
        return super.retrieveHarmDescription(player1, player2) + retrieveEffectDescription(player2);
    }

    public boolean canAttack() {
        return times < 0 ? true : false;
    }

    @Override
    public void cumulativeEffect(Status status) {
        cumulativeTimes(status);
    }
}
