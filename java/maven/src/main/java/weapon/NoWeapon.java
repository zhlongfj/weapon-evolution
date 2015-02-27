package weapon;

import player.Player;
import status.Status;

/**
 * Created by zhl on 15/2/12.
 */
public class NoWeapon extends Weapon {
    public NoWeapon(Status status) {
        super(status);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String returnHarmDescription(Player playe1, Player player2) {
        return player2.getName() + "受到了" + player2.retrieveHarmPoint(playe1.getAttackPoint()) + "点伤害,"
                + player2.getName() + "剩余生命:" + player2.getHealthPoint();
    }

    @Override
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(player1.getAttackPoint());
    }
}
