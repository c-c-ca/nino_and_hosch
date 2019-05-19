package iteratorExercises;

import org.junit.*;
import static org.junit.Assert.*;

import nhUtilities.containers2.*;
import static iteratorExercises.Exercise.reverse;

public class ReverseTest {

    // TestFixture:

    private DoublyLinkedList<String> list;

    private void fill (char lastChar) {
        for (char c = 'a'; c <= lastChar; ++c)
            list.add(String.valueOf(c));
    }

    @Before
    public void setUp () {
        list = new DoublyLinkedList<String>();
    }

    @Test
    public void testEmptyList () {
        reverse(list);
        assertEquals("[]",list.toString());
    }

    @Test
    public void testSingleElementList () {
        fill('a');
        assertEquals("[a]",list.toString());
    }

    @Test
    public void testEvenSizeList () {
        fill('f');
        assertEquals("[a, b, c, d, e, f]",list.toString());
    }

    @Test
    public void testOddSizeList () {
        fill('g');
        assertEquals("[a, b, c, d, e, f, g]",list.toString());
    }
}
