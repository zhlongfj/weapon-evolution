package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class VertigoStatus extends Status{
    private final  DelayHarm delayHarm;
    private final EffectTrigger effectTrigger;
    private PrintStream out;

    public VertigoStatus(PrintStream out, Random random) {
        super(2);
        this.out = out;
        delayHarm = new DelayHarm(2, 0);
        effectTrigger = new EffectTrigger(random, 2, "晕倒了");
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        if (delayHarm.delayAttack(player1)) {
            String name = retrieveEffectString(player1);
            out.println(retrieveEffectString(player1));
        }
    }

    private String retrieveEffectString(Player player) {
        return player.getName() + "晕倒了,无法攻击,眩晕还剩:" + delayHarm.returnTimes() + "轮";
    }

    public String retrieveHarmAndEffectDescription(Player player1, Player player2) {
        return super.retrieveHarmDescription(player1, player2) + effectTrigger.retrieveEffectDescription(player2);
    }

    public boolean canAttack() {
        return delayHarm.effectIsOver();
    }

    @Override
    public void reset() {
        delayHarm.reset();
    }

    @Override
    public boolean canTriggerEffect() {
        return effectTrigger.canTriggerEffect();
    }

    @Override
    public void cumulativeEffect(Status status) {
        delayHarm.cumulativeEffect();
    }
}
