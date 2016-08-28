package controller;

import objects.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by vassili.holenev on 9.07.2016.
 */
public class GameController {

    final int numberOfPlayers = 2;
    private Player activePlayer;
    private Player passivePlayer;
    private Field field;

    public GameController() {
    }

    public void initializeGame(){

        ArrayList<Player> list = new ArrayList<>();

        for(int i=0;i<numberOfPlayers;i++){
            Player player = createPlayer();
            Deck deck = createDeck();
            Hand hand = createHand();
            assignDecksAndHandAndToPlayers(player,deck,hand);
            createCards(player.deck);
            player.deck.shuffle();
            player.hand.populateHand(deck);
            list.add(player);
        }
        createField();
        randomStartPlayer(list);
        givePassivePlayerAdditionalCard();
        Game();

    }

    public void Game(){
        while(activePlayer.getHealth() > 0){
            activePlayer.hand.getOneCardFromDeck(activePlayer);
            startMenu(activePlayer, passivePlayer, field);
            endTurn();
            changeActivePlayers();
        }
    }

    private Deck createDeck(){
        return new Deck();
    }

    private Player createPlayer(){
        return new Player(true);
    }

    private Hand createHand(){
        return new Hand();
    }

    private void assignDecksAndHandAndToPlayers(Player player, Deck deck, Hand hand){
        player.deck = deck;
        player.hand = hand;
    }

    private void randomStartPlayer(ArrayList listOfPlayers){
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(1);
        activePlayer = (Player) listOfPlayers.get(randomNumber);
        listOfPlayers.remove(randomNumber);
        passivePlayer = (Player) listOfPlayers.get(0);
    }

    private void givePassivePlayerAdditionalCard(){
        passivePlayer.hand.getOneCardFromDeck(passivePlayer);
    }

    private void changeActivePlayers(){
        Player tempPlayer = passivePlayer;
        passivePlayer = activePlayer;
        activePlayer = tempPlayer;
    }

    private void startMenu(Player activePlayer, Player passivePlayer, Field field){
        if(activePlayer.isHuman()){
            Menu.humanMenu(activePlayer,passivePlayer, field);
        } else activePlayer.menu.aiMenu(activePlayer, passivePlayer, field);
    }

    private void createField(){
        field = new Field();
    }

    private static void createCards(Deck deck){
        CardBuilder.builder(deck);
    }

    private void endTurn(){
        //to be continued.
    }

}
