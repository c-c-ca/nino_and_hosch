package nimGame;

import java.util.*;

class PlayerController implements PlayerObserver {

    // Private components:

    private Game game;
    private Scanner in;

    // Constructors:

    public PlayerController (InteractivePlayer player,
        Game game, Scanner in) {
            this.game = game;
            this.in = in;
            player.register(this);
    }

    public void update (InteractivePlayer player) {
        int numberToTake = readNumberToTake();
        player.setNumberToTake(numberToTake);
    }

    private int readNumberToTake () {
        int number = 0;
        int max = game.maxOnThisTurn();
        while (!(0 < number && number <= max)) {
            System.out.print("Enter number to take " +
               "(a positive integer, at most " + max +
               "): ");
            System.out.flush();
            if (in.hasNextInt())
                number = in.nextInt();
            in.nextLine();
        }
        return number;
    }
}
