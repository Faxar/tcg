package objects;

import controller.MenuController;

import java.util.Scanner;

/**
 * Created by vassili.holenev on 19.07.2016.
 */
public class Menu {

    public Menu() {
    }

    public static void humanMenu(Player activePlayer, Player passivePlayer, Field field){
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

    }

    public void aiMenu(){

    }

    private static int scanner(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }

    private static void startMenuController(Player activePlayer, Player passivePlayer, Field field){
        MenuController.controller(scanner(),activePlayer, passivePlayer, field);
    }


}
