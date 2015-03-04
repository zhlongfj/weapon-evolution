package status;

import player.Player;

/**
 * Created by zhl on 15/3/3.
 */
public class NormalStatus extends Status{
    public NormalStatus() {
        super(0);
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        return;
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
        return true;
    }
}
