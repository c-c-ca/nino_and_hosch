package puzzles;

public class Queen {

    private int row;
    private int column;

    public Queen (int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int row () {
        return row;
    }

    public int column () {
        return column;
    }
}
