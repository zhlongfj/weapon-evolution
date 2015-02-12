import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import player.Player;

import java.io.PrintStream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by zhl on 15/2/11.
 */
public class GameProcessorTest {

    private PrintStream out;
    private GameProcessor game;

    @Before
    public void setUp() throws Exception {
        out = mock(PrintStream.class);
    }

    @Test
    public void should_print_lisi_is_defeated() {
        Player player1 = new Player(out, "张三", 20, 8);
        Player player2 = new Player(out, "李四", 10, 9);
        game = new GameProcessor(out, player1, player2);

        game.start();

        verify(out).println("李四被打败了");
    }

    @Test
    public void should_print_zhangsan_is_defeated_when_canAttack_of_zhangsan_is_false() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        game = new GameProcessor(out, player1, player2);
        given(player1.getName()).willReturn("张三");
        given(player1.canAttack()).willReturn(false);

        game.start();

        verify(out).println("张三被打败了");
    }

    @Test
    public void should_print_zhangsan_is_defeated_when_run_3_rounds() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        game = new GameProcessor(out, player1, player2);
        given(player1.getName()).willReturn("张三");
        given(player1.canAttack()).willReturn(true, true, false);
        given(player2.canAttack()).willReturn(true);
        game.start();

        verify(out).println("张三被打败了");
    }

    @Test
    public void should_print_lisi_is_defeated_when_run_3_rounds() {
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);
        game = new GameProcessor(out, player1, player2);
        given(player2.getName()).willReturn("李四");
        given(player1.canAttack()).willReturn(true);
        given(player2.canAttack()).willReturn(true, true, false);
        game.start();

        verify(out).println("李四被打败了");
    }



}
