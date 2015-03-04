package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public abstract class Status {
    protected PrintStream out;
    protected Random random;
    private int attackPoint;

    protected Status(int attackPoint) {
        this.attackPoint = attackPoint;
    }

    public int retrieveHarmPoint(Player player1, Player player2) {
        return player2.retrieveHarmPoint(player1.getAttackPoint() + attackPoint);
    }

    public boolean canAttack() {
        return true;
    }

    public abstract boolean canTriggerEffect();

    public abstract void delayAttack(Player player1, Player player2);

    public abstract void cumulativeEffect(Status status);

    public abstract void reset();

    public String retrieveHarmAndEffectDescription(Player player1, Player player2) {
        return retrieveHarmDescription(player1, player2);
    }

    protected String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,";
    }

    public String attackAndReturnDescription(Player player1, Player player2, String weaponName) {
        if (canTriggerEffect()) {
            player2.setStatus(this);
        }
        reduceHealthPoint(player1, player2);
        return returnDescription(player1, player2, weaponName);
    }

    public void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(retrieveHarmPoint(player1, player2));
    }

    public String returnDescription(Player player1, Player player2, String weaponName) {
        return returnAttackDescription(player1, player2, weaponName)
                + retrieveHarmAndEffectDescription(player1, player2) + returnAttackResult(player2);
    }

    private String returnAttackDescription(Player player1, Player player2, String weaponName) {
        return player1.getNameWithProfession() + weaponName + "攻击了" + player2.getNameWithProfession() + ",";
    }

    private String returnAttackResult(Player player) {
        return player.getName() + "剩余生命:" + player.getHealthPoint();
    }
}
