package controller;

import objects.Card;
import objects.Field;
import objects.Minion;
import objects.Player;

import java.util.Scanner;

/**
 * Created by vassili.holenev on 28.07.2016.
 */
public class MenuController {

    public static void controller(int option, Player activePlayer, Player passivePlayer, Field field){

        if(option == 1){
            playCardFromHand(activePlayer, passivePlayer, field);
        } else if (option == 2){

        }
    }

    private static void playCardFromHand(Player activePlayer, Player passivePlayer, Field field){
        System.out.println("Currently you have in your hand following cards");
        activePlayer.hand.showHand();
        System.out.println("Select card");
        selectAndPlayCardFromHand(activePlayer, field);
    }

    private static void playCardOnTheField(Player player, Field field){

    }

    private static void selectAndPlayCardFromHand(Player activePlayer, Field field){
        Minion tempCard = (Minion) activePlayer.hand.takeCardFromHand(scanner());
        if(activePlayer.isHuman()){
            field.playerPutCardOnField(tempCard);
            tempCard.setFatigue(true);
        } else {
            field.aiPutCardOnField(tempCard);
        }
    }

    private static int scanner(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

}
