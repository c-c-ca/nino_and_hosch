package trafficSimulation;

/**
 * Models the state of an Intersection when both signals will
 * be changed on the next Intersection state change.
 */
public class TwoSignalChange implements IntersectionState {

    // Private components:

    private TrafficSignal signal1;
    private TrafficSignal signal2;
    private IntersectionState next;

    // Constructors:

    /**
     * Create an IntersectionState that changes the specified
     * Traffic Signals.
     */
    public TwoSignalChange (TrafficSignal signal1,
                            TrafficSignal signal2) {
        this.signal1 = signal1;
        this.signal2 = signal2;
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
        signal1.change();
        signal2.change();
    }

    /**
     * Set the next state.
     * @ensure     this.next() == next
     */
    public void setNext (IntersectionState next) {
        this.next = next;
    }
}
