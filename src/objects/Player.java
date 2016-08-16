package objects;

/**
 * Created by vassili.holenev on 9.07.2016.
 */
public class Player {

    public final int startingHealth = 30;
    public final int maximumMana = 10;

    private int mana;
    private int tempMana;
    private int health;
    private boolean isHuman;
    private int fatigueCounter;

    public Menu menu;
    public Hand hand;
    public Deck deck;

    public Player(boolean isHuman) {
        this.mana = 1;
        this.health = startingHealth;
        this.isHuman = isHuman;
        this.fatigueCounter = 0;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if(mana + this.mana <= maximumMana){
            this.mana = mana;
            this.tempMana = mana;
        }

    }

    public int getTempMana() {
        return tempMana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void fatigueDamage(){
        this.fatigueCounter = fatigueCounter+1;
        dealDamage(fatigueCounter);
    }

    public void dealDamage(int damage){
        this.health = health - damage;
    }
}
