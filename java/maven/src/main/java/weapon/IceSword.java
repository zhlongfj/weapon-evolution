package weapon;

/**
 * Created by zhl on 15/2/12.
 */
public class IceSword implements Weapon {

    private final int rounds;

    public IceSword() {
        rounds = 2;
    }

    @Override
    public String getName() {
        return "用寒冰剑";
    }

    @Override
    public int retrieveAttackPoint(int sourceAttackPoint) {
        return sourceAttackPoint;
    }

    @Override
    public String retrieveExtraAttackString(String name) {
        return name + "冻僵了,";
    }

    @Override
    public int retrieveExtraAttackPointWhenAttack(int healthPoint) {
        return healthPoint;
    }

    @Override
    public String retrieveExtraAttackStringWhenAttack(String name, int healthPoint) {
        return "";
    }
}
