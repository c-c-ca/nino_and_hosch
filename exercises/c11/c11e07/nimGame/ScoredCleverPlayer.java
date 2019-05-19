package nimGame;

public class ScoredCleverPlayer extends ScoredPlayer {

    // Constructors:

    public ScoredCleverPlayer (String name) {
        super(new CleverPlayer(name));
    }
}
