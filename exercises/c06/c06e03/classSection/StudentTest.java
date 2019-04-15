package classSection;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A simple test class for the class Student.
 */
public class StudentTest {

    // Students with the specified grades
    private Student minA;  // minimum score for an A
    private Student maxB;  // maximum score for a B
    private Student minB;  // minimum score for a B
    private Student maxC;  // maximum score for a C
    private Student minC;  // minimum score for a C
    private Student maxD;  // maximum score for a D
    private Student minD;  // minimum score for a D
    private Student maxF;  // maximum score for an F

    @Before
    public void setUp () {
        minA = new Student("", 93);
        maxB = new Student("", 92);
        minB = new Student("", 85);
        maxC = new Student("", 84);
        minC = new Student("", 77);
        maxD = new Student("", 76);
        minD = new Student("", 70);
        maxF = new Student("", 69);
    }

    /**
     * Test the letterGrade method.
     */
     @Test
     public void testLetterGrade () {
         assertEquals("min A", 'A', minA.letterGrade());
         assertEquals("max B", 'B', maxB.letterGrade());
         assertEquals("min B", 'B', minB.letterGrade());
         assertEquals("max C", 'C', maxC.letterGrade());
         assertEquals("min C", 'C', minC.letterGrade());
         assertEquals("max D", 'D', maxD.letterGrade());
         assertEquals("min D", 'D', minD.letterGrade());
         assertEquals("max F", 'F', maxF.letterGrade());
     }
}
