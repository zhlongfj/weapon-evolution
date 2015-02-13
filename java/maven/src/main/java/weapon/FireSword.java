package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/12.
 */
public class FireSword implements Weapon {

    private final int extraHarm;

    public FireSword() {
        extraHarm = 2;
    }

    @Override
    public String getName() {
        return "用火焰剑";
    }

    @Override
    public int retrieveAttackPoint(int sourceAttackPoint) {
        return sourceAttackPoint;
    }

    @Override
    public String getHarmDescription(Player player, int playerAttackPoint) {
        return player.getName() + "受到了" + player.retrieveHarmPoint(retrieveAttackPoint(playerAttackPoint)) + "点伤害,"
                + player.getName() + "着火了," + player.getName() + "剩余生命:" + player.getHealthPoint();
    }

    @Override
    public String harmDelay(Player player) {
        player.reduceHealthPoint(extraHarm);
        return player.getName() + "受到" + extraHarm + "点火焰伤害,"
                + player.getName() + "剩余生命:" + player.getHealthPoint();
    }
}
