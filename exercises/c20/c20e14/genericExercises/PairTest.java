package genericExercises;

import org.junit.*;
import static org.junit.Assert.*;

public class PairTest {

    // Test fixture:

    private Pair<Integer> pair;
    private Pair<Integer> sameValues;
    private Pair<Integer> differentValues;
    private Pair<String> differentType;

    @Before
    public void setUp () {
        pair = new Pair<Integer>(1,2);
        sameValues = new Pair<Integer>(1,2);
        differentValues = new Pair<Integer>(1,3);
        differentType = new Pair<String>("a","b");
    }

    @Test
    public void testEquals () {
        assertFalse(pair.equals("a"));
        assertTrue(pair.equals(pair));
        assertTrue(pair.equals(sameValues));
        assertFalse(pair.equals(differentValues));
        assertFalse(pair.equals(differentType));
    }
}
