package nimGame;

import java.util.*;

class CleverController implements PlayerObserver {

    // Private components:

    private Game game;
    private Scanner in;

    // Constructors:

    public CleverController (ControlledPlayer player,
        Game game, Scanner in) {
            this.game = game;
            this.in = in;
            player.register(this);
    }

    public void update (ControlledPlayer player) {
        int number = Math.max(
                (game.sticksLeft() - 1) % (game.maxOnThisTurn() + 1),1);
        player.setNumberToTake(number);
    }
}
