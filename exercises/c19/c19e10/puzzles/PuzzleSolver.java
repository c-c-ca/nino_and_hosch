package puzzles;

import nhUtilities.containers.List;
import nhUtilities.containers.DefaultList;

import java.util.*;

public class PuzzleSolver extends Observable {

    private final static int SIZE = 8;

    public List<Queen> addQueen () {
        return addQueen(new DefaultList<Queen>(),1);
    }

    private List<Queen> addQueen (List<Queen> rows, int row) {
        if (row > SIZE)
            return rows;
        else {
            boolean found = false;
            List<Queen> solution = null;
            int column = 1;
            while (column <= SIZE && !found) {
                // The following two lines should be placed
                // in the code block following the if-statement
                // for optimization, (i.e. no copy of the
                // solution should be made for a queen that
                // can be attacked), but are placed here for
                // animation purposes.
                Queen queen = new Queen(row,column);
                List<Queen> extendedRows = rows.copy();
                extendedRows.add(queen);
                setChanged();
                notifyObservers(extendedRows);
                if (!canAttack(queen,rows)) {
                    solution = addQueen(extendedRows,row+1);
                    found = solution != null;
                }
                column = column+1;
            }
            return solution;
        }
    }

    private boolean canAttack (Queen queen, List<Queen> rows) {
        int r1, c1, r2, c2;
        r1 = queen.row();
        c1 = queen.column();
        for (int i = 0; i < rows.size(); i = i+1) {
            r2 = rows.get(i).row();
            c2 = rows.get(i).column();
            if (Math.abs(r2-r1) == Math.abs(c2-c1) || c1 == c2)
                return true;
        }
        return false;
    }
}
