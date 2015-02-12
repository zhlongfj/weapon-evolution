package armor;

/**
 * Created by zhl on 15/2/12.
 */
public class SoldierArmor implements Armor{
    private String name;
    private int defencePoint;

    public SoldierArmor(String name, int defencePoint) {
        this.name = name;
        this.defencePoint = defencePoint;
    }

    public String getName() {
        return name;
    }

    public int retrieveHarmPoint(int attackedPoint) {
        int harmPoint = attackedPoint - defencePoint;
        return harmPoint > 0 ? harmPoint : 0;
    }
}
