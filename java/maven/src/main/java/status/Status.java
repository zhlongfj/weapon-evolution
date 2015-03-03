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
    protected int initialEffectTimes;
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

    public int returnInitialEffectTimes() {
        return initialEffectTimes;
    }

    public int returnAttackPoint() {
        return attackPoint;
    }

    protected void cumulativeTimes(Status status) {
        times += returnInitialEffectTimes();
    }

    protected void cumulativeAttackPoint(Status status) {
        attackPoint += status.returnAttackPoint();
    }

    protected void initState(int times, String effect, int triggerEffectOdds) {
        initialEffectTimes = times;
        this.times = initialEffectTimes;
        this.effect = effect;
        this.triggerEffectOdds = triggerEffectOdds;
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
        } else {
            canTriggerEffect = false;
        }
        return  canTriggerEffect;
    }

    public abstract void delayAttack(Player player1, Player player2);

    public abstract void cumulativeEffect(Status status);

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
