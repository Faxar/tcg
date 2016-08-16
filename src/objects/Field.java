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
    }

    public void playerPutCardOnField(Minion card){
        playerField.add(card);
    }

    public void clearCardsFatgue(int field){
        if(field==1){
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
}

