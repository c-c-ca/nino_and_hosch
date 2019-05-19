package containers;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class RecursiveListTest {

    private static final int LIST_SIZE = 10;

    // Test fixture:

    private RecursiveList<Integer> list;

    @Before
    public void setUp () {
        list = new RecursiveList<Integer>();
    }

    /**
     * Test the equals method.
     */
    @Test
    public void initialState () {
        assertTrue(list.isEmpty());
        assertEquals(0,list.size());
    }

    @Test
    public void testAddAndRemove () {
        for (int i = 0; i < LIST_SIZE; i = i+1) {
            list.add(i);
        }
        assertEquals(LIST_SIZE,list.size());
        for (int i = 0; i < LIST_SIZE; i = i+1) {
            assertEquals(i,list.get(i).intValue());
            assertEquals(i,list.indexOf(Integer.valueOf(i)));
        }
        list.add(0,15);
        assertEquals(15,list.get(0).intValue());
        list.add(6,32);
        assertEquals(32,list.get(6).intValue());
        assertEquals(LIST_SIZE+2,list.size());
        list.add(list.size(),77);
        assertEquals(77,list.get(list.size()-1).intValue());
        list.remove(0);
        assertEquals(0,list.get(0).intValue());
        assertEquals(LIST_SIZE+2,list.size());
        list.remove(5);
        list.remove(list.size()-1);
        assertEquals(LIST_SIZE,list.size());
        for (int i = 0; i < LIST_SIZE; i = i+1) {
            assertEquals(i,list.get(i).intValue());
            assertEquals(i,list.indexOf(Integer.valueOf(i)));
        }
    }

}
