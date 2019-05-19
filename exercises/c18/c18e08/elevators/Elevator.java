package elevators;

import java.util.*;

/**
 * A simple elevator.
 */
public class Elevator extends Observable {

    // Nested inner class:

    /**
     * A state of the Elevator.
     */
    private class State {

        // Private components:

        private int floor;
        private boolean goingUp;
        private State next;

        // Constructors:

        /**
         * Create a State for the specified floor
         * and direction.
         */
        private State (int floor, boolean goingUp) {
            this.floor = floor;
            this.goingUp = goingUp;
        }

        // Queries:

        /**
         * The floor of this State.
         */
        public int floor () {
            return floor;
        }

        /**
         * This is a "going up" State.
         */
        public boolean goingUp () {
            return goingUp;
        }

        /**
         * The State after the Elevator moves.
         */
        public State next () {
            return next;
        }

        // Commands:

        /**
         * Set the State after this State.
         */
        public void setNext (State next) {
            this.next = next;
        }
    } // end of class State

    // Private components:

    private State state;

    // Constructors:

    /**
     * Create an Elevator traversing the specified
     * number of floors.
     */
    public Elevator (int floors) {
        int floor = 1;
        State top = new State(floors,false);
        State bottom = new State(floor,true);
        State down = top;
        State up = bottom;
        State nextUp, nextDown;
        while (floor < floors - 1) {
            floor = floor + 1;
            nextUp = new State(floor,true);
            nextDown = new State(floors+1-floor,false);
            up.setNext(nextUp);
            down.setNext(nextDown);
            up = nextUp;
            down = nextDown;
        }
        up.setNext(top);
        down.setNext(bottom);
        state = bottom;
    }

    /**
     * The floor this Elevator is on.  The bottom floor
     * is numbered 1.
     */
    public int floor () {
        return state.floor();
    }

    /**
     * The Elevator is going up.
     */
    public boolean goingUp () {
        return state.goingUp();
    }

    // Commands:

    /**
     * Move to the next floor.
     */
    public void move () {
        state = state.next();
        setChanged();
        notifyObservers();
    }
}
