package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/12.
 */
public class IceSword extends Weapon {

    private boolean canAttack;

    public IceSword() {
        canAttack = false;
    }

    @Override
    public String getName() {
        return "用寒冰剑";
    }

    @Override
    protected String returnHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + player2.retrieveHarmPoint(player1.getAttackPoint()) + "点伤害,"
                + player2.getName() + "冻僵了," + player2.getName() + "剩余生命:" + player2.getHealthPoint();
    }

    @Override
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(player1.getAttackPoint());
    }

    @Override
    public void harmDelay(Player player) {
        return ;
    }

    @Override
    public String returnHarmDelayDescription(Player player) {
        return "";
    }
}
