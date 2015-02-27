package player;

import armor.Armor;
import status.FireStatus;
import weapon.Weapon;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/12.
 */
public class Soldier extends Player {

    private Weapon weapon;
    private Armor armor;

    public Soldier(PrintStream out, String name, int healthPoint, int attackPoint, Weapon weapon, Armor armor) {
        super(out, name, healthPoint, attackPoint);
        profession = "战士";
        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public boolean canAttack() {
        return healthPoint > 0 ? true : false;
    }

    @Override
    public void reduceHealthPoint(int harmPoint) {
        healthPoint -= retrieveHarmPoint(harmPoint);
    }

    @Override
    public int retrieveHarmPoint(int harmPoint) {
        return armor.retrieveHarmPoint(harmPoint);
    }

    @Override
    public void attack(Player player2) {
        status.attack(this);
        player2.setStatus(new FireStatus(out));
        weapon.reduceHealthPoint(this, player2);
        out.println(weapon.returnDescription(this, player2));
    }
}
