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
    public void attack(Player player2) {
        player2.reduceHealthPoint(getAttackPoint());
        out.println(profession + name + weapon.getName() + "攻击了" + player2.getProfession() + player2.getName() + ","
                + player2.getName() + "受到了" + player2.getHarmPoint() + "点伤害,"
                + player2.getName() + "剩余生命:" + player2.getHealthPoint());
    }

    @Override
    public void reduceHealthPoint(int harmPoint) {
        this.harmPoint = retrieveHarmPoint(harmPoint);
        healthPoint -= this.harmPoint;
    }

    @Override
    protected int getAttackPoint() {
        return weapon.retrieveAttackPoint(attackPoint);
    }

    private int retrieveHarmPoint(int harmPoint) {
        return armor.retrieveHarmPoint(harmPoint);
    }
}
