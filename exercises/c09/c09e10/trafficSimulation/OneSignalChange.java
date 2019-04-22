package trafficSimulation;

/**
 * Models the state of an Intersection when one signal will
 * be changed on the next Intersection state change.
 */
public class OneSignalChange implements IntersectionState {

    // Private components:

    private TrafficSignal signal;
    private IntersectionState next;

    // Constructors:

    /**
     * Create an IntersectionState that changes the specified
     * Traffic Signal.
     */
    public OneSignalChange (TrafficSignal signal) {
        this.signal = signal;
    }

    // Queries:

    /**
     * The next state after this one.
     */
    public IntersectionState next () {
        return next;
    }

    // Commands:

    /**
     * Change this IntersectionState's TrafficSignals.
     */
    public void execute () {
        signal.change();
    }

    /**
     * Set the next state.
     * @ensure     this.next() == next
     */
    public void setNext (IntersectionState next) {
        this.next = next;
    }
}
