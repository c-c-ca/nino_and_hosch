package maps;

import org.junit.*;
import static org.junit.Assert.*;

public class KeyValueTableTest {

    // Test fixture:

    private KeyValueTable<String, Student> grades;

    // Source data

    String[] names =
        new String[]{
            "Charlotte", "Joseph", "Samantha", "Paul", "Sophia",
            "Felicia", "Frank", "Susan", "Blanche", "Gerald"};
    Integer[] scores =
        new Integer[]{84, 81, 93, 81, 92, 73, 78, 82, 64, 97};

    @Before
    public void setUp () {
        grades = new KeyValueTable<String, Student>();
        for (int i = 0; i < names.length; i = i+1)
            grades.add(new Student(names[i],scores[i]));
    }

    @Test
    public void testLookUp () {
        assertEquals(84,grades.lookUp("Charlotte").score().intValue());
        assertEquals(81,grades.lookUp("Paul").score().intValue());
        assertEquals(97,grades.lookUp("Gerald").score().intValue());
        assertEquals(null,grades.lookUp("Jeremy"));
    }
}
