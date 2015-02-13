package weapon;

import player.Player;

/**
 * Created by zhl on 15/2/12.
 */
public interface Weapon {
    public String getName();
    public int retrieveAttackPoint(int sourceAttackPoint);

    public String getHarmDescription(Player player, int playerAttackPoint);
    public String harmDelay(Player player);
}
