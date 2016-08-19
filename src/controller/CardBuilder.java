package controller;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import objects.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vassili.holenev on 28.07.2016.
 */
public class CardBuilder {

    public static void builder(Deck deck) {
        File xmlFile = new File("src/Decks/chaos.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Card");

            List<Card> cardList = new ArrayList<Card>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                cardList.add(getCard(nodeList.item(i)));
            }

            for (Card card : cardList) {
                deck.populateDeck(card);

            }
        } catch (
                Exception exc
                )

        {
            exc.printStackTrace();
        }
    }

    private static Card getCard(Node node){
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            if(Integer.parseInt(getTagValue("Minion", element)) == 1){
                Minion minion = new Minion();
                minion.setId(Integer.parseInt(getTagValue("id", element)));
                minion.setName(getTagValue("Name", element));
                minion.setPower(Integer.parseInt(getTagValue("Strength", element)));
                minion.setHealth(Integer.parseInt(getTagValue("Health", element)));
                minion.setMana(Integer.parseInt(getTagValue("Mana", element)));
                return minion;
            }
        }
        System.out.println("return null");
        return null;
    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }


    private static String feedPath(int number){
        String path = CardBuilder.class.getClassLoader().getResource("").toString();
        if(number == 1){
            return ("src/decks/space.xml");
        } else if (number == 2) {
            return ("src/decks/orks.xml");
        } else if (number == 3){
            return ("src/decks/chaos.xml");
        } else if (number == 4){
            return ("src/decks/necrons.xml");
        } return null;
    }

}
