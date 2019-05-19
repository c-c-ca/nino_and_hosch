package nimGame;

public class ScoredGreedyPlayer extends ScoredPlayer {

    // Constructors:

    public ScoredGreedyPlayer (String name) {
        super(new GreedyPlayer(name));
    }

}
