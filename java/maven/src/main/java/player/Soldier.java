package player;

import armor.Armor;
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
    public void reduceHealthPoint(int attackedPoint) {
        calculateAttackedPoint(attackedPoint);
        healthPoint -= this.attackedPoint;
    }

    @Override
    protected int getAttackPoint() {
        return attackPoint + weapon.getAttackPoint();
    }

    private void calculateAttackedPoint(int attackedPoint) {
        this.attackedPoint = attackedPoint - armor.getDefence();
    }
}