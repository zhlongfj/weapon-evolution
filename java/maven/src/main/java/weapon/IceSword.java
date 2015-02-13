package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/12.
 */
public class IceSword implements Weapon {

    private boolean frozen;

    public IceSword() {
        frozen = false;
    }

    @Override
    public String getName() {
        return "用寒冰剑";
    }

    @Override
    public String getHarmDescription(Player player, int playerAttackPoint) {
        return player.getName() + "受到了" + player.retrieveHarmPoint(playerAttackPoint) + "点伤害,"
                + player.getName() + "冻僵了," + player.getName() + "剩余生命:" + player.getHealthPoint();
    }

    @Override
    public String harmDelay(Player player) {
        return "";
    }

    @Override
    public void reduceHealthPoint(Player player, int playerAttackPoint) {
        player.reduceHealthPoint(playerAttackPoint);
    }
}
