package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/13.
 */
public abstract class Weapon {
    public abstract String getName();
    protected abstract String returnHarmDescription(Player player1, Player player2);
    public abstract void reduceHealthPoint(Player player1, Player player2);
    public abstract void harmDelay(Player player);
    public abstract String returnHarmDelayDescription(Player player);

    public String returnDescription(Player player1, Player player2) {
        return returnAttackDescription(player1, player2) + returnHarmDescription(player1, player2);
    }

    private String returnAttackDescription(Player player1, Player player2) {
        return player1.getNameWithProfession() + getName() + "攻击了" + player2.getNameWithProfession() + ",";
    }

}
