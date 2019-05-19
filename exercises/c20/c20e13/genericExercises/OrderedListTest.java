package genericExercises;

import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

import nhUtilities.containers.List;
import nhUtilities.containers.DefaultList;

public class OrderedListTest {

    private List<Integer> integerList;
    private List<Student> studentList;
    private Comparator<Number> numberOrder;
    private Comparator<Student> gradeOrder;

    // Source data:

    private Integer[] integers = new Integer[]{6,3,5,7,1};

    private static String[] names =
        new String[]{
            "Charlotte", "Joseph", "Samantha"};

    private static Integer[] scores =
        new Integer[]{84, 81, 93};

    private void initializeIntegerList () {
        integerList = new DefaultList<Integer>();
        for (int i = 0; i < integers.length; i = i+1)
            integerList.add(integers[i]);
        numberOrder = new Comparator<Number>() {
            public int compare (Number n1, Number n2) {
                return n1.intValue()-n2.intValue();
            }
        };
    }

    private void intializeStudentList () {
        studentList = new DefaultList<Student>();
        for (int i = 0; i < names.length; i = i+1)
            studentList.add(new Student(names[i],scores[i]));
        gradeOrder = new Comparator<Student>() {
            public int compare (Student s1, Student s2) {
                return s2.score() - s1.score();
            }
        };
    }

    @Before
    public void setUp () {
        initializeIntegerList();
        intializeStudentList();
    }

    @Test
    public void testOrderedIntegers () {
        OrderedList<Number> orderedIntegers =
            new OrderedList<Number>(integerList,numberOrder);
        assertEquals("[1, 3, 5, 6, 7]",orderedIntegers.toString());
        orderedIntegers = new OrderedList<Number>(integerList);
        assertEquals("[1, 3, 5, 6, 7]",orderedIntegers.toString());
    }

    @Test
    public void testOrderedStudents () {
        OrderedList<Student> orderedStudents =
            new OrderedList<Student>(studentList,gradeOrder);
        Student student = orderedStudents.get(0);
        assertEquals("Samantha",student.name());
        student = orderedStudents.get(1);
        assertEquals("Charlotte",student.name());
        student = orderedStudents.get(2);
        assertEquals("Joseph",student.name());
        // throws a class cast exception because class Student
        // does not implement Comparable interface
        // orderedStudents = new OrderedList<Student>(studentList);
    }
}
