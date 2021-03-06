package genericExercises;

import nhUtilities.containers.List;
import nhUtilities.containers.DefaultList;
import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

import static genericExercises.Exercise.min;

public class MinTest {

    private List<Integer> list;
    private Comparator<Number> order;

    // Source data:

    private Integer[] arr = new Integer[]{9,13,5,2,87,45,3};

    @Before
    public void setUp () {
        list = new DefaultList<Integer>();
        for (int i = 0; i < arr.length; i = i+1)
            list.add(arr[i]);
        order = new Comparator<Number>() {
            public int compare (Number n1, Number n2) {
                return n1.intValue()-n2.intValue();
            }
        };
    }

    @Test
    public void testMin () {
        assertEquals(2,min(list,order).intValue());
    }
}
