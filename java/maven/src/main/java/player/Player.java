package player;

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

    public Player(PrintStream out, String name, int healthPoint, int attackPoint) {
        this.out = out;
        this.name = name;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
    }

    public abstract void attack(Player player2);

    public int getHealthPoint() {
        return healthPoint;
    }

    public String getName() {
        return name;
    }

    public String getNameWithProfession() {
        return profession + name;
    }

    public abstract boolean canAttack();
    public abstract void reduceHealthPoint(int attackedPoint);
    public abstract int retrieveHarmPoint(int harmPoint);

    public abstract void harmDelay(Player player);
}
