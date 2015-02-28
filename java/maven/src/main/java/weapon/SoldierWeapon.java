package weapon;

import player.Player;
import status.Status;

/**
 * Created by zhl on 15/2/28.
 */
public class SoldierWeapon extends Weapon{
    private String name;
    public SoldierWeapon(String name, Status status) {
        super(status);
        this.name = "用" + name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(status.retrieveHarmPoint(player1.getAttackPoint(), player2));
    }
}
