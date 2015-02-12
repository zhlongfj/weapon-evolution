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
        out.println(retrieveAttackString(player2) + player2.retrieveAttackedString());
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
    @Override
    protected String retrieveAttackString(Player player) {
        return getNameWithProfession() + weapon.getName() + "攻击了" + player.getNameWithProfession() + ",";
    }

    @Override
    protected String retrieveAttackedString() {
        return name + "受到了" + harmPoint + "点伤害,"
                + name + "剩余生命:" + healthPoint;
    }

    private int retrieveHarmPoint(int harmPoint) {
        return armor.retrieveHarmPoint(harmPoint);
    }
}
