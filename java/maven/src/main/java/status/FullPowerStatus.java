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

    public FullPowerStatus(PrintStream out, Random random, String weaponName) {
        super(out, 2, "用" + weaponName);
        effectTrigger = new EffectTrigger(random, 2, "发动了全力一击");
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        return;
    }

    public void attack(Player player1, Player player2) {
        effectTrigger.trigger();
        super.attack(player1, player2);
    }

    protected String retrieveHarmDescription(Player player1, Player player2) {
        return effectTrigger.retrieveEffectDescription(player1) + super.retrieveHarmDescription(player1, player2);
    }

    protected int retrieveHarmPoint(Player player1, Player player2) {
        if (effectTrigger.hasTriggerEffect()) {
            return super.retrieveHarmPoint(player1, player2) * attackPointTimes;
        } else {
            return super.retrieveHarmPoint(player1, player2);
        }
    }
}
