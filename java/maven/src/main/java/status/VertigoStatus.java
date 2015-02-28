package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/28.
 */
public class VertigoStatus extends Status{
    public VertigoStatus(PrintStream out) {
        super(out);
        times = 2;
    }

    @Override
    public void attack(Player player1, Player player2) {
        times--;
        if (times >= 0) {
            out.println(player1.getName() + "晕倒了,无法攻击,眩晕还剩:" + times + "轮");
        }
    }

    @Override
    public boolean canAttack() {
        return times < 0 ? true : false;
    }
}