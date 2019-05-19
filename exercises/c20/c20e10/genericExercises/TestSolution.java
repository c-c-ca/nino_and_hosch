package genericExercises;

import nhUtilities.containers.*;

import org.junit.*;
import static org.junit.Assert.*;

import static genericExercises.Exercise.*;

public class TestSolution {

    // Test fixture:

    private String[] arr;

    @Before
    public void setUp () {
        arr = new String[]{"a","b","c"};
    }

    @Test
    public void testArrayToList () {
        List<String> list = new DefaultList<String>();
        arrayToList(arr,list);
        assertEquals("a",list.get(0));
        assertEquals("b",list.get(1));
        assertEquals("c",list.get(2));
        String[] otherArray = new String[list.size()];
        listToArray(list,otherArray);
        assertEquals("a",otherArray[0]);
        assertEquals("b",otherArray[1]);
        assertEquals("c",otherArray[2]);
    }
}
