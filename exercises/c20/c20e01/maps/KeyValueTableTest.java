package maps;

import org.junit.*;
import static org.junit.Assert.*;

public class KeyValueTableTest {

    // Test fixture

    private KeyValueTable<String, Integer> grades;

    // Source data

    String[] names =
        new String[]{
            "Charlotte", "Joseph", "Samantha", "Paul", "Sophia",
            "Felicia", "Frank", "Susan", "Blanche", "Gerald"};
    Integer[] scores =
        new Integer[]{84, 81, 93, 81, 92, 73, 78, 82, 64, 97};

    @Before
    public void setUp () {
        grades = new KeyValueTable<String, Integer>();
        for (int i = 0; i < names.length; i = i+1)
            grades.add(names[i],scores[i]);
    }

    @Test
    public void testLookUp () {
        assertEquals(84,grades.lookUp("Charlotte").intValue());
        assertEquals(81,grades.lookUp("Paul").intValue());
        assertEquals(97,grades.lookUp("Gerald").intValue());
        // test that the list can grow
        grades.add("Julia",74);
        assertEquals(74,grades.lookUp("Julia").intValue());
        // test for a key not in the table
        assertEquals(null,grades.lookUp("Jeremy"));
    }
}
