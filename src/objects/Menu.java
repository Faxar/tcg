package objects;

import controller.AiMenuController;
import controller.MenuController;

import java.util.Scanner;

/**
 * Created by vassili.holenev on 19.07.2016.
 */
public class Menu {

    static boolean endTurn=false;

    public Menu() {
    }

    public static void humanMenu(Player activePlayer, Player passivePlayer, Field field){

        while(!endTurn){
            if (field.checkIfFieldEmpty() && !activePlayer.hand.checkHand()) {
                System.out.println("Please select action\n" +
                        "Press 3 - End Turn\n" +
                        "Press 4 - Surrender\n");
            } else if (!field.checkIfFieldEmpty() && !activePlayer.hand.checkHand()) {
                System.out.println("Please select action\n" +
                        "Press 2 - Play Card on the field\n" +
                        "Press 3 - End Turn\n" +
                        "Press 4 - Surrender\n");
            } else if (field.checkIfFieldEmpty() && activePlayer.hand.checkHand()) {
                System.out.println("Please select action\n" +
                        "Press 1 - Play Card from the hand\n" +
                        "Press 3 - End Turn\n" +
                        "Press 4 - Surrender\n");
            } else {
                System.out.println("Please select action\n" +
                        "Press 1 - Play Card from the hand\n" +
                        "Press 2 - Play Card on the field\n" +
                        "Press 3 - End Turn\n" +
                        "Press 4 - Surrender\n");
            }
            startMenuController(activePlayer, passivePlayer, field);
            System.out.println("end menu controller");
        }
    }

    public static void aiMenu(Player activePlayer, Player passivePlayer, Field field){
        System.out.println("ai menu started");
        AiMenuController.AiTurn(activePlayer, passivePlayer, field);
    }

    private static int scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void startMenuController(Player activePlayer, Player passivePlayer, Field field){
        MenuController.controller(scanner(),activePlayer, passivePlayer, field);

    }

    public static void endTurn(){
        System.out.println("end turn value changed");
        endTurn = true;
    }

}
