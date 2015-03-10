package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class VertigoStatus extends Status{
    private final DelayEffect delayEffect;
    private final EffectTrigger effectTrigger;

    public VertigoStatus(PrintStream out, Random random, String weaponName) {
        super(out, 2, "用" + weaponName);
        delayEffect = new DelayEffect(2, 0);
        effectTrigger = new EffectTrigger(random, 2, "晕倒了");
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        if (delayEffect.delayAttack(player1)) {
            out.println(retrieveEffectString(player1));
        }
    }

    private String retrieveEffectString(Player player) {
        return player.getName() + "晕倒了,无法攻击,眩晕还剩:" + delayEffect.returnTimes() + "轮";
    }

    public boolean canAttack() {
        return delayEffect.effectIsOver();
    }

    public void attack(Player player1, Player player2) {
        effectTrigger.trigger();
        if (effectTrigger.hasTriggerEffect()) {
            delayEffect.attack(player2, this);
        }
        super.attack(player1, player2);
    }

    protected String retrieveHarmDescription(Player player1, Player player2) {
        return super.retrieveHarmDescription(player1, player2) + effectTrigger.retrieveEffectDescription(player2);
    }
}
