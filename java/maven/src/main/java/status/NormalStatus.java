package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/27.
 */
public class NormalStatus extends Status {
    private int attackPoint;

    public NormalStatus(int attackPoint, PrintStream out) {
        super(out);
        times = 0;
        this.attackPoint = attackPoint;
    }

    @Override
    protected void attackReal(Player player1, Player player2) {
        return;
    }

    @Override
    public boolean canAttack() {
        return true;
    }

    @Override
    public String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + (player2.retrieveHarmPoint(player1.getAttackPoint()) + attackPoint) + "点伤害,";
    }

    @Override
    public int retrieveHarmPoint(int attackPoint, Player player) {
        return player.retrieveHarmPoint(this.attackPoint + attackPoint);
    }
}
