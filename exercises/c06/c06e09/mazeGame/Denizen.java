package mazeGame;

public class Denizen {

    // Private components:

    private int tolerance;      // current tolerance
                                // (hit points)

    // Constructors:

    /**
     * Create a new Denizen with the specified tolerance.
     */
    public Denizen (int tolerance) {
        this.tolerance = tolerance;
    }

    // Queries:

    /**
     * Annoyance (hit points) required to vanquish this Denizen.
     */
    public int tolerance () {
        return tolerance;
    }

    // Commands:

    /**
     * Receive a poke of the specified number of hit points.
     */
    public void takeThat (int annoyance) {
        if (annoyance <= tolerance)
            tolerance = tolerance - annoyance;
        else
            tolerance = 0;
    }
}
