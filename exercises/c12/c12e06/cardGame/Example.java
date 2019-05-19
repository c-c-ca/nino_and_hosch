package cardGame;

import nhUtilities.containers.*;

public class Example {
    public static void main (String[] argv) {
        List<PlayingCard> hand = new DefaultList<PlayingCard>();
        PlayingCard c =
            new PlayingCard(PlayingCard.HEART,10);
        hand.add(c);
        c = new PlayingCard(PlayingCard.HEART,5);
        hand.add(c);
        c = new PlayingCard(PlayingCard.HEART,9);
        hand.add(c);
        c = new PlayingCard(PlayingCard.CLUB,3);
        hand.add(c);
        c = new PlayingCard(PlayingCard.HEART,3);
        hand.add(c);
        System.out.println(PlayingCardUtility.hasPair(hand));
    }
}
