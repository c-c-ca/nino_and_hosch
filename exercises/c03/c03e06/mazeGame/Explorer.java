package mazeGame;

/**
 * A maze game player.
 */
public class Explorer {

    // Private components:

    private String name;       // name
    private Room location;     // current location
    private int annoyability;  // current ability to annoy
                               // (hit points)
    private int tolerance;     // current tolerance
                               // (hit points)

    // Constructors:

    /**
     * Create a new Explorer with the specified name,
     * initial location, annoyability, and tolerance.
     */
    public Explorer (String name, Room location,
                     int annoyability, int tolerance) {
        this.name = name;
        this.location = location;
        this.annoyability = annoyability;
        this.tolerance = tolerance;
    }

    // Queries:

    /**
     * Name of this Explorer.
     */
    public String name () {
        return name;
    }

    /**
     * Room in which this Explorer is currently located.
     */
    public Room location () {
        return location;
    }

    /**
     * Annoyance (hit points) this Explorer causes when
     * poking an opponent.
     */
    public int annoyability () {
        return annoyability;
    }

    /**
     * Annoyance (hit points) required to vanquish this
     * Explorer.
     */
    public int tolerance () {
        return tolerance;
    }

    // Commands:

    /**
     * Move to the specified Room.
     */
    public void move (Room newRoom) {
        location = newRoom;
    }

    /**
     * Receive a poke of the specified number of hit
     * points.
     */
    public void takeThat (int annoyance) {
        tolerance = tolerance - annoyance;
    }

    /**
     * Poke the specified Denizen.
     */
    public void poke (Denizen opponent) {
        opponent.takeThat(annoyability);
    }

    /**
     * Set this Explorer's annoyability to the specified
     * value.  value is a non-negative integer.
     */
    public void changeAnnoyability (int value) {
        this.annoyability = value;
    }

    /**
     * Set this Explorer's tolerance to the specified
     * value.  value is a non-negative integer.
     */
    public void changeTolerance (int value) {
        this.tolerance = value;
    }

}
