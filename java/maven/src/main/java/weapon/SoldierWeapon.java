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
    protected String returnHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + player2.retrieveHarmPoint(player1.getAttackPoint()) + "点伤害,"
                + player2.getName() + status.retrieveHarmDescription(player1, player2) + player2.getName() + "剩余生命:" + player2.getHealthPoint();
    }

    @Override
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(status.retrieveAttackPoint(player1.getAttackPoint()));
    }
}
