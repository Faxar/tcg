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
        setOnePlayerAsAI(list);
        Game();

    }

    public void Game(){
        while(activePlayer.getHealth() > 0){
            activePlayer.hand.getOneCardFromDeck(activePlayer);
            startMenu(activePlayer, passivePlayer, field);
            endTurn();
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
        System.out.println(listOfPlayers.size());
        activePlayer = (Player) listOfPlayers.get(randomNumber);
        listOfPlayers.remove(randomNumber);
        System.out.println(listOfPlayers.size());
        passivePlayer = (Player) listOfPlayers.get(0);
    }

    private void givePassivePlayerAdditionalCard(){
        passivePlayer.hand.getOneCardFromDeck(passivePlayer);
    }

    private void changeActivePlayers(){
        Player tempPlayer = passivePlayer;
        System.out.println(tempPlayer.isHuman());
        this.passivePlayer = this.activePlayer;
        this.activePlayer = tempPlayer;
        System.out.println(activePlayer.isHuman());
    }

    private void startMenu(Player activePlayer, Player passivePlayer, Field field){
        if(activePlayer.isHuman()){
            Menu.humanMenu(activePlayer,passivePlayer, field);
        } else Menu.aiMenu (activePlayer, passivePlayer, field);
    }

    private void createField(){
        field = new Field();
    }

    private static void createCards(Deck deck){
        CardBuilder.builder(deck);
    }

    private void endTurn(){
        System.out.println("turn ended");
        changeActivePlayers();
        field.clearCardsFatgue(activePlayer);
        activePlayer.increaseManaTurn();
    }

    private void setOnePlayerAsAI(ArrayList<Player> player){
        Random random = new Random();
        int randomNumber = random.nextInt(1);
        player.get(randomNumber).setAsAI();
    }

}
