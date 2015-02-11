package player;

/**
 * Created by zhl on 15/2/12.
 */
public class Player {
    private String name;
    private int healthPoint;
    private int attackPoint;

    public Player(String name, int healthPoint, int attackPoint) {

        this.name = name;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
    }

    public String getName() {
        return name;
    }

    public boolean canAttack() {
        return healthPoint > 0 ? true : false;
    }

    public void attack(Player player2) {
        player2.reduceHealthPoint(attackPoint);
    }

    public void reduceHealthPoint(int attackedPoint) {
        healthPoint -= attackedPoint;
    }
}
