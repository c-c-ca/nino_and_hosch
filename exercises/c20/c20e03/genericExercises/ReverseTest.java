package genericExercises;

import nhUtilities.containers.*;

import org.junit.*;
import static org.junit.Assert.*;

public class ReverseTest {

    // Test fixture:

    private List<String> stringList;
    private List<Integer> integerList;

    // Source data:

    String[] strings = new String[]{"a","b","c"};
    Integer[] integers = new Integer[]{0, 1, 2};

    @Before
    public void setUp () {
        stringList = new DefaultList<String>();
        integerList = new DefaultList<Integer>();
        for (int i = 0; i < strings.length; i = i+1) {
            stringList.add(strings[i]);
            integerList.add(integers[i]);
        }
    }

    @Test
    public void testReverse () {
        Exercise.reverse(stringList);
        assertEquals(3,stringList.size());
        assertEquals("c",stringList.get(0));
        assertEquals("b",stringList.get(1));
        assertEquals("a",stringList.get(2));
        Exercise.reverse(integerList);
        assertEquals(3,integerList.size());
        assertEquals(2,integerList.get(0).intValue());
        assertEquals(1,integerList.get(1).intValue());
        assertEquals(0,integerList.get(2).intValue());
    }
}
