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
     * The number of rows in this Matrix.
     */
    public int rows () {
        return elements.length;
    }

    /**
     * The number of columns in this Matrix.
     */
    public int columns () {
        return elements[0].length;
    }

    /**
     * Returns the value at the specified row and
     * column for this Matrix.
     */
    public int getValue (int row, int column) {
        return elements[row][column];
    }

    /**
     * Returns the product of this Matrix and the
     * specified Matrix.
     * @require    this.columns() == other.rows() ||
     *             this.rows() == other.columns()
     * @ensure     if (this.columns() == other.rows())
     *               result.rows() == this.rows() &&
     *               result.columns() == this.columns()
     *             else
     *               result.rows() == other.rows() &&
     *               result.columns() == other.columns()
     */
    public Matrix product (Matrix other) {
        Matrix a, b, product;
        int m, n, p, sum;

        if (this.columns() == other.rows()) {
            a = this;
            b = other;
        } else { // this.rows() == other.columns()
            a = other;
            b = this;
        }

        m = b.columns();
        n = a.rows();
        p = a.columns();

        product = new Matrix(n,m);
        for (int r = 0; r < n; r = r+1)
            for (int c = 0; c < m; c = c+1) {
                sum = 0;
                for (int i = 0; i < p; i = i+1)
                    sum += a.getValue(r,i) * b.getValue(i,c);
                product.setValue(r,c,sum);
            }
        return product;
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

    /**
     * A String representation of this Matrix.
     */
    public String toString () {
        String s = "{";
        for (int i = 0; i < rows(); i = i+1) {
            s = s + (i > 0 ? " " : "") +
                "{" + getValue(i,0);
            for (int j = 1; j < columns(); j = j+1)
                s = s + ", " + getValue(i,j);
            s = s + "}" + (i < rows()-1 ? "\n" : "");
        }
        return s + "}";
    }
}
