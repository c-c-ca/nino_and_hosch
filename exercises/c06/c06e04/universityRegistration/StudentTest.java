package universityRegistration;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple class to test the class Student.
 */
public class StudentTest {

    // students with the specified number of credit hours
    private Student hours0;   // min # of credit hours for a 500 dollar fee
    private Student hours3;   // max # of credit hours for a 500 dollar fee
    private Student hours4;   // min # of credit hours for a 750 dollar fee
    private Student hours6;   // max # of credit hours for a 750 dollar fee
    private Student hours7;   // max # of credit hours for a 1000 dollar fee
    private Student hours9;   // max # of credit hours for a 1000 dollar fee
    private Student hours10;  // min # of credit hours for a 1250 dollar fee

    @Before
    public void setUp () {
        hours0 = new Student("",0);
        hours3 = new Student("",3);
        hours4 = new Student("",4);
        hours6 = new Student("",6);
        hours7 = new Student("",7);
        hours9 = new Student("",9);
        hours10 = new Student("",10);
    }

    /**
     * Test the fee method.
     */
    @Test
    public void testFee () {
        assertEquals("min 500 fees", 500, hours0.fees());
        assertEquals("max 500 fees", 500, hours3.fees());
        assertEquals("min 750 fees", 750, hours4.fees());
        assertEquals("max 750 fees", 750, hours6.fees());
        assertEquals("min 1000 fees", 1000, hours7.fees());
        assertEquals("max 1000 fees", 1000, hours9.fees());
        assertEquals("min 1250 fees", 1250, hours10.fees());
    }
}
