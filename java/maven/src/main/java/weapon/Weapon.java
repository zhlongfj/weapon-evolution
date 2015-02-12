package weapon;

/**
 * Created by zhl on 15/2/12.
 */
public interface Weapon {
    public String getName();
    public int retrieveAttackPoint(int sourceAttackPoint);
    public String retrieveExtraAttackString(String name);
    public int retrieveExtraAttackPointWhenAttack(int healthPoint);
    public String retrieveExtraAttackStringWhenAttack(String name, int healthPoint);
}
