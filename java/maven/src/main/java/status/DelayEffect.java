package status;

import player.Player;

/**
 * Created by zhl on 15/3/3.
 */
public class DelayEffect {

    private final int initialEffectTimes;
    private int times;
    private final int initialDelayHarmPoint;
    private int harmPoint;

    public DelayEffect(int times, int harmPoint) {
        initialEffectTimes = times;
        this.times = initialEffectTimes;

        initialDelayHarmPoint = harmPoint;
        this.harmPoint = initialDelayHarmPoint;
    }

    public boolean delayAttack(Player player1) {
        if (--times >= 0) {
            player1.reduceHealthPoint(harmPoint);
            return true;
        } else {
            player1.setNormalState();
            return false;
        }
    }

    public void attack(Player player, Status status) {
        Status playerStatus = player.returnAttackedStatus();
        if (status.getClass() == playerStatus.getClass()) {
            cumulativeEffect();
        } else {
            reset();
        }
        player.setAttackedStatus(status);
    }

    public int returnTimes() {
        return times;
    }

    public boolean effectIsOver() {
        return times < 0 ? true : false;
    }

    public int returnHarmPoint() {
        return harmPoint;
    }

    public void reset() {
        times = initialEffectTimes;
        harmPoint = initialDelayHarmPoint;
    }

    public void cumulativeEffect() {
        times += initialEffectTimes;
        harmPoint += initialDelayHarmPoint;
    }
}
