package weapon;

import player.Player;
import status.Status;

/**
 * Created by zhl on 15/2/28.
 */
public class VertigoHammer extends Weapon{
    public VertigoHammer(Status status) {
        super(status);
    }

    @Override
    public String getName() {
        return "用晕锤";
    }

    @Override
    protected String returnHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + player2.retrieveHarmPoint(player1.getAttackPoint()) + "点伤害,"
                + player2.getName() + "晕倒了," + player2.getName() + "剩余生命:" + player2.getHealthPoint();
    }

    @Override
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(player1.getAttackPoint());
    }
}
