package status;

import player.Player;

import java.util.Random;

/**
 * Created by zhl on 15/3/3.
 */
public class EffectTrigger {
    private Random random;
    private int bound;
    private boolean triggerEffect;
    private String effectString;

    public EffectTrigger(Random random, int bound, String effectString) {
        this.random = random;
        this.bound = bound;
        this.effectString = effectString;
    }

    public void trigger() {
        if (random.nextInt(bound) == 0) {
            triggerEffect = true;
        } else {
            triggerEffect = false;
        }
    }

    public boolean hasTriggerEffect() {
        return triggerEffect;
    }
    protected String retrieveEffectDescription(Player player) {
        return triggerEffect ? player.getName() + effectString + "," : "";
    }
}
