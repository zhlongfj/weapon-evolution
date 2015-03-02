package weapon;

import player.Player;
import status.Status;

/**
 * Created by zhl on 15/2/13.
 */
public abstract class Weapon {

    protected Status status;

    public abstract String getName();
    public String attackAndReturnDescription(Player player1, Player player2) {
        if (status.canTriggerEffect()) {
            setStatus(player2);
        }
        reduceHealthPoint(player1, player2);
        return returnDescription(player1, player2);
    }

    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(status.retrieveHarmPoint(player1, player2));
    }

    public void setStatus(Player player) {
        player.setStatus(status);
    }

    public String returnDescription(Player player1, Player player2) {
        return returnAttackDescription(player1, player2)
                + status.retrieveHarmAndEffectDescription(player1, player2) + returnAttackResult(player2);
    }

    private String returnAttackDescription(Player player1, Player player2) {
        return player1.getNameWithProfession() + getName() + "攻击了" + player2.getNameWithProfession() + ",";
    }

    private String returnAttackResult(Player player) {
        return player.getName() + "剩余生命:" + player.getHealthPoint();
    }
}
