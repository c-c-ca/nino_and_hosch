package operations;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test classes Addition and Multiplication that implement
 * the OperatorWithIdentity interface.
 */
public class OperatorWithIdentityTest {

    // Test fixture:

    private Addition add;
    private Multiplication mult;

    @Before
    public void setUp () {
        add = new Addition();
        mult = new Multiplication();
    }

    private void testIdentity (
                 OperatorWithIdentity op, int i) {
        assertEquals(
            op.operate(op.identity(),i),
            op.operate(i,op.identity()));
        assertEquals(i,op.operate(i,op.identity()));
        assertEquals(op.operate(i,op.identity()),i);
    }

    /**
     * Test the class Addition.
     */
    @Test
    public void testAdditionIdentity () {
        testIdentity(add,0);
        testIdentity(add,1);
        testIdentity(add,10);
    }

    /**
     * Test the class Addition.
     */
    @Test
    public void testMultiplicationIdentity () {
        testIdentity(mult,0);
        testIdentity(mult,1);
        testIdentity(mult,10);
    }
}
