package arrayExercises;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class ModifiedArrayListTest {

    private static final int LIST_SIZE = 10;

    // Test fixture:

    private ModifiedArrayList<Integer> original;
    private ModifiedArrayList<Integer> copy;
    private ModifiedArrayList<Integer> diffLength;
    private ModifiedArrayList<Integer> diffElements;

    private void fill (ArrayList<Integer> list) {
        for (int i = 0; i < LIST_SIZE; i = i+1)
            list.add(i);
    }

    @Before
    public void setUp () {
        original = new ModifiedArrayList<Integer>();
        copy = new ModifiedArrayList<Integer>();
        diffLength = new ModifiedArrayList<Integer>();
        diffElements = new ModifiedArrayList<Integer>();

        fill(original);
        fill(copy);
        fill(diffLength);
        fill(diffElements);

        diffLength.add(Integer.valueOf(LIST_SIZE));
        diffElements.set(LIST_SIZE-1,Integer.valueOf(LIST_SIZE));
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals () {
        assertTrue(original.equals(copy));
        assertFalse(original.equals(diffLength));
        assertFalse(original.equals(diffElements));
    }

}
