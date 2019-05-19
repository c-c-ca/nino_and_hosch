package iteratorExercises;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Comparator;
import nhUtilities.containers2.List;
import nhUtilities.containers2.DefaultList;
import static iteratorExercises.Exercise.merge;

public class MergeTest {

    private static int LIST_SIZE = 10;

    // Test fixture:

    private static List<Integer> l1;
    private static List<Integer> l2;
    private static List<Integer> mergedList;
    private static Comparator<Integer> order =
        new Comparator<Integer>() {
                    public int compare (Integer i, Integer j) {
                        return i.intValue() - j.intValue();
            }
        };

    private List<Integer> initializeList () {
        List<Integer> list = new DefaultList<Integer>();
        for (int i = 0; i < LIST_SIZE; i = i+1)
            list.add(Integer.valueOf((int) (Math.random()*100)));
        SelectionSort.sort(list,order);
        return list;
    }

    @Before
    public void setUp () {
        l1 = initializeList();
        l2 = initializeList();
        mergedList = merge(l1,l2,order);
    }

    @Test
    public void testMerge () {
        assertEquals(mergedList.size(),2*LIST_SIZE);
        for (int i = 1; i < LIST_SIZE; i = i+1)
            assertTrue(mergedList.get(i).intValue() >=
                       mergedList.get(i-1).intValue());
    }
}
