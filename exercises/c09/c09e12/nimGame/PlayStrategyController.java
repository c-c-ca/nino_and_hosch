package nimGame;

import java.util.*;

class PlayStrategyController implements PlayStrategyObserver {

    // Private components:

    private Game game;
    private Scanner in;

    // Constructors:

    public PlayStrategyController (Game game, Scanner in,
                                   UserStrategy strategy) {
        this.game = game;
        this.in = in;
        strategy.register(this);
    }

    public void update (UserStrategy strategy) {
        int max = game.maxOnThisTurn();
        int numberToTake = readNumberToTake(max);
        strategy.setNumberToTake(numberToTake);
    }

    private int readNumberToTake (int max) {
        int number = 0;
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
