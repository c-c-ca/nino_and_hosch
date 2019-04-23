package nimGame;

import java.util.*;

/**
 * Allows the user to control a Player in the game simple nim.
 */
class UserStrategy implements PlayStrategy {

    private Scanner in;

    // Constructors:

    public UserStrategy () {
        this.in = new Scanner(System.in);
    }

    /**
     * The number of sticks to be removed from the specified
     * Pile.  maxOnATurn is the maximum number of sticks
     * a Player can remove on a turn.  At least one stick
     * will be removed.
     * @require    pile.sticks() > 0
     *             maxOnATurn > 0
     * @ensure     this.numberToTake() >= 1 &&
     *             this.numberToTake() <= maxOnATurn &&
     *             this.numberToTake() <= pile.sticks()
     */
    public int numberToTake (Pile pile,
        int maxOnATurn) {
        int max;
        if (pile.sticks() < maxOnATurn)
            max = pile.sticks();
        else
            max = maxOnATurn;
        return readNumberToTake(max);
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
