package noHeaders;

import org.junit.*;
import static org.junit.Assert.*;

public class RemoveTest {

    // Test fixture:

    private LinkedList<String> list;

    // Source data:

    private String[] s = new String[]{"a", "b", "c", "d", "b"};

    @Before
    public void setUp () {
        list = new LinkedList<String>();
        for (int i = 0; i < s.length; i = i+1)
            list.add(s[i]);
    }

    @Test
    public void testRemove () {
        assertEquals("[a, b, c, d, b]",list.toString());
        list.remove("g");
        assertEquals("[a, b, c, d, b]",list.toString());
        list.remove("b");
        assertEquals("[a, c, d, b]",list.toString());
        list.remove("c");
        assertEquals("[a, d, b]",list.toString());
        list.remove("a");
        assertEquals("[d, b]",list.toString());
        list.remove("b");
        assertEquals("[d]",list.toString());
        list.remove("d");
        assertEquals("[]",list.toString());
    }
}
