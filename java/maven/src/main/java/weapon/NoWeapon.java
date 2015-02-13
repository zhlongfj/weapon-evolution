package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/12.
 */
public class NoWeapon implements Weapon {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public int retrieveAttackPoint(int sourceAttackPoint) {
        return sourceAttackPoint;
    }

    @Override
    public String getHarmDescription(Player player, int playerAttackPoint) {
        return player.getName() + "受到了" + player.retrieveHarmPoint(retrieveAttackPoint(playerAttackPoint)) + "点伤害,"
                + player.getName() + "剩余生命:" + player.getHealthPoint();
    }

    @Override
    public String harmDelay(Player player) {
        return "";
    }
}
