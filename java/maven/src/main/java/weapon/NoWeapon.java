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
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(player2.retrieveHarmPoint(player1.getAttackPoint()));
    }
}
