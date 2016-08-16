package objects;

/**
 * Created by vassili.holenev on 9.07.2016.
 */
public class Minion extends Card {

    private int health;
    private int power;
    private boolean fatigue;
    private boolean isDead;

    public Minion() {
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isFatigue() {
        return fatigue;
    }

    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public String toString() {
        return super.toString() + " Strength: " + power + " Health: " + health;
    }
}
