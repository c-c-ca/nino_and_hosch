package operations;

/**
 * Models integer operation of multiplication.
 */
public class Multiplication implements OperatorWithIdentity {

    private static final int IDENTITY = 1;

    /**
     * Perform multiplication with the specified operands.
     */
    public int operate (int left, int right) {
        return left * right;
    }

    /**
     * The identity for multiplication.  For any int i.
     *    this.operate(this.identity(),i) ==
     *    this.operate(i,this.identity()) == i
     */
    public int identity () {
        return IDENTITY;
    }
}
