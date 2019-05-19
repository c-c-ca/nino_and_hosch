package matrix;

/**
 * Models an integer matrix.
 */
public class Matrix {

    // Private components:

    private int[][] elements;

    // Constructors:

    /**
     * Create a matrix with the specified number
     * of rows and columns.
     * @require    rows > 0 && columns > 0
     */
    public Matrix (int rows, int columns) {
        this.elements = new int[rows][columns];
    }

    // Queries:

    /**
     * Returns the value at the specified row and
     * column for this Matrix.
     */
    public int getValue (int row, int column) {
        return elements[row][column];
    }

    // Commands:

    /**
     * Set the integer at the specified row and
     * column for this Matrix to the specified
     * value.
     */
    public void setValue (
        int row, int column, int value) {
        elements[row][column] = value;
    }
}
