package classSection;

/**
 * Models a student in a class section.
 */
public class Student {

    // Named constants:

    /**
     * The maximum grade a student can receive.
     */
    public final static int MAX_SCORE = 100;

    /**
     * The minimum passing score a student can receive on a test.
     */
    public final static int MIN_SCORE = 70;


    // Private components:

    private String name;    // name
    private int grade;      // current grade
    private int score;      // test score

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

    /**
     * This student passed the test.
     * The minimum passing score is 70.
     */
    public Boolean passed () {
        return score >= MIN_SCORE;
    }
}
