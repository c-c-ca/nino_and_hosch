package classSection;

/**
 * Models a student in a class section.
 */
public class Student {

    // Named constants:

    /**
     * The maximum score a student can receive.
     */
    public final static int MAX_SCORE = 100;


    // Private components:

    private String name;    // name
    private int grade;      // current grade

    // Constructors:

    /**
     * Create a new Student initialized with the specified
     * name and grade.  grade must be a non-negative integer.
     */
    public Student (String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Queries:

    /**
     * The adjusted grade for this Student.  highGrade must
     * be a non-negative integer.
     */
    public int adjustedGrade (int highGrade) {
        int maxAdjustment = MAX_SCORE - highGrade;
        return grade + grade * maxAdjustment / highGrade;
    }
}
