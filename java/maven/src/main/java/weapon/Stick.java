package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/12.
 */
public class Stick implements Weapon {
    private String name;
    private int attackPoint;

    public Stick() {
        this.attackPoint = 4;
    }

    @Override
    public String getName() {
        return "用优质木棒";
    }

    @Override
    public String getHarmDescription(Player player, int playerAttackPoint) {
        return player.getName() + "受到了" + player.retrieveHarmPoint(playerAttackPoint + attackPoint) + "点伤害,"
                + player.getName() + "剩余生命:" + player.getHealthPoint();
    }

    @Override
    public String harmDelay(Player player) {
        return "";
    }

    @Override
    public void reduceHealthPoint(Player player, int playerAttackPoint) {
        player.reduceHealthPoint(playerAttackPoint + attackPoint);
    }
}
