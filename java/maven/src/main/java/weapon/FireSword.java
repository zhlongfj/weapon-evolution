package weapon;

import player.Player;
import status.Status;

/**
 * Created by zhl on 15/2/12.
 */
public class FireSword extends Weapon {

    public FireSword(Status status) {
        super(status);
    }

    @Override
    public String getName() {
        return "用火焰剑";
    }

    @Override
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(player1.getAttackPoint());
    }

    @Override
    public String returnHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + player2.retrieveHarmPoint(player1.getAttackPoint()) + "点伤害,"
                + player2.getName() + "着火了," + player2.getName() + "剩余生命:" + player2.getHealthPoint();
    }
}
