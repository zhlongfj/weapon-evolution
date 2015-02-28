package weapon;

import player.Player;
import status.Status;

/**
 * Created by zhl on 15/2/28.
 */
public class SharpSword extends Weapon{
    private final int harmTimes;

    public SharpSword(Status status) {
        super(status);
        harmTimes = 3;
    }

    @Override
    public String getName() {
        return "用利剑";
    }

    @Override
    protected String returnHarmDescription(Player player1, Player player2) {
        return player1.getName() + "发动了全力一击,"
                + player2.getName() + "受到了" + player2.retrieveHarmPoint(player1.getAttackPoint())*harmTimes + "点伤害,"
                + player2.getName() + "剩余生命:" + player2.getHealthPoint();
    }

    @Override
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(player1.getAttackPoint());
        player2.reduceHealthPoint(player1.getAttackPoint());
        player2.reduceHealthPoint(player1.getAttackPoint());
    }
}
