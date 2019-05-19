package nimGame;

import java.util.*;

class GreedyController implements PlayerObserver {

    // Private components:

    private Game game;
    private Scanner in;

    // Constructors:

    public GreedyController (ControlledPlayer player,
        Game game, Scanner in) {
            this.game = game;
            this.in = in;
            player.register(this);
    }

    public void update (ControlledPlayer player) {
        int number = game.maxOnThisTurn();
        player.setNumberToTake(number);
    }
}
