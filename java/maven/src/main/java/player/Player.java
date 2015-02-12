package player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/12.
 */
public class Player {
    private PrintStream out;
    private String name;
    private int healthPoint;
    private int attackPoint;

    public Player(PrintStream out, String name, int healthPoint, int attackPoint) {
        this.out = out;

        this.name = name;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public boolean canAttack() {
        return healthPoint > 0 ? true : false;
    }

    public void attack(Player player2) {
        player2.reduceHealthPoint(attackPoint);
        out.println(name + "攻击了" + player2.getName() + ","
                + player2.getName() + "受到了" + attackPoint + "点伤害,"
                + player2.getName() + "剩余生命：" + player2.getHealthPoint());
    }

    public void reduceHealthPoint(int attackedPoint) {
        healthPoint -= attackedPoint;
    }
}
