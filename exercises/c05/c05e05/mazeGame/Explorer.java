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
                               // invariant:
                               // tolerance >= 0

    // Constructors:

    /**
     * Create a new Explorer with the specified name,
     * initial location, annoyability, and tolerance.
     * @require    annoyability >= 0
     *             tolerance >= 0
     * @ensure     this.name().equals(name)
     *             this.location().equals(location)
     *             this.annoyability() == annoyability
     *             this.tolerance() == tolerance
     */
    public Explorer (String name, Room location,
                     int annoyability, int tolerance) {
        assert name != null :
            "precondition: name != null";
        assert location != null :
            "precondition: location != null";
        assert annoyability >= 0 :
            "precondition: annoyability (" + annoyability + ") >= 0";
        assert tolerance >= 0 :
            "precondition: tolerance (" + tolerance + ") >= 0";
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
     * @ensure     this.tolerance() >= 0
     */
    public int tolerance () {
        return tolerance;
    }

    // Commands:

    /**
     * Move to the specified Room.
     */
    public void move (Room newRoom) {
        location.exit();
        location = newRoom;
        location.enter();
    }

    /**
     * Receive a poke of the specified number of hit
     * points.
     * @require    annoyance >= 0
     * @ensure     this.tolerance() <= old.tolerance()
     */
    public void takeThat (int annoyance) {
        if (annoyance <= tolerance)
            tolerance = tolerance - annoyance;
        else
            tolerance = 0;
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
