package genericExercises;

import nhUtilities.containers.*;

import org.junit.*;
import static org.junit.Assert.*;

import static genericExercises.Exercise.nCopies;

public class NCopiesTest {

    // Test fixture:

    private String e;

    @Before
    public void setUp () {
        e = "a";
    }

    @Test
    public void testCopyFirstN () {
        assertEquals("[]",nCopies(0,e).toString());
        assertEquals("[a]",nCopies(1,e).toString());
        assertEquals("[a, a, a]",nCopies(3,e).toString());
    }
}
