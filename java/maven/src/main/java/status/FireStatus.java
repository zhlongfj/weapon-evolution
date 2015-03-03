package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public class FireStatus extends Status {

    private int delayHarmPoint;

    public FireStatus(PrintStream out, Random random) {
        super(out, random, 2);
        initState(2, "着火了", 2);
        this.delayHarmPoint = 2;
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
            player1.reduceHealthPoint(delayHarmPoint);
            out.println(player1.getName() + "受到" + delayHarmPoint + "点火焰伤害,"
                    + player1.getName() + "剩余生命:" + player1.getHealthPoint());
        } else {
            //player1.setStatus();
        }
    }

    @Override
    public void cumulativeEffect(Status status) {
        cumulativeTimes(status);
        cumulativeAttackPoint(status);
    }
}
