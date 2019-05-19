package classSection;

/**
 * Models a student in a class section.
 */
public class Student {

    // Private components:

    private String name;         // name
    private int finalGrade;      // final grade

    // Constructors:

    /**
     * Create a new Student initialized with the specified
     * name and finalGrade.
     * @ensure     finalGrade >= 0
     */
    public Student (String name, int finalGrade) {
        this.name = name;
        this.finalGrade = finalGrade;
    }

    // Queries:

    /**
     * This Student's name.
     */
    public String name () {
        return name;
    }

    /**
     * This Student's final grade.
     */
    public int finalGrade () {
        return finalGrade;
    }
}
