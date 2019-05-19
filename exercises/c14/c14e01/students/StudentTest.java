package students;

import org.junit.*;
import static org.junit.Assert.*;

public class StudentTest {

    // Test fixture:

    private Student s1;
    private Student s2;
    private Student s3;
    private AlphabeticalOrder order;

    @Before
    public void setUp () {
        s1 = new Student("Adams","John");
        s2 = new Student("Jefferson","Thomas");
        s3 = new Student("Adams","Samuel");
        order = new AlphabeticalOrder();
    }

    @Test
    public void testCompare () {
        assertTrue(order.compare(s1,s2)<0);
        assertTrue(order.compare(s2,s1)>=0);
        assertTrue(order.compare(s1,s3)<0);
    }
}
