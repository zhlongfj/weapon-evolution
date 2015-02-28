package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/28.
 */
public class FullPowerStatus extends Status{
    public FullPowerStatus(PrintStream out) {
        super(out);
    }

    @Override
    public void attack(Player player1, Player player2) {

    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public String retrieveHarmDescription(Player player1, Player player2) {
        return player1.getName() + "发动了全力一击,"
                + player2.getName() + "受到了" + player2.retrieveHarmPoint(player1.getAttackPoint()) * 3 + "点伤害,";
    }

    @Override
    public int retrieveAttackPoint(int attackPoint) {
        return attackPoint * 3;
    }
}
