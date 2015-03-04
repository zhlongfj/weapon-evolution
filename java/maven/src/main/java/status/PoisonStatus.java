package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public class PoisonStatus extends Status {
    private final DelayHarm delayHarm;
    private final EffectTrigger effectTrigger;

    public PoisonStatus(PrintStream out, Random random, String weaponName) {
        super(out, 2, "用" + weaponName);
        delayHarm = new DelayHarm(2, 2);
        effectTrigger = new EffectTrigger(random, 2, "中毒了");
    }

    public String retrieveHarmDescription(Player player1, Player player2) {
        return super.retrieveHarmDescription(player1, player2) + effectTrigger.retrieveEffectDescription(player2);
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        if (delayHarm.delayAttack(player1)) {
            out.println(retrieveEffectString(player1));
        }
    }

    private String retrieveEffectString(Player player) {
        return player.getName() + "受到" + delayHarm.returnHarmPoint() + "点毒性伤害,"
                + player.getName() + "剩余生命:" + player.getHealthPoint();
    }

    @Override
    protected void reset() {
        delayHarm.reset();
    }

    @Override
    protected void cumulativeEffect(Status status) {
        delayHarm.cumulativeEffect();
    }

    @Override
    protected boolean canTriggerEffect() {
        return effectTrigger.canTriggerEffect();
    }
}
