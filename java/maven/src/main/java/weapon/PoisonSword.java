package weapon;

/**
 * Created by zhl on 15/2/12.
 */
public class PoisonSword implements Weapon {

    private final int extraHarm;

    public PoisonSword() {
        extraHarm = 2;
    }

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

    @Override
    public int retrieveExtraAttackPointWhenAttack(int healthPoint) {
        return healthPoint - extraHarm;
    }

    @Override
    public String retrieveExtraAttackStringWhenAttack(String name, int healthPoint) {
        return name + "受到" + extraHarm + "点毒性伤害," + name + "剩余生命:" + healthPoint;
    }
}
