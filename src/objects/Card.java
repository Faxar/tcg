package objects;

/**
 * Created by vassili.holenev on 9.07.2016.
 */
public abstract class Card {

    private int id;
    private String name;
    private int mana;

    public Card() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", mana=" + mana +
                '}';
    }
}
