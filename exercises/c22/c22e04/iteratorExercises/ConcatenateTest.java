package iteratorExercises;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Comparator;
import nhUtilities.containers2.List;
import nhUtilities.containers2.DefaultList;
import static iteratorExercises.Exercise.concatenate;

public class ConcatenateTest {

    private static int LIST_1_SIZE = 5;
    private static int LIST_2_SIZE = 7;

    // Test fixture:

    private static List<Integer> l1;
    private static List<Integer> l2;
    private static List<Integer> concatenatedList;

    private List<Integer> initializeList (int size) {
        List<Integer> list = new DefaultList<Integer>();
        for (int i = 0; i < size; i = i+1)
            list.add(Integer.valueOf((int) (Math.random()*100)));
        return list;
    }

    @Before
    public void setUp () {
        l1 = initializeList(LIST_1_SIZE);
        l2 = initializeList(LIST_2_SIZE);
        concatenatedList = concatenate(l1,l2);
    }

    @Test
    public void testMerge () {
        assertEquals(concatenatedList.size(),
                     LIST_1_SIZE+LIST_2_SIZE);
        for (int i = 1; i < LIST_1_SIZE+LIST_2_SIZE; i = i+1)
            if (i < LIST_1_SIZE)
                assertTrue(concatenatedList.get(i).intValue() ==
                           l1.get(i).intValue());
            else
                assertTrue(concatenatedList.get(i).intValue() ==
                           l2.get(i-LIST_1_SIZE).intValue());
    }
}
