package weapon;

import status.*;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by zhl on 15/2/28.
 */
public class SoldierWeapon extends Weapon{
    private String name;
    private Map<String, Status> states;

    public SoldierWeapon(String name, PrintStream out, Random random) {
        initStates(out, random);
        status = states.get(name);
        this.name = "用" + name;
    }

    private void initStates(PrintStream out, Random random) {
        states = new HashMap<String, Status>();
        states.put("优质木棒", new NormalStatus(4, out, random));
        states.put("毒剑", new PoisonStatus(out, random));
        states.put("火焰剑", new FireStatus(out, random));
        states.put("寒冰剑", new FrozenStatus(out, random));
        states.put("晕锤", new VertigoStatus(out, random));
        states.put("利剑", new FullPowerStatus(out, random));
    }

    @Override
    public String getName() {
        return name;
    }
}
