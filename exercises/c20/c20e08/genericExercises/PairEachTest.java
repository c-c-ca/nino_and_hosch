package genericExercises;

import nhUtilities.containers.*;

import org.junit.*;
import static org.junit.Assert.*;

import static genericExercises.Exercise.pairEach;

public class PairEachTest {

    // Test fixture:

    private List<Integer> integerList;
    private List<String> stringList;
    private List<Pair2<Integer,String>> listOfPairs;

    // Source data;

    private Integer[] integers =
        new Integer[]{0, 1, 2};
    private String[] strings =
        new String[]{"a", "b", "c", "d"};


    @Before
    public void setUp () {
        integerList = new DefaultList<Integer>();
        stringList = new DefaultList<String>();
        for (int i = 0; i < integers.length; i = i+1) {
            integerList.add(integers[i]);
            stringList.add(strings[i]);
        }
        listOfPairs = pairEach(integerList,stringList);

    }

    @Test
    public void testPairEach () {
        assertEquals(3,listOfPairs.size());
        Pair2<Integer, String> p;
        p = listOfPairs.get(0);
        assertEquals(0,p.first().intValue());
        assertEquals("a",p.second());
        p = listOfPairs.get(listOfPairs.size()-1);
        assertEquals(2,p.first().intValue());
        assertEquals("c",p.second());
    }
}
