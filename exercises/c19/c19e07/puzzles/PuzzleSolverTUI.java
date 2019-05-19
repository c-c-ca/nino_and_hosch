package puzzles;

import java.util.*;

public class PuzzleSolverTUI implements Observer {

    public PuzzleSolverTUI (PuzzleSolver model) {
        model.addObserver(this);
    }

    public void update (Observable model, Object arg) {
        Move m = (Move)arg;
        int to = m.to();
        int from = m.from();
        nhUtilities.utilities.Control.sleep(1);
        System.out.println(
            "Move a disk from peg " + from +
            " to peg " + to + ".");
    }
}
