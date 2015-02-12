package armor;

/**
 * Created by zhl on 15/2/12.
 */
public class SoldierArmor implements Armor{
    private String name;
    private int defence;

    public SoldierArmor(String name, int defence) {
        this.name = name;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public int getDefence() {
        return defence;
    }
}
