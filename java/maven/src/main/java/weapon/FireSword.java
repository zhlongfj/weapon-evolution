package weapon;

/**
 * Created by zhl on 15/2/12.
 */
public class FireSword implements Weapon {

    private final int extraHarm;

    public FireSword() {
        extraHarm = 2;
    }

    @Override
    public String getName() {
        return "用火焰剑";
    }

    @Override
    public int retrieveAttackPoint(int sourceAttackPoint) {
        return sourceAttackPoint;
    }

    @Override
    public String retrieveExtraAttackString(String name) {
        return name + "着火了,";
    }

    @Override
    public int retrieveExtraAttackPointWhenAttack(int healthPoint) {
        return healthPoint - extraHarm;
    }

    @Override
    public String retrieveExtraAttackStringWhenAttack(String name, int healthPoint) {
        return name + "受到" + extraHarm + "点火焰伤害," + name + "剩余生命:" + healthPoint;
    }
}
