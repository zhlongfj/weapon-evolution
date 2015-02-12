package weapon;

/**
 * Created by zhl on 15/2/12.
 */
public class PoisonSword implements Weapon {
    @Override
    public String getName() {
        return "用毒剑";
    }

    @Override
    public int retrieveAttackPoint(int sourceAttackPoint) {
        return sourceAttackPoint;
    }

    @Override
    public String retrieveExtraAttackString(String name) {
        return name + "中毒了,";
    }
}
