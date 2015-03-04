package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class FullPowerStatus extends Status{
    private final int attackPointTimes = 3;
    private final EffectTrigger effectTrigger;

    public FullPowerStatus(PrintStream out, Random random) {
        super(2);
        effectTrigger = new EffectTrigger(random, 2, "发动了全力一击");
    }

    public int retrieveHarmPoint(Player player1, Player player2) {
        return super.retrieveHarmPoint(player1, player2) * attackPointTimes;
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        return;
    }

    public String retrieveHarmAndEffectDescription(Player player1, Player player2) {
        return effectTrigger.retrieveEffectDescription(player1) + retrieveHarmDescription(player1, player2);
    }

    @Override
    public void reset() {
        return;
    }

    @Override
    public void cumulativeEffect(Status status) {
        return;
    }

    @Override
    public boolean canTriggerEffect() {
        return effectTrigger.canTriggerEffect();
    }
}
