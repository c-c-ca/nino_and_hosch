package nimGame;

public class ScoredTimidPlayer extends ScoredPlayer {

    // Constructors:

    public ScoredTimidPlayer (String name) {
        super(new TimidPlayer(name));
    }

}
