package player;

import weapon.Weapon;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/12.
 */
public abstract class Player {
    protected PrintStream out;
    protected String profession;
    protected String name;
    protected int healthPoint;
    protected int attackPoint;
    private Weapon harmWeapon;
    protected int harmPoint;

    public Player(PrintStream out, String name, int healthPoint, int attackPoint) {
        this.out = out;
        this.name = name;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
        this.harmWeapon = harmWeapon;
    }

    public void attack(Player player2) {
        player2.reduceHealthPoint(getAttackPoint());
        out.println(retrieveAttackString(player2) + retrieveAttackedPlayerHarmString(player2));
    }

    public String getProfession() {
        return profession;
    }

    public String getName() {
        return name;
    }

    public String getNameWithProfession() {
        return profession + name;
    }

    private String retrieveAttackedPlayerHarmString(Player player) {
        return player.retrieveAttackedString(retrieveExtraAttackString(player.getName()));
    }

    protected String retrieveAttackedString(String harmString) {
        return name + "受到了" + harmPoint + "点伤害,"
               + harmString + name + "剩余生命:" + healthPoint;
    }

    public abstract boolean canAttack();
    public abstract void reduceHealthPoint(int attackedPoint);
    protected abstract int getAttackPoint();
    protected abstract String retrieveAttackString(Player player);
    protected abstract String retrieveExtraAttackString(String name);

}
