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
        times = 2;
        this.delayHarmPoint = 2;
    }

    @Override
    public int retrieveHarmPoint(Player player1, Player player2) {
        return retrieveBaseHarmPoint(player1, player2);
    }

    @Override
    protected void attackReal(Player player1, Player player2) {
        player1.reduceHealthPoint(delayHarmPoint);
        out.println(player1.getName() + "受到" + delayHarmPoint + "点火焰伤害,"
                + player1.getName() + "剩余生命:" + player1.getHealthPoint());
    }

    @Override
    public String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,"
                + player2.getName() + "着火了,";
    }
}
