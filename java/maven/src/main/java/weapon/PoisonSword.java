package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/12.
 */
public class PoisonSword extends Weapon {

    private final int extraHarm;

    public PoisonSword() {
        extraHarm = 2;
    }

    @Override
    public String getName() {
        return "用毒剑";
    }

    @Override
    protected String returnHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + player2.retrieveHarmPoint(player1.getAttackPoint()) + "点伤害,"
                + player2.getName() + "中毒了," + player2.getName() + "剩余生命:" + player2.getHealthPoint();
    }

    @Override
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(player1.getAttackPoint());
    }

    @Override
    public void  harmDelay(Player player) {
        player.reduceHealthPoint(extraHarm);
    }

    @Override
    public String returnHarmDelayDescription(Player player) {
        return player.getName() + "受到" + extraHarm + "点毒性伤害,"
                + player.getName() + "剩余生命:" + player.getHealthPoint();
    }
}
