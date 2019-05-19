package nimGame;

import java.util.*;

class TimidController implements PlayerObserver {

    // Private components:

    private Game game;
    private Scanner in;

    // Constructors:

    public TimidController (ControlledPlayer player,
        Game game, Scanner in) {
            this.game = game;
            this.in = in;
            player.register(this);
    }

    public void update (ControlledPlayer player) {
        player.setNumberToTake(1);
    }
}
