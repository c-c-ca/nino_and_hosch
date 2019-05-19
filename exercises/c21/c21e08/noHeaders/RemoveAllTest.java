package noHeaders;

import org.junit.*;
import static org.junit.Assert.*;

public class RemoveAllTest {

    // Test fixture:

    private LinkedList<String> list;

    // Source data:

    private String[] s = new String[]{"d", "a", "b", "c", "d", "b"};

    @Before
    public void setUp () {
        list = new LinkedList<String>();
        for (int i = 0; i < s.length; i = i+1)
            list.add(s[i]);
    }

    @Test
    public void testRemoveAll () {
        assertEquals("[d, a, b, c, d, b]",list.toString());
        list.removeAll("g");
        assertEquals("[d, a, b, c, d, b]",list.toString());
        list.removeAll("b");
        assertEquals("[d, a, c, d]",list.toString());
        list.removeAll("c");
        assertEquals("[d, a, d]",list.toString());
        list.removeAll("a");
        assertEquals("[d, d]",list.toString());
        list.removeAll("d");
        assertEquals("[]",list.toString());
    }
}
