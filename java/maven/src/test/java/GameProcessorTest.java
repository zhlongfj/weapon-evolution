import org.junit.Test;
import player.Player;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by zhl on 15/2/11.
 */
public class GameProcessorTest {
    @Test
    public void should_print_lisi_is_defeated() {
        PrintStream out = mock(PrintStream.class);
        Player player1 = new Player("张三", 10, 8);
        Player player2 = new Player("李四", 20, 9);
        GameProcessor game = new GameProcessor(out, player1, player2);
        game.start();

        verify(out).println("李四被打败了");

    }
}
