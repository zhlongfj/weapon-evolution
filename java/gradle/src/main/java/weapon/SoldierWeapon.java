package weapon;

/**
 * Created by zhl on 15/2/28.
 */
public class SoldierWeapon extends Weapon{
    private String name;

    public SoldierWeapon(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
