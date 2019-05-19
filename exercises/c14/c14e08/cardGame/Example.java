package cardGame;

import java.util.Comparator;

import nhUtilities.containers.*;

public class Example {

    private static List<PlayingCard> hand1;
    private static List<PlayingCard> hand2;
    private static List<PlayingCard> hand3;

    private static void initializeHands () {
        hand1 = new DefaultList<PlayingCard>();
        hand2 = new DefaultList<PlayingCard>();
        add(hand1, PlayingCard.ACE, PlayingCard.SPADE);
        add(hand1, 5, PlayingCard.DIAMOND);
        add(hand1, PlayingCard.JACK, PlayingCard.HEART);
        add(hand1, 10, PlayingCard.HEART);
        add(hand1, 5, PlayingCard.SPADE);
        add(hand2, 7, PlayingCard.CLUB);
        add(hand2, 3, PlayingCard.HEART);
        add(hand2, PlayingCard.JACK, PlayingCard.SPADE);
        add(hand2, PlayingCard.ACE, PlayingCard.DIAMOND);
        add(hand2, 2, PlayingCard.CLUB);
    }

    private static void add (List<PlayingCard> hand,
        int rank, int suit) {
        hand.add(new PlayingCard(suit,rank));
    }

    private static void sortCards (List<PlayingCard> hand) {
        System.out.println("sorting...");
        System.out.println();
        (new ListUtilities<PlayingCard>()).selectionSort(hand,
            new Comparator<PlayingCard>() {
                public int compare (PlayingCard c1, PlayingCard c2) {
                    return c1.compareTo(c2);
                }
            });
    }

    private static List<PlayingCard> mergeCards (
        List<PlayingCard> hand1, List<PlayingCard> hand2) {
        System.out.println("merging...");
        System.out.println();
        return (new ListUtilities<PlayingCard>()).merge(hand1,hand2,
            new Comparator<PlayingCard>() {
                public int compare (PlayingCard c1, PlayingCard c2) {
                    return c1.compareTo(c2);
                }
            });
    }

    private static void displayCards (int n, List<PlayingCard> hand) {
        System.out.println("Hand " + n + ":");
        for (int i = 0; i < hand.size(); i = i+1)
            System.out.println(
                "        " + hand.get(i));
        System.out.println();
    }

    public static void main (String[] argv) {
        initializeHands();

        displayCards(1, hand1);
        displayCards(2, hand2);

        sortCards(hand1);
        displayCards(1, hand1);

        sortCards(hand2);
        displayCards(2, hand2);

        hand3 = mergeCards(hand1,hand2);
        displayCards(3,hand3);
    }
}
