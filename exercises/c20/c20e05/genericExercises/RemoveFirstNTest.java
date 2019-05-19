package genericExercises;

import nhUtilities.containers.*;

import org.junit.*;
import static org.junit.Assert.*;

import static genericExercises.Exercise.removeFirstN;

public class RemoveFirstNTest {

    // Test fixture:

    private List<String> list;

    // Source data:

    private String[] strings = new String[]{
            "a","b","c","d","e","f","g"};

    @Before
    public void setUp () {
        list = new DefaultList<String>();
        for (int i = 0; i < strings.length; i = i+1) {
            list.add(strings[i]);
        }
    }

    @Test
    public void testRemoveFirstN () {
        assertEquals(list.toString(),
            removeFirstN(0,list).toString());
        assertEquals("[e, f, g]",
            removeFirstN(4,list).toString());
        assertEquals("[g]",
            removeFirstN(list.size()-1,list).toString());
        assertEquals("[]",
            removeFirstN(list.size(),list).toString());
        assertEquals("[]",
            removeFirstN(list.size()+1,list).toString());
    }
}
