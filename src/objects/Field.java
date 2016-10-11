package objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vassili.holenev on 9.07.2016.
 */
public class Field {

    private static final int maximumCardsOnField = 5;
    private List<Card> aiField;
    private List<Card> playerField;

    public Field() {
        this.aiField = new ArrayList<>();
        this.playerField = new ArrayList<>();
    }

    public void aiPutCardOnField(Minion card){
        aiField.add(card);
        putNewlyPlayedCardToFatigue(card);
    }

    public void playerPutCardOnField(Minion card){
        playerField.add(card);
        putNewlyPlayedCardToFatigue(card);
    }

    public void clearCardsFatgue(Player activePlayer){
        if(activePlayer.isHuman()){
            for (int i=0;i<playerField.size();i++){
                Minion minion = (Minion) playerField.get(i);
                minion.setFatigue(false);
            }
        } else {
            for (int i=0;i<aiField.size();i++){
                Minion minion = (Minion) aiField.get(i);
                minion.setFatigue(false);
            }
        }
    }

    public boolean checkIfFieldEmpty(){
        return playerField.size() <= 0;
    }

    private void putNewlyPlayedCardToFatigue(Minion minion){
        minion.setFatigue(true);
    }

    public void showCardsOnTheField(Player activePlayer){
        if(activePlayer.isHuman()){
            for(int i=0;i<playerField.size();i++){
                Minion temp = (Minion) playerField.get(i);
                System.out.println((i + 1) + ". " + temp.getName() + " | Strength: " + temp.getPower() + " , Health: " + temp.getHealth() + " , Mana: " + temp.getMana());
            }
        }
    }

    public Card returnCardFromField (Player activePlayer, int cardNumber){
        if(activePlayer.isHuman()){
            return playerField.get(cardNumber);
        }
        return aiField.get(cardNumber);
    }

    public int returnFieldSize(Player activePlayer){
        if(activePlayer.isHuman() && !(playerField.size() < 0)){
            return playerField.size();
        } else if (!activePlayer.isHuman() && !(playerField.size() < 0)){
            return aiField.size();
        }
        return -1;
    }
}

