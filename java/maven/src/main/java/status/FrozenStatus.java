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
        initState(2, "冻僵了", 2);
    }

    public boolean canAttack() {
        return times != 0 ? true : false;
    }

    public String retrieveHarmAndEffectDescription(Player player1, Player player2) {
        return super.retrieveHarmDescription(player1, player2) + retrieveEffectDescription(player2);
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        times--;
        if (times >= 0) {
            frozenTimes--;
            if (frozenTimes == 0) {
                out.println(player1.getName() + "冻得直哆嗦，没有击中" + player2.getName());
                frozenTimes = 2;
            } else {
                times++;
            }
        } else {
            //player1.setStatus();
        }
    }

    @Override
    public void cumulativeEffect(Status status) {
        cumulativeTimes(status);
    }
}
