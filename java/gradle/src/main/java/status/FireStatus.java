package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/27.
 */
public class FireStatus extends Status {
    private final DelayEffect delayEffect;
    private final EffectTrigger effectTrigger;

    public FireStatus(PrintStream out, Random random, String weaponName) {
        super(out, 2, "用" + weaponName);
        delayEffect = new DelayEffect(2, 2);
        effectTrigger = new EffectTrigger(random, 2, "着火了");
    }

    public void attack(Player player1, Player player2) {
        effectTrigger.trigger();
        if (effectTrigger.hasTriggerEffect()) {
            delayEffect.attack(player2, this);
        }
        super.attack(player1, player2);
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        if (delayEffect.delayAttack(player1)) {
            out.println(retrieveEffectString(player1));
        }
    }

    private String retrieveEffectString(Player player) {
        return player.getName() + "受到" + delayEffect.returnHarmPoint() + "点火焰伤害,"
                + player.getName() + "剩余生命:" + player.getHealthPoint();
    }

    protected String retrieveHarmDescription(Player player1, Player player2) {
        return super.retrieveHarmDescription(player1, player2) + effectTrigger.retrieveEffectDescription(player2);
    }
}
