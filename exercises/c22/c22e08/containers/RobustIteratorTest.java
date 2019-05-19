package containers;

import org.junit.*;
import static org.junit.Assert.*;

public class RobustIteratorTest {

    // Test fixture:

    private DefaultList<String> list;

    // Source data:

    private String[] elements = new String[]{"a","b","c","d","e"};

    @Before
    public void setUp () {
        list = new DefaultList<String>();
        for (String s : elements)
            list.add(s);
    }

    @Test
    public void testRobustIterator () {
        Iterator i1, i2, i3;

        i1 = list.iterator();
        i1.reset();
        assertEquals("a",i1.get());

        i2 = list.iterator();
        i3 = list.iterator();

        // move i2 up 2 positions
        i2.next();
        i2.next();
        assertEquals("c",i2.get());

        // move i3 up 4 positions
        i3.next();
        i3.next();
        i3.next();
        i3.next();
        assertEquals("e",i3.get());

        list.add(i2,"x");

        assertEquals("a",i1.get());
        assertEquals("x",i2.get());
        assertEquals("e",i3.get());

        list.remove(i2);
        assertEquals("a",i1.get());
        assertEquals("e",i3.get());

        list.add(2,"x");
        assertEquals("a",i1.get());
        assertEquals("e",i3.get());

        list.remove(2);
        assertEquals("a",i1.get());
        assertEquals("e",i3.get());

        list.add(0,"x");
        assertEquals("a",i1.get());
        assertEquals("e",i3.get());

        list.remove(0);
        assertEquals("a",i1.get());
        assertEquals("e",i3.get());

        list.remove(list.size()-1);
        assertEquals("a",i1.get());

        list.remove(i1);
        assertEquals("b",i1.get());
    }
}
