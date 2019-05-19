package cardGame;

import nhUtilities.containers.*;
import java.io.*;
import static cardGame.PlayingCard.*;
import static cardGame.PlayingCardUtilities.*;

public class Exercise {

    private static final String FILE_NAME = "card_data";

    private static List<PlayingCard> hand;

    public static void main (String[] argv) {
        generateHand();
        // saveHand();
        clearHand();
        restoreHand();
        displayHand();
    }

    private static void addCard (int suit, int rank) {
        hand.add(new PlayingCard(suit,rank));
    }

    private static void generateHand () {
        hand = new DefaultList<PlayingCard>();
        addCard(CLUB,5);
        addCard(DIAMOND,8);
        addCard(SPADE,3);
        addCard(SPADE,KING);
        addCard(HEART,8);
    }

    private static void displayHand () {
        for (int i = 0; i < hand.size(); i = i+1)
            System.out.println(hand.get(i));
    }

    private static void saveHand () {
        try {
            (new File(FILE_NAME)).delete();
            for (int i = 0; i < hand.size(); i = i+1)
                saveCard(hand.get(i),FILE_NAME);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void restoreHand () {
        try {
            hand = restoreCardList(FILE_NAME);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void clearHand () {
        hand = new DefaultList<PlayingCard>();
    }
}
