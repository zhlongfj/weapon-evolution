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
    protected String retrieveExtraAttackString(String name) {
        return weapon.retrieveExtraAttackString(name);
    }

    @Override
    protected int retrieveExtraAttackPointWhenAttack(int healthPoint) {
        return weapon.retrieveExtraAttackPointWhenAttack(healthPoint);
    }

    @Override
    protected String retrieveExtraAttackStringWhenAttack(String name, int healthPoint) {
        return weapon.retrieveExtraAttackStringWhenAttack(name, healthPoint);
    }

    private int retrieveHarmPoint(int harmPoint) {
        return armor.retrieveHarmPoint(harmPoint);
    }
}
