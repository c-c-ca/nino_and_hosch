package recursionExercises;

import nhUtilities.containers.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ReverseTest {

    // Test fixture:

    private List<Integer> oneItem;
    private List<Integer> rOneItem;
    private List<Integer> evenItems;
    private List<Integer> rEvenItems;
    private List<Integer> oddItems;
    private List<Integer> rOddItems;
    private List<Integer> typical;
    private List<Integer> rTypical;

    private static List<Integer> generateList (int size) {
        List<Integer> list = new DefaultList<Integer>();
        for (int i = 0; i < size; i = i+1)
            list.add(Integer.valueOf(i));
        return list;
    }

    private static List<Integer> generateReverseList (int size) {
        List<Integer> list = new DefaultList<Integer>();
        for (int i = size-1; i >= 0; i = i-1)
            list.add(Integer.valueOf(i));
        return list;
    }

    @Before
    public void setUp () {
        oneItem = generateList(1);
        rOneItem = generateReverseList(1);
        evenItems = generateList(2);
        rEvenItems = generateReverseList(2);
        oddItems = generateList(3);
        rOddItems = generateReverseList(3);
        typical = generateList(5);
        rTypical = generateReverseList(5);
    }

    @Test
    public void testReverse () {
        Exercise.reverse(oneItem);
        compare(oneItem,rOneItem);
        Exercise.reverse(evenItems);
        compare(evenItems,rEvenItems);
        Exercise.reverse(oddItems);
        compare(oddItems,rOddItems);
        Exercise.reverse(typical);
        compare(typical,rTypical);
    }

    private void compare (List<Integer> l1, List<Integer> l2) {
        assertEquals(l1.size(),l2.size());
        for (int i = 0; i < l1.size(); i = i+1)
            assertEquals(
                l1.get(i).intValue(),l2.get(i).intValue());
    }
}
