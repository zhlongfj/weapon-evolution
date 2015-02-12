package armor;

/**
 * Created by zhl on 15/2/12.
 */
public class NoArmor implements Armor{
    public String getName() {
        return "";
    }

    public int retrieveHarmPoint(int attackedPoint) {
        return attackedPoint;
    }
}
