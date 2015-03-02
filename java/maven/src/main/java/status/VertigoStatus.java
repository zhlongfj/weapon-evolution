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
        times = 2;
    }

    @Override
    protected void delayAttackReal(Player player1, Player player2) {
        out.println(player1.getName() + "晕倒了,无法攻击,眩晕还剩:" + times + "轮");
    }

    public boolean canAttack() {
        return times < 0 ? true : false;
    }

    @Override
    public String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,"
                + player2.getName() + "晕倒了,";
    }
}
