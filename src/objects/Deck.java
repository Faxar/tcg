package objects;

import java.util.Stack;

/**
 * Created by vassili.holenev on 9.07.2016.
 */
public class Deck {

    private Stack<Card> myDeck;

    public Deck() {
        this.myDeck = new Stack<>();
    }

    public Card fetch() {
        if (!myDeck.empty()) {
            return myDeck.pop();
        }
        System.out.println("deck empty");
        return null;
    }

    public boolean checkIfCardsRemainInTheDeck(){
        return myDeck.size() > 0;
    }

    public void populateDeck(Card card) {
        myDeck.push(card);
    }
}
