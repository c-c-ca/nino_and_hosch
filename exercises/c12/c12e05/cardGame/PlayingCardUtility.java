package cardGame;

import nhUtilities.containers.*;

public class PlayingCardUtility {

    /**
     * All of the PlayingCards in the specified List<PlayingCard>
     * are of the same suit.
     */
    public static boolean sameSuit (List<PlayingCard> hand) {
        if (hand.size() > 0) {
            int suit = hand.get(0).suit();
            for (int i = 1; i < hand.size(); i = i + 1)
                if (suit != hand.get(i).suit())
                    return false;
        }
        return true;
    }
}
