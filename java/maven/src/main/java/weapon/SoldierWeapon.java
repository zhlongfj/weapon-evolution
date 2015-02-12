package weapon;

/**
 * Created by zhl on 15/2/12.
 */
public class SoldierWeapon implements Weapon {
    private String name;
    private int attackPoint;

    public SoldierWeapon(String name, int attackPoint) {
        this.name = name;
        this.attackPoint = attackPoint;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int retrieveAttackPoint(int sourceAttackPoint) {
        return sourceAttackPoint + attackPoint;
    }
}
