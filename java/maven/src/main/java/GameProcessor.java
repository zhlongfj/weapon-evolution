import java.io.PrintStream;

/**
 * Created by zhl on 15/2/11.
 */
public class GameProcessor {

    private PrintStream out;

    public GameProcessor(PrintStream out) {
        this.out = out;
    }

    public void start() {
        out.println("李四被打败了");
    }
}
