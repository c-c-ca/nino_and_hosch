package cardGame;

import java.util.Comparator;

import nhUtilities.containers.*;

public class Example {

    private static List<PlayingCard> hand;

    private static void initializeHand () {
        hand = new DefaultList<PlayingCard>();
        add(PlayingCard.ACE, PlayingCard.SPADE);
        add(5, PlayingCard.DIAMOND);
        add(PlayingCard.JACK, PlayingCard.HEART);
        add(10, PlayingCard.HEART);
        add(5, PlayingCard.SPADE);
        add(6, PlayingCard.CLUB);
        add(8, PlayingCard.HEART);
        add(PlayingCard.KING, PlayingCard.DIAMOND);
    }

    private static void add (int rank, int suit) {
        hand.add(new PlayingCard(suit,rank));
    }

    private static void sortCards () {
        (new ListUtilities<PlayingCard>()).selectionSort(hand,
            new Comparator<PlayingCard>() {
                public int compare (PlayingCard c1, PlayingCard c2) {
                    if (c1.suit() == c2.suit())
                        return c1.rank() - c2.rank();
                    else
                        return c1.suit() - c2.suit();
                }
            });
    }

    private static void displayCards (String when) {
        System.out.println(when);
        for (int i = 0; i < hand.size(); i = i+1)
            System.out.println(
                "        " + hand.get(i));
        System.out.println();
    }

    public static void main (String[] argv) {
        initializeHand();
        displayCards("Before:");
        sortCards();
        displayCards("After:");
    }
}
