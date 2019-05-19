package genericExercises;

import nhUtilities.containers.*;

import org.junit.*;
import static org.junit.Assert.*;

import static genericExercises.Exercise.disjoint;

public class DisjointTest {

    // Test fixture:

    private List<Integer> integerList;
    private List<Number> numberList;
    private List<Integer> disjointedIntegerList;
    private List<Integer> nonDisjointedIntegerList;
    private List<String> stringList;

    // Source data:

    int[] integers = new int[]{0, 1, 2};
    int[] disjointedIntegers = new int[]{3, 4, 5};
    int[] nonDisjointedIntegers = new int[]{4, 3, 2};
    String[] strings = new String[]{"a","b","c"};

    @Before
    public void setUp () {
        integerList = new DefaultList<Integer>();
        numberList = new DefaultList<Number>();
        disjointedIntegerList = new DefaultList<Integer>();
        nonDisjointedIntegerList = new DefaultList<Integer>();
        stringList = new DefaultList<String>();
        for (int i = 0; i < integers.length; i = i+1) {
            integerList.add(Integer.valueOf(integers[i]));
            numberList.add(Integer.valueOf(integers[i]));
            disjointedIntegerList.add(
                Integer.valueOf(disjointedIntegers[i]));
            nonDisjointedIntegerList.add(
                Integer.valueOf(nonDisjointedIntegers[i]));
            stringList.add(strings[i]);
        }
    }

    @Test
    public void testDisjoint () {
        assertFalse(disjoint(integerList,numberList));
        assertTrue(disjoint(integerList,stringList));
        assertTrue(disjoint(integerList,disjointedIntegerList));
        assertFalse(disjoint(integerList,nonDisjointedIntegerList));
    }
}
