package status;

import player.Player;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class FrozenStatus extends Status {
    private final EffectTrigger effectTrigger;
    private final DelayEffect delayEffect;
    private int attackTimes;
    private PrintStream out;

    public FrozenStatus(PrintStream out, Random random, String weaponName) {
        super(out, 2, "用" + weaponName);
        this.out = out;
        delayEffect = new DelayEffect(2, 0);
        effectTrigger = new EffectTrigger(random, 2, "冻僵了");
        attackTimes = 0;
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        if (delayEffect.delayAttack(player1)) {
            attackTimes++;
            if (!canAttack()) {
                out.println(retrieveEffectString(player1, player2));
            }
        }
    }

    private String retrieveEffectString(Player player1, Player player2) {
        return player1.getName() + "冻得直哆嗦，没有击中" + player2.getName();
    }

    public boolean canAttack() {
        return attackTimes % 2 == 0 ? false : true;
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
