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
        this.tempMana = mana;
        this.health = startingHealth;
        this.isHuman = isHuman;
        this.fatigueCounter = 0;
    }

    public int getMana() {
        return mana;
    }

    public void increaseManaTurn(){
        if(mana < 10){
            mana =+1;
            tempMana = mana;
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

    public void modifyTempMana(int number){
        this.tempMana = tempMana - number;
    }

    public void setAsAI(){
        isHuman = false;
    }
}
