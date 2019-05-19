package puzzles;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import nhUtilities.containers.List;
import nhUtilities.containers.DefaultList;

public class SolutionsView extends JFrame {

    private final static String PREV_LABEL = "Previous";
    private final static String NEXT_LABEL = "Next";
    private final static int INSETS = 10;

    private JButton prevButton;
    private JButton nextButton;
    private ChessBoardView chessPanel;

    private List<List<Queen>> solutions;
    private int solutionNumber;
    private int totalSolutions;

    public SolutionsView (QueensProblem model) {
        super("Queens Problem using Object Recursion");
        solutionNumber = 0;

        solutions = new DefaultList<List<Queen>>();
        model.first();
        while (model.solved()) {
            solutions.add(model.queens());
            model.next();
        }

        if (solutions.size() > 0) {
            totalSolutions = solutions.size();
            chessPanel = new ChessBoardView(solutions.get(solutionNumber),
                            solutionNumber, totalSolutions);

            getContentPane().add(chessPanel, BorderLayout.NORTH);
            getContentPane().add(buttonPanel(), BorderLayout.SOUTH);

            new QPController();
        } else
            getContentPane().add(new JLabel(
                "No solutions exist for this board"));


        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                e.getWindow().dispose();
            }
            public void windowClosed (WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private JPanel buttonPanel () {
        JPanel p = new JPanel();
        prevButton = new JButton(PREV_LABEL);
        nextButton = new JButton(NEXT_LABEL);
        prevButton.setEnabled(false);
        p.add(prevButton);
        p.add(nextButton);
        return p;
    }

    private class QPController implements ActionListener {

        public QPController () {
            SolutionsView.this.prevButton.addActionListener(this);
            SolutionsView.this.nextButton.addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == nextButton &&
                solutionNumber < totalSolutions-1) {
                solutionNumber = solutionNumber + 1;
                prevButton.setEnabled(true);
            } else if (solutionNumber > 0) {
                solutionNumber = solutionNumber - 1;
                nextButton.setEnabled(true);
            }
            if (solutionNumber == 0)
                prevButton.setEnabled(false);
            else if (solutionNumber == solutions.size()-1)
                nextButton.setEnabled(false);
            List<Queen> solution = solutions.get(solutionNumber);
            SolutionsView.this.getContentPane().remove(chessPanel);
            chessPanel = new ChessBoardView(solution,
                solutionNumber, totalSolutions);
            SolutionsView.this.getContentPane().add(
                chessPanel, BorderLayout.NORTH);
            SolutionsView.this.revalidate();
        }
    }

}
