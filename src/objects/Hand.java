package objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vassili.holenev on 9.07.2016.
 */
public class Hand {

    final int maximumHandSize = 5;
    private List<Card> myHand;

    public Hand() {
        this.myHand = new ArrayList<>();
    }

    public void populateHand(Deck deck){
        for(int i=0;i<3;i++){
            myHand.add(deck.fetch());
        }
    }

    public void getOneCardFromDeck(Player player){
        if(player.deck.checkIfCardsRemainInTheDeck()){
            myHand.add(player.deck.fetch());
        } else {
            player.fatigueDamage();
        }
    }

    public boolean checkHand(){
        return myHand.size() >= 0;
    }

    public void showHand(){
        for(int i=0;i<myHand.size();i++){
            Minion temp = (Minion) myHand.get(i);
            System.out.println((i + 1) + ". " + temp.getName() + " | Strength: " + temp.getPower() + " , Health: " + temp.getHealth() + " , Mana: " + temp.getMana());
        }
    }

    public void removeCardFromHand(Card card){
        for(int i=0;i<myHand.size();i++){
            Card tempCard = myHand.get(i);
            if(card.getId() == tempCard.getId()){
                myHand.remove(i);
            }
        }
    }

    public Card checkCardInHand(int cardNumber){
        return myHand.get(cardNumber);
    }

    public int returnHandCardsNumber(){
        if(myHand.size() >= 0){
            int number = myHand.size();
            System.out.println("You have " + number + " cards in your hand");
            return myHand.size();
        } else {
            return -1;
        }
    }

    public int returnHandSize (){
        return myHand.size();
    }
}
