package player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/12.
 */
public abstract class Player {
    private PrintStream out;
    protected String profession;
    private String name;
    protected int healthPoint;
    protected int attackPoint;
    protected int attackedPoint;

    public Player(PrintStream out, String name, int healthPoint, int attackPoint) {
        this.out = out;
        this.name = name;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
    }

    public String getProfession() {
        return profession;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getAttackedPoint() {
        return attackedPoint;
    }

    public void attack(Player player2) {
        player2.reduceHealthPoint(getAttackPoint());
        out.println(profession + name + "攻击了" + player2.getProfession() + player2.getName() + ","
                + player2.getName() + "受到了" + player2.getAttackedPoint() + "点伤害,"
                + player2.getName() + "剩余生命:" + player2.getHealthPoint());
    }

    public abstract boolean canAttack();
    public abstract void reduceHealthPoint(int attackedPoint);
    protected abstract int getAttackPoint();

}
