package operations;

/**
 * Models integer operation of addition.
 */
public class Addition implements OperatorWithIdentity {

    private static final int IDENTITY = 0;

    /**
     * Perform addition with the specified operands.
     */
    public int operate (int left, int right) {
        return left + right;
    }

    /**
     * The identity for addition.  For any int i.
     *    this.operate(this.identity(),i) ==
     *    this.operate(i,this.identity()) == i
     */
    public int identity () {
        return IDENTITY;
    }
}
