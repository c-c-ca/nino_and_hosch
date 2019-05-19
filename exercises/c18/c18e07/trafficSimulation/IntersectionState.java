package trafficSimulation;

/**
 * Models the state of an Intersection.  Contains the TrafficSignals
 * that will be changed on the next Intersection state change.
 */
public interface IntersectionState {

    // Queries:

    /**
     * The next state after this one.
     */
    public IntersectionState next ();

    // Commands:

    /**
     * Change this IntersectionState's TrafficSignal(s).
     */
    public void execute ();

    /**
     * Set the next state.
     * @ensure     this.next() == next
     */
    public void setNext (IntersectionState next);
}
