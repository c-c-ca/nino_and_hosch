package puzzles;

public class Exercise {

    private final static int SIZE = 3;
    private final static int FROM = 1;
    private final static int TO = 3;

    public static void main (String[] argv) {
        PuzzleSolver solver = new PuzzleSolver();
        new PuzzleSolverTUI(solver);
        solver.moveTower(SIZE,FROM,TO);
    }
}
