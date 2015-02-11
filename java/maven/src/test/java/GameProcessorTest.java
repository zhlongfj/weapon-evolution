import org.junit.Test;

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
        GameProcessor game = new GameProcessor(out);
        game.start();

        verify(out).println("李四被打败了");

    }
}
