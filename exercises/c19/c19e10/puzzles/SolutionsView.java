package puzzles;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import nhUtilities.containers.List;

public class SolutionsView extends JFrame {

    private PuzzleSolver solver;

    public SolutionsView () {
        super("Queens Problem");

        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints =
            new GridBagConstraints();
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = 0;
        constraints.insets = new Insets(5,5,5,5);

        solver = new PuzzleSolver();
        ChessBoardView view = new ChessBoardView(solver);
        view.setBorder(new TitledBorder(
            LineBorder.createBlackLineBorder(),
            "Backtracking Solution", TitledBorder.CENTER,
            TitledBorder.DEFAULT_POSITION,
            new Font(Font.MONOSPACED,
                     Font.BOLD, 20)));
        getContentPane().add(view,constraints);
        solver.addQueen();
        view.runAnimation();

        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                e.getWindow().dispose();
            }
            public void windowClosed (WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
