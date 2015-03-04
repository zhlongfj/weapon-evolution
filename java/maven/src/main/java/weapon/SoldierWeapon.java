package weapon;

import status.Status;

import java.io.PrintStream;
import java.util.Map;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class SoldierWeapon extends Weapon{
    private String name;
    private Map<String, Status> states;

    public SoldierWeapon(String name, PrintStream out, Random random) {
        this.name = "用" + name;
    }

    @Override
    public String getName() {
        return name;
    }
}
