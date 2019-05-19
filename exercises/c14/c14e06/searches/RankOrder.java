package searches;

import java.util.Comparator;

public class RankOrder implements
    Comparator<PlayingCard> {
    public int compare (PlayingCard c1, PlayingCard c2) {
        return c1.rank() - c2.rank();
    }
}
