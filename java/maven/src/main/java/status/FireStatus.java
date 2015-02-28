package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/27.
 */
public class FireStatus extends Status{

    private int harmPoint;

    public FireStatus(PrintStream out) {
        super(out);
        this.harmPoint = 2;
    }

    @Override
    public void attack(Player player1, Player player2) {
        player1.reduceHealthPoint(harmPoint);
        out.println(player1.getName() + "受到" + harmPoint + "点火焰伤害,"
                + player1.getName() + "剩余生命:" + player1.getHealthPoint());
    }

    @Override
    public boolean canAttack() {
        return true;
    }
}