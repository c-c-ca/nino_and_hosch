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

    private String name;      // this student's name
    private int score;        // this student's test score

    // Constructors:

    /**
     * Create a new Student initialized with the specified
     * name and score.
     * @require    0 <= score && score <= 100
     */
    public Student (String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Queries:

    /**
     * The letter grade for this student.
     * @ensure     result == 'A' || result == 'B' ||
     *             result == 'C' || result == 'D' ||
     *             result == 'F'
     */
    public char letterGrade () {
        char letterGrade;
        if (score >= 93)
            letterGrade = 'A';
        else if (score >= 85)
            letterGrade = 'B';
        else if (score >= 77)
            letterGrade = 'C';
        else if (score >= 70)
            letterGrade = 'D';
        else
            letterGrade = 'F';
        return letterGrade;
    }

    /**
     * The adjusted grade for this Student.
     * @require    0 <= highGrade && highGrade <= 100
     */
    public int adjustedGrade (int highGrade) {
        int maxAdjustment = MAX_SCORE - highGrade;
        return score + score * maxAdjustment / highGrade;
    }

    /**
     * This student passed the test.
     * The minimum passing score is 70.
     */
    public Boolean passed () {
        return score >= MIN_SCORE;
    }

}
