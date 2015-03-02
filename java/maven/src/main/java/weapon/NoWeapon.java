package weapon;

import status.NormalStatus;

import java.io.PrintStream;
import java.util.Random;

/**
 * Created by zhl on 15/2/12.
 */
public class NoWeapon extends Weapon {
    public NoWeapon(PrintStream out, Random random) {
        status = new NormalStatus(0, out, random);
    }

    @Override
    public String getName() {
        return "";
    }
}
