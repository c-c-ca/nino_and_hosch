package cardGame;

import java.util.Comparator;

public class Example {

    private static PlayingCard[] hand;
    private static int i;

    private static void initializeHand () {
        hand = new PlayingCard[5];
        add(PlayingCard.ACE, PlayingCard.SPADE);
        add(5, PlayingCard.DIAMOND);
        add(PlayingCard.JACK, PlayingCard.HEART);
        add(10, PlayingCard.HEART);
        add(5, PlayingCard.SPADE);
    }

    private static void add (int rank, int suit) {
        hand[i++] = new PlayingCard(suit,rank);
    }

    private static void sortCards () {
        (new ArrayUtilities()).selectionSort(hand,
            new Comparator<PlayingCard>() {
                public int compare (PlayingCard c1, PlayingCard c2) {
                    return c1.compareTo(c2);
                }
            });
    }

    private static void displayCards (String when) {
        System.out.println(when);
        for (int i = 0; i < hand.length; i = i+1)
            System.out.println(
                "        " + hand[i]);
        System.out.println();
    }

    public static void main (String[] argv) {
        initializeHand();
        displayCards("Before:");
        sortCards();
        displayCards("After:");
    }
}
