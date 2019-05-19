package containers;

import java.util.Comparator;
import nhUtilities.containers.OrderedList;

public class Example {

    private static OrderedList<PlayingCard> hand;

    private static void initializeHand () {
        hand = new DefaultOrderedList<PlayingCard>(
            new Comparator<PlayingCard>() {
                public int compare (PlayingCard p1, PlayingCard p2) {
                    return p1.compareTo(p2);
                }
            });
        add(PlayingCard.ACE, PlayingCard.SPADE);
        add(5, PlayingCard.DIAMOND);
        add(PlayingCard.JACK, PlayingCard.HEART);
        add(10, PlayingCard.HEART);
        add(5, PlayingCard.SPADE);
        add(6, PlayingCard.HEART);
        add(PlayingCard.QUEEN, PlayingCard.CLUB);
    }

    private static void add (int rank, int suit) {
        hand.add(new PlayingCard(suit,rank));
    }

    private static void displayCards () {
        for (int i = 0; i < hand.size(); i = i+1)
            System.out.println(hand.get(i));
        System.out.println();
    }

    private static void removeCards () {
        hand.remove(3);
        hand.remove(3);
    }

    public static void main (String[] argv) {
        initializeHand();
        displayCards();
        removeCards();
        displayCards();
    }
}
