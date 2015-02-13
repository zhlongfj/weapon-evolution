package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/12.
 */
public class PoisonSword implements Weapon {

    private final int extraHarm;

    public PoisonSword() {
        extraHarm = 2;
    }

    @Override
    public String getName() {
        return "用毒剑";
    }

    @Override
    public int retrieveAttackPoint(int sourceAttackPoint) {
        return sourceAttackPoint;
    }

    @Override
    public String getHarmDescription(Player player, int playerAttackPoint) {
        return player.getName() + "受到了" + player.retrieveHarmPoint(retrieveAttackPoint(playerAttackPoint)) + "点伤害,"
                + player.getName() + "中毒了," + player.getName() + "剩余生命:" + player.getHealthPoint();
    }

    @Override
    public String  harmDelay(Player player) {
        player.reduceHealthPoint(extraHarm);
        return player.getName() + "受到" + extraHarm + "点毒性伤害,"
                + player.getName() + "剩余生命:" + player.getHealthPoint();
    }
}
