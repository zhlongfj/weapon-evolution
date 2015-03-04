package player;

import armor.Armor;
import status.*;
import weapon.Weapon;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by zhl on 15/2/12.
 */
public class Soldier extends Player {

    private Weapon weapon;
    private Armor armor;
    private Map<String, Status> states;

    public Soldier(PrintStream out, Random random, String name, int healthPoint, int attackPoint, Weapon weapon, Armor armor) {
        super(out, name, healthPoint, attackPoint);
        profession = "战士";
        this.weapon = weapon;
        this.armor = armor;
        initStates(out, random);
        attackStatus = states.get(weapon.getName());
    }

    private void initStates(PrintStream out, Random random) {
        states = new HashMap<String, Status>();
        states.put("", new NormalStatus(out));
        states.put("优质木棒", new StickStatus(out, "优质木棒"));
        states.put("毒剑", new PoisonStatus(out, random, "毒剑"));
        states.put("火焰剑", new FireStatus(out, random, "火焰剑"));
        states.put("寒冰剑", new FrozenStatus(out, random, "寒冰剑"));
        states.put("晕锤", new VertigoStatus(out, random, "晕锤"));
        states.put("利剑", new FullPowerStatus(out, random, "利剑"));
    }

    @Override
    public int retrieveHarmPoint(int harmPoint) {
        return armor.retrieveHarmPoint(harmPoint);
    }
}
