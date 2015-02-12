package weapon;

/**
 * Created by zhl on 15/2/12.
 */
public class NoWeapon implements Weapon {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public int retrieveAttackPoint(int sourceAttackPoint) {
        return sourceAttackPoint;
    }
}
