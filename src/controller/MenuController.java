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
            System.out.println("end turn pressed");
            Menu.endTurn();
        }
    }

    private static void playCardFromHand(Player activePlayer, Player passivePlayer, Field field){
        System.out.println("Current Mana: " + activePlayer.getTempMana());
        System.out.println("Currently you have in your hand following cards");
        activePlayer.hand.showHand();
        PlayCardFromHand(activePlayer, field);
    }

    private static void playCardOnTheField(Player activePlayer, Field field){
        System.out.println("Cards on the field:");
        field.showCardsOnTheField(activePlayer);
        attackWithTheCard(activePlayer,field);
    }

    private static void PlayCardFromHand(Player activePlayer, Field field){
        Minion tempCard = (Minion) activePlayer.hand.checkCardInHand(scannerValidator("field", activePlayer, field));
        if(activePlayer.isHuman() && checkThatPlayerHaveEnoughManaForCard(activePlayer, tempCard)){
            field.playerPutCardOnField(tempCard);
            activePlayer.hand.removeCardFromHand(tempCard);
            activePlayer.modifyTempMana(tempCard.getMana());
            announceCard(tempCard);
        } else if (!activePlayer.isHuman() && checkThatPlayerHaveEnoughManaForCard(activePlayer, tempCard)){
            field.aiPutCardOnField(tempCard);
            activePlayer.hand.removeCardFromHand(tempCard);
            activePlayer.modifyTempMana(tempCard.getMana());
            announceCard(tempCard);
        }
    }

    private static int scanner(){
        Scanner scanner = new Scanner(System.in);
        int number;
        do{
            System.out.println("Enter positive number");
            while(!scanner.hasNextInt()){
                System.out.println("That's not a correct number!");
                scanner.next();
            }
            number = scanner.nextInt();
        }while (number <= 0);
        return number-1;
    }

    private static boolean  checkThatPlayerHaveEnoughManaForCard(Player activePlayer, Minion card){
        if(activePlayer.getTempMana() >= card.getMana()){
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
            Minion attackCard = (Minion) field.returnCardFromField(activePlayer, scanner());
            checkIfCardIsFatuguedOnTheField(attackCard);
        }
    }

    private static void announceCard(Minion tempCard){
        System.out.println("Now on the field there is - " + tempCard.getName() + " | Health: " + tempCard.getHealth() + " ,Strenght: " + tempCard.getPower());
    }

    private static int scannerValidator(String checkValue, Player activePlayer, Field field){
        while (true){
            int number = scanner();
            if(checkValue.equals("field")){
                if((field.returnFieldSize(activePlayer) >= 0) && (activePlayer.hand.returnHandCardsNumber() >= number)){
                    return number;
                }
            }else if(checkValue.equals("hand")){
                if((activePlayer.hand.returnHandCardsNumber() >= 0) && (activePlayer.hand.returnHandCardsNumber() >= number)){
                    return number;
                }
            }
            System.out.println("Please enter correct number range");
        }
    }
}
