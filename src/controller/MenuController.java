package controller;

import objects.*;

import java.util.MissingFormatArgumentException;
import java.util.Scanner;

/**
 * Created by vassili.holenev on 28.07.2016.
 */
public class MenuController {

    public static void controller(int option, Player activePlayer, Player passivePlayer, Field field){

        if(option == 1){
            playCardFromHand(activePlayer, passivePlayer, field);
        } else if (option == 2){
            playCardOnTheField(activePlayer, field);
        } else if (option == 3){
            Menu.endTurn();
        }
    }

    private static void playCardFromHand(Player activePlayer, Player passivePlayer, Field field){
        System.out.println("Current Mana: " + activePlayer.getTempMana());
        System.out.println("Currently you have in your hand following cards");
        activePlayer.hand.showHand();
        System.out.println("Select card to play");
        PlayCardFromHand(activePlayer, field);
    }

    private static void playCardOnTheField(Player activePlayer, Field field){
        System.out.println("Cards on the field:");
        field.showCardsOnTheField(activePlayer);
        attackWithTheCard(activePlayer,field);
    }

    private static void PlayCardFromHand(Player activePlayer, Field field){
        Minion tempCard = (Minion) activePlayer.hand.returnCardFromHand(scanner()-1);
        if(activePlayer.isHuman() && checkThatPlayerHaveEnoughManaForCard(activePlayer, tempCard)){
            field.playerPutCardOnField(tempCard);
        } else if (!activePlayer.isHuman() && checkThatPlayerHaveEnoughManaForCard(activePlayer, tempCard)){
            field.aiPutCardOnField(tempCard);
        }
        System.out.println("Now on the field there is - " + tempCard.getName() + " | Health: " + tempCard.getHealth() + " ,Strenght: " + tempCard.getPower());

    }

    private static int scanner(){
        

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    private static boolean  checkThatPlayerHaveEnoughManaForCard(Player activePlayer, Card card){
        if(card.getMana() <= activePlayer.getTempMana()){
            return true;
        }
        System.out.println("You don't have enough mana to play this card. Current mana: " + activePlayer.getTempMana() + " < Card mana: " + card.getMana());
        return false;
    }

    private static boolean checkIfCardIsFatuguedOnTheField(Minion card){
        if(!card.isFatigue()){
            return true;
        }
        System.out.println("You cannot play this card this turn, it's fatigued");
        return false;
    }

    private static void attackWithTheCard (Player activePlayer, Field field){
        if(activePlayer.isHuman()){
            Minion attackCard = (Minion) field.returnCardFromField(activePlayer, scanner()-1);
            checkIfCardIsFatuguedOnTheField(attackCard);
        }
    }



}
