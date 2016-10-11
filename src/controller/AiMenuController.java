package controller;

import objects.Card;
import objects.Field;
import objects.Minion;
import objects.Player;

import java.util.ArrayList;

/**
 * Created by vassili.holenev on 26.09.2016.
 */
public class AiMenuController {

    public static void AiTurn(Player activePlayer, Player passivePlayer, Field field){
        System.out.println("AI have following cards in his hand");
        activePlayer.hand.showHand();
        ArrayList AiCardChoice = AiCheckHandAndSelectCards(activePlayer);
        PlaySelectedCards(AiCardChoice, field);
    }

    private static ArrayList AiCheckHandAndSelectCards(Player activePlayer){
        ArrayList tempCardList = new ArrayList<Card>();
            if(activePlayer.hand.checkHand()){
                for (int i = 0;i< activePlayer.hand.returnHandSize();i++){
                    Card temp = activePlayer.hand.checkCardInHand(i);
                    if(temp.getMana() <= activePlayer.getTempMana()){
                        tempCardList.add(temp);
                        System.out.println("forwarding cards");
                    }
                }
            }
        return tempCardList;
    }

    private static void AiPlayCardOnField(Minion card, Field field){
        field.aiPutCardOnField(card);
    }

    private static void PlaySelectedCards(ArrayList<Minion> card, Field field){
        for(int i =0;i<card.size();i++){
            AiPlayCardOnField(card.get(i), field);
        }

    }
}
