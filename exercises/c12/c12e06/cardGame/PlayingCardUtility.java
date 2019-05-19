package cardGame;

import nhUtilities.containers.*;

public class PlayingCardUtility {

    /**
     * The specified List<PlayingCard> contains two cards
     * with the same value.
     */
    public static boolean hasPair (List<PlayingCard> hand) {
        if (hand.size() > 1) {
            for (int i = 0; i < hand.size() - 1; i = i + 1)
                for (int j = i + 1; j < hand.size(); j = j + 1)
                    if (hand.get(i).rank() == hand.get(j).rank())
                        return true;
            return false;
        } else
            return false;
    }
}
