package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public class NormalStatus extends Status {

    public NormalStatus(int attackPoint, PrintStream out, Random random) {
        super(out, random, attackPoint);
        times = 0;
    }

    @Override
    public int retrieveHarmPoint(Player player1, Player player2) {
        return retrieveBaseHarmPoint(player1, player2);
    }

    @Override
    protected void attackReal(Player player1, Player player2) {
        return;
    }

    @Override
    public String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,";
    }

}
