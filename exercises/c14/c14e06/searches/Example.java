package searches;

import java.util.Comparator;

import nhUtilities.containers.*;

public class Example {

    private static OrderedList<PlayingCard> hand;
    private static Comparator<PlayingCard> order;

    private static void addCard (int suit, int rank) {
        hand.add(new PlayingCard(suit,rank));
    }

    private static void initializeHand () {
        order = new RankOrder();
        hand = new DefaultOrderedList<PlayingCard>(order);
        addCard(PlayingCard.SPADE, 4);
        addCard(PlayingCard.DIAMOND, 4);
        addCard(PlayingCard.CLUB, 4);
        addCard(PlayingCard.HEART, 4);
        addCard(PlayingCard.CLUB, PlayingCard.ACE);
    }

    private static void displayCards () {
        System.out.println("Cards:");
        for (int i = 0; i < hand.size(); i++)
            System.out.println("        " + hand.get(i));
        System.out.println();
    }

    private static int findEquivalent (
        PlayingCard card) {
        System.out.println("Searching for:   " + card);
        return (new Searches()).indexOf(card,hand,order);
    }

    private static void displayEquivalent (int match) {
        if (match < 0)
            System.out.println("No equivalent card found.");
        else
            System.out.println(
                "Equivalent card: " + hand.get(match));
    }

    public static void main (String[] argv) {
        initializeHand();
        displayCards();
        int match = findEquivalent(
            new PlayingCard(PlayingCard.HEART, 4));
        displayEquivalent(match);

    }
}
