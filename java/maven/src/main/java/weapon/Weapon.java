package weapon;

/**
 * Created by zhl on 15/2/12.
 */
public class Weapon {
    private String name;
    private int attackPoint;

    public Weapon(String name, int attackPoint) {
        this.name = name;
        this.attackPoint = attackPoint;
    }

    public String getName() {
        return name;
    }

    public int getAttackPoint() {
        return attackPoint;
    }
}
