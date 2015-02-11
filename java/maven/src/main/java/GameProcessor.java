import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/11.
 */
public class GameProcessor {

    private PrintStream out;
    private Player player1;
    private Player player2;

    public GameProcessor(PrintStream out, Player player1, Player player2) {
        this.out = out;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        while (player1.canAttack() && player2.canAttack()) {
            player1.attack(player2);
            player2.attack(player1);
        }

        if (player1.canAttack()) {
            out.println(player1.getName() + "被打败了");
        }

        if (player2.canAttack()) {
            out.println(player2.getName() + "被打败了");
        }
    }
}
