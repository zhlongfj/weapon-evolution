package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/27.
 */
public class StickStatus extends Status {

    public StickStatus(PrintStream out, String weaponName) {
        super(out, 4, "用" + weaponName);
    }

    @Override
    public void delayAttack(Player player1, Player player2) {
        return;
    }
}
