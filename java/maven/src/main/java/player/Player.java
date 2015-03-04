package player;

import status.NormalStatus;
import status.Status;

import java.io.PrintStream;
import java.util.Map;

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
    protected Map<String, Status> states;

    public Player(PrintStream out, String name, int healthPoint, int attackPoint) {
        this.out = out;
        this.name = name;
        this.healthPoint = healthPoint;
        this.attackPoint = attackPoint;
        normalState = new NormalStatus();
        attackedStatus = normalState;
        attackStatus = normalState;
    }

    public void setNormalState() {
        attackedStatus = normalState;
    }

    public abstract void attack(Player player2);

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

    public void setStatus(Status status) {
        if (status.getClass() == this.attackedStatus.getClass()) {
            this.attackedStatus.cumulativeEffect(status);
        } else {
            status.reset();
            this.attackedStatus = status;
        }
    }

    public abstract boolean canAttack();
    public abstract void reduceHealthPoint(int attackedPoint);
    public abstract int retrieveHarmPoint(int harmPoint);
}
