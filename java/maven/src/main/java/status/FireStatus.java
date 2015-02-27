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
    public void attack(Player player) {
        player.reduceHealthPoint(harmPoint);
        out.println("李四受到" + harmPoint + "点火焰伤害,李四剩余生命:" + player.getHealthPoint());
    }
}
