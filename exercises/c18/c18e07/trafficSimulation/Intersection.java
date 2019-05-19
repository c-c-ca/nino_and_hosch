package trafficSimulation;

import java.util.*;

/**
 * Models a simple four-way intersection.
 */
public class Intersection extends Observable {

    // Private components:

    private TrafficSignal northSouth;   // North-South signal
    private TrafficSignal eastWest;     // East-West signal
    private TrafficSignal dummy;        // a dummy signal

    private IntersectionState current;  // the current state

    // Constructors:

    /**
     * Create a new Intersection.
     * @ensure     this.northSouth() == TrafficSignal.GREEEN &&
     *             this.eastWest() == TrafficSignal.RED
     */
    public Intersection () {
        // initialize TrafficSignals
        northSouth = new TrafficSignal();
        eastWest = new TrafficSignal();
        dummy = new TrafficSignal();
        eastWest.change(); eastWest.change();
        // initialize TrafficStates
        IntersectionState state1 =
                new OneSignalChange(northSouth);
        IntersectionState state2 =
                new TwoSignalChange(northSouth, eastWest);
        IntersectionState state3 =
                new OneSignalChange(eastWest);
        IntersectionState state4 =
                new TwoSignalChange(northSouth, eastWest);
        state1.setNext(state2);
        state2.setNext(state3);
        state3.setNext(state4);
        state4.setNext(state1);
        // set the current state
        current = state1;
    }

    // Queries:

    /**
     * The color of the East-West light for this TrafficSignal.
     * @ensure     result == TrafficSignal.GREEN ||
     *             result == TrafficSignal.YELLOW ||
     *             result == TrafficSignal.RED
     */
    public int eastWest () {
        return eastWest.light();
    }


    /**
     * The color of the North-South light for this TrafficSignal.
     * @ensure     result == TrafficSignal.GREEN ||
     *             result == TrafficSignal.YELLOW ||
     *             result == TrafficSignal.RED
     */
    public int northSouth () {
        return northSouth.light();
    }

    // Commands:

    /**
     * Change one or both of the TrafficSignals for this Intersection.
     * When one signal is green or yellow, the other must be red.
     * @ensure     if old.eastWest.light() == TrafficSignal.GREEN
     *                 this.eastWest.light() == TrafficSignal.YELLOW &&
     *                 this.northSouth.light() == TrafficSignal.RED
     *             if old.eastWest.light() == TrafficSignal.YELLOW
     *                 this.eastWest.light() == TrafficSignal.RED &&
     *                 this.northSouth.light) == TrafficSignal.GREEN
     *             if old.northSouth.light() == TrafficSignal.GREEN
     *                 this.northSouth.light() == TrafficSignal.YELLOW &&
     *                 this.eastWest.light() == TrafficSignal.RED
     *             if old.northSouth.light() == TrafficSignal.YELLOW
     *                 this.northSouth.light() == TrafficSignal.RED &&
     *                 this.eastWest.light() == TrafficSignal.GREEN
     */
    public void change () {
        current.execute();
        current = current.next();
        setChanged();
        notifyObservers();
    }
}
