package sorts;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Comparator;
import nhUtilities.containers2.*;

public class SortTest {

    private static int LIST_SIZE = 10;

    // Test fixture:

    private static List<Integer> list;
    private static Comparator<Integer> order;

    @Before
    public void setUp () {
        list = new DefaultList<Integer>();
        for (int i = 0; i < LIST_SIZE; i = i+1)
            list.add(
                Integer.valueOf((int) (Math.random()*100)));
        order = new Comparator<Integer>() {
                    public int compare (Integer i, Integer j) {
                        return i.intValue() - j.intValue();
            }
        };
    }

    @Test
    public void testSelectionSort () {
        SelectionSort.sort(list,order);
        for (int i = 1; i < LIST_SIZE; i = i+1)
            assertTrue(list.get(i).intValue() >=
                       list.get(i-1).intValue());
    }

    @Test
    public void testBubbleSort () {
        BubbleSort.sort(list,order);
        for (int i = 1; i < LIST_SIZE; i = i+1)
            assertTrue(list.get(i).intValue() >=
                       list.get(i-1).intValue());
    }
}
