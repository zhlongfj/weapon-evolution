package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class FrozenStatus extends Status {
    private final EffectTrigger effectTrigger;
    private final DelayHarm delayHarm;
    private int attackTimes;
    private PrintStream out;

    public FrozenStatus(PrintStream out, Random random) {
        super(2);
        this.out = out;
        delayHarm = new DelayHarm(2, 0);
        effectTrigger = new EffectTrigger(random, 2, "冻僵了");
        attackTimes = 0;
    }

    public String retrieveHarmAndEffectDescription(Player player1, Player player2) {
        return super.retrieveHarmDescription(player1, player2) + effectTrigger.retrieveEffectDescription(player2);
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        if (delayHarm.delayAttack(player1)) {
            attackTimes++;
            if (!canAttack()) {
                out.println(retrieveEffectString(player1, player2));
            }
        }
    }

    public boolean canAttack() {
        return attackTimes % 2 == 0 ? false : true;
    }

    private String retrieveEffectString(Player player1, Player player2) {
        return player1.getName() + "冻得直哆嗦，没有击中" + player2.getName();
    }

    @Override
    public void reset() {
        delayHarm.reset();
        attackTimes = 0;
    }

    @Override
    public void cumulativeEffect(Status status) {
        delayHarm.cumulativeEffect();
    }

    @Override
    public boolean canTriggerEffect() {
        return effectTrigger.canTriggerEffect();
    }
}
