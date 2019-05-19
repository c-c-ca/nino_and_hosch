package cardGame;

import nhUtilities.containers.*;

public class Example {
    public static void main (String[] argv) {
        List<PlayingCard> hand = new DefaultList<PlayingCard>();
        PlayingCard c =
            new PlayingCard(PlayingCard.HEART,3);
        hand.add(c);
        c = new PlayingCard(PlayingCard.HEART,8);
        hand.add(c);
        c = new PlayingCard(PlayingCard.HEART,2);
        hand.add(c);
        c = new PlayingCard(PlayingCard.CLUB,PlayingCard.JACK);
        hand.add(c);
        c = new PlayingCard(PlayingCard.HEART,PlayingCard.ACE);
        hand.add(c);
        System.out.println(PlayingCardUtility.sameSuit(hand));
    }
}
