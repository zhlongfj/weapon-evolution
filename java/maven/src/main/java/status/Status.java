package status;

import player.Player;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/27.
 */
public abstract class Status {
    protected PrintStream out;
    private int attackPoint;
    private String weaponName;

    protected Status(PrintStream out, int attackPoint, String weaponName) {
        this.out = out;
        this.attackPoint = attackPoint;
        this.weaponName = weaponName;
    }

    public boolean canAttack() {
        return true;
    }

    public abstract void delayAttack(Player player1, Player player2);

    public void attack(Player player1, Player player2) {
        if (canTriggerEffect()) {
            setStatus(player2);
        }
        reduceHealthPoint(player1, player2);
        printAttack(player1, player2);
    }

    protected abstract boolean canTriggerEffect();

    private void setStatus(Player player) {
        Status status = player.returnAttackedStatus();
        if (this.getClass() == status.getClass()) {
            this.cumulativeEffect(status);
        } else {
            this.reset();
        }
        player.setAttackedStatus(this);
    }

    protected abstract void cumulativeEffect(Status status);
    protected abstract void reset();

    private void reduceHealthPoint(Player player1, Player player2) {
        player2.reduceHealthPoint(retrieveHarmPoint(player1, player2));
    }

    protected int retrieveHarmPoint(Player player1, Player player2) {
        return player2.retrieveHarmPoint(player1.getAttackPoint() + attackPoint);
    }

    private void printAttack(Player player1, Player player2) {
        out.println(returnAttackDescription(player1, player2)
                + retrieveHarmDescription(player1, player2) + returnAttackResult(player2));
    }

    private String returnAttackDescription(Player player1, Player player2) {
        return player1.getNameWithProfession() + weaponName + "攻击了" + player2.getNameWithProfession() + ",";
    }

    protected String retrieveHarmDescription(Player player1, Player player2) {
        return player2.getName() + "受到了" + retrieveHarmPoint(player1, player2) + "点伤害,";
    }

    private String returnAttackResult(Player player) {
        return player.getName() + "剩余生命:" + player.getHealthPoint();
    }

}
