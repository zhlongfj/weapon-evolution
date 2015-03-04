package player;

import status.NormalStatus;
import status.Status;

import java.io.PrintStream;

/**
 * Created by zhl on 15/2/12.
 */
public abstract class Player {
    protected PrintStream out;
    protected String profession;
    protected String name;
    protected int healthPoint;
    protected int attackPoint;
    protected Status attackedStatus;
    protected Status attackStatus;
    private Status normalState;

    public Player(PrintStream out, String name, int healthPoint, int attackPoint) {
        this.out = out;
        this.name = name;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
        normalState = new NormalStatus(out);
        attackedStatus = normalState;
        attackStatus = normalState;
    }

    public void setNormalState() {
        attackedStatus = normalState;
    }

    public void attack(Player player2) {
        attackedStatus.delayAttack(this, player2);
        if (canAttack()) {
            attackStatus.attack(this, player2);
        }
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public String getName() {
        return name;
    }

    public String getNameWithProfession() {
        return profession + name;
    }

    public void setAttackedStatus(Status status) {
        attackedStatus = status;
    }

    public Status returnAttackedStatus() {
        return attackedStatus;
    }

    public boolean canAttack() {
        return alive() && attackedStatus.canAttack() ? true : false;
    }

    private boolean alive() {
        return healthPoint > 0 ? true : false;
    }

    public void reduceHealthPoint(int attackedPoint) {
        healthPoint -= attackedPoint;
    }

    public abstract int retrieveHarmPoint(int harmPoint);
}
