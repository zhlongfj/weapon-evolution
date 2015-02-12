package weapon;

/**
 * Created by zhl on 15/2/12.
 */
public class Stick implements Weapon {
    private String name;
    private int attackPoint;

    public Stick() {
        this.name = "优质木棒";
        this.attackPoint = 4;
    }

    @Override
    public String getName() {
        return "用" + name;
    }

    @Override
    public int retrieveAttackPoint(int sourceAttackPoint) {
        return sourceAttackPoint + attackPoint;
    }
}
