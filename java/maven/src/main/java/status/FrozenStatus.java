package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/28.
 */
public class FrozenStatus extends Status {
    public FrozenStatus(PrintStream out) {
        super(out);
        times = 2;
    }

    @Override
    public void attack(Player player1, Player player2) {
        times--;
        if (times == 0) {
            out.println(player1.getName() + "冻得直哆嗦，没有击中" + player2.getName());
        }
    }

    @Override
    public boolean canAttack() {
        return times != 0 ? true : false;
    }
}