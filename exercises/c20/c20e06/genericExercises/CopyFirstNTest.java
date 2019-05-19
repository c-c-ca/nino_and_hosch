package genericExercises;

import nhUtilities.containers.*;

import org.junit.*;
import static org.junit.Assert.*;

import static genericExercises.Exercise.copyFirstN;

public class CopyFirstNTest {

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
    public void testCopyFirstN () {
        assertEquals("[]",copyFirstN(0,list).toString());
        assertEquals("[a, b, c]",copyFirstN(3,list).toString());
        assertEquals("[a, b, c, d, e, f, g]",
                     copyFirstN(list.size(),list).toString());
        assertEquals("[a, b, c, d, e, f, g]",
                     copyFirstN(list.size()+1,list).toString());
    }
}
