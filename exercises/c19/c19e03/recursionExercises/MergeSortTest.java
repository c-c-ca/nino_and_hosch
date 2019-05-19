package recursionExercises;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Comparator;
import nhUtilities.containers.*;

public class MergeSortTest {

    private static int LIST_SIZE = 1000;

    // Test fixture:

    private static List<Integer> list;

    @Before
    public void setUp () {
        list = new DefaultList<Integer>();
        for (int i = 0; i < LIST_SIZE; i = i+1)
            list.add(
                Integer.valueOf((int) (Math.random()*1000)));
    }

    @Test
    public void testMergeSort () {
        MergeSort.sort(list,
            new Comparator<Integer>() {
                public int compare (Integer i, Integer j) {
                    return i.intValue() - j.intValue();
                }
            });
        for (int i = 1; i < LIST_SIZE; i = i+1)
            assertTrue(list.get(i).intValue() >=
                       list.get(i-1).intValue());
    }
}
