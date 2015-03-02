package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class FrozenStatus extends Status {
    private int frozenTimes = 2;
    public FrozenStatus(PrintStream out, Random random) {
        super(out, random, 2);
        times = 2;
    }

    @Override
    protected void attackReal(Player player1, Player player2) {
        frozenTimes--;
        if (frozenTimes == 0) {
            out.println(player1.getName() + "冻得直哆嗦，没有击中" + player2.getName());
            frozenTimes = 2;
        } else {
            times++;
        }
    }

    @Override
    public boolean canAttack() {
        return times != 0 ? true : false;
    }

    @Override
    public String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,"
                + player2.getName() + "冻僵了,";
    }

}
