package operations;

import org.junit.*;
import static org.junit.Assert.*;
import nhUtilities.containers.*;

/**
 * Test classes Addition and Multiplication that implement
 * the OperatorWithIdentity interface.
 */
public class OperatorWithIdentityTest {

    // Test fixture:

    private Addition add;
    private Multiplication mult;
    private OperatorUtilities ou;

    @Before
    public void setUp () {
        add = new Addition();
        mult = new Multiplication();
        ou = new OperatorUtilities();
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


    /**
     * Make a list in the range 1 through size, inclusive.
     */
    private List<Integer> makeList (int size) {
        List<Integer> list = new DefaultList<Integer>();
        for (int i = 1; i < size+1; i = i+1)
            list.add(i);
        return list;
    }

    /**
     * Test the foldl method defined in OperatorUtilities.
     */
    @Test
    public void testFoldl () {
        // test an empty list
        List<Integer> list = makeList(0);
        assertEquals(0,ou.foldl(add,list));
        assertEquals(1,ou.foldl(mult,list));
        // test with 1 item
        list = makeList(1);
        assertEquals(1,ou.foldl(add,list));
        assertEquals(1,ou.foldl(mult,list));
        // test a typical list
        list = makeList(4);
        assertEquals(10,ou.foldl(add,list));
        assertEquals(24,ou.foldl(mult,list));
    }
}
