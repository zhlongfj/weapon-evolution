package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public abstract class Status {
    protected PrintStream out;
    protected int times;
    protected Random random;
    private int attackPoint;
    protected String effect;
    private boolean canTriggerEffect;
    protected int triggerEffectOdds;

    protected Status(PrintStream out, Random random, int attackPoint) {
        this.out = out;
        this.random = random;
        this.attackPoint = attackPoint;
        canTriggerEffect = false;
    }

    public void delayAttack(Player player1, Player player2) {
        times--;
        if (times >= 0) {
            delayAttackReal(player1, player2);
        }
    }

    public int retrieveHarmPoint(Player player1, Player player2) {
        return player2.retrieveHarmPoint(player1.getAttackPoint() + attackPoint);
    }

    public boolean canAttack() {
        return true;
    }

    public boolean canTriggerEffect() {
        if (random.nextInt(triggerEffectOdds) == 0) {
            canTriggerEffect = true;
        }
        return  canTriggerEffect;
    }

    protected abstract void delayAttackReal(Player player1, Player player2);
    public String retrieveHarmAndEffectDescription(Player player1, Player player2) {
        return retrieveHarmDescription(player1, player2);
    }

    protected String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,";
    }

    protected String retrieveEffectDescription(Player player) {
        return canTriggerEffect ? player.getName() + effect + "," : "";
    }

}
