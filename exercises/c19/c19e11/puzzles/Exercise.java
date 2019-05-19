package puzzles;

public class Exercise {

    private final static int SIZE = 10;

    public static void main (String[] argv) {
        SolutionsView ui =
            new SolutionsView(new QueensProblem(SIZE));
        ui.pack();
        ui.setVisible(true);
    }
}
