package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/12.
 */
public class Stick extends Weapon {
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
    protected String returnHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + player2.retrieveHarmPoint(player1.getAttackPoint() + attackPoint) + "点伤害,"
                + player2.getName() + "剩余生命:" + player2.getHealthPoint();
    }

    @Override
    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(player1.getAttackPoint() + attackPoint);
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
