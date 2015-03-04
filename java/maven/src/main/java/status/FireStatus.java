package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public class FireStatus extends Status {
    private final DelayHarm delayHarm;
    private final EffectTrigger effectTrigger;

    public FireStatus(PrintStream out, Random random, String weaponName) {
        super(out, 2, "用" + weaponName);
        delayHarm = new DelayHarm(2, 2);
        effectTrigger = new EffectTrigger(random, 2, "着火了");
    }

    public String retrieveHarmDescription(Player player1, Player player2) {
        return super.retrieveHarmDescription(player1, player2) + effectTrigger.retrieveEffectDescription(player2);
    }

    @Override
    public void reset() {
        delayHarm.reset();
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        if (delayHarm.delayAttack(player1)) {
            out.println(retrieveEffectString(player1));
        }
    }

    private String retrieveEffectString(Player player) {
        return player.getName() + "受到" + delayHarm.returnHarmPoint() + "点火焰伤害,"
                + player.getName() + "剩余生命:" + player.getHealthPoint();
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
