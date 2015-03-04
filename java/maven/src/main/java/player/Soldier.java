package player;

import armor.Armor;
import status.*;
import weapon.Weapon;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by zhl on 15/2/12.
 */
public class Soldier extends Player {

    private Weapon weapon;
    private Armor armor;

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
        states.put("", new NormalStatus());
        states.put("用优质木棒", new StickStatus(out, random));
        states.put("用毒剑", new PoisonStatus(out, random));
        states.put("用火焰剑", new FireStatus(out, random));
        states.put("用寒冰剑", new FrozenStatus(out, random));
        states.put("用晕锤", new VertigoStatus(out, random));
        states.put("用利剑", new FullPowerStatus(out, random));
    }

    @Override
    public boolean canAttack() {
        return healthPoint > 0 ? true : false;
    }

    @Override
    public void reduceHealthPoint(int harmPoint) {
        healthPoint -= harmPoint;
    }

    @Override
    public int retrieveHarmPoint(int harmPoint) {
        return armor.retrieveHarmPoint(harmPoint);
    }

    @Override
    public void attack(Player player2) {
        attackedStatus.delayAttack(this, player2);
        if (attackedStatus.canAttack()) {
            out.println(attackStatus.attackAndReturnDescription(this, player2, weapon.getName()));
        }
    }
}
