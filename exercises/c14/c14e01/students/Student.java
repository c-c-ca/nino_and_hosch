package students;

/**
 * Minimum class definition to model a student.
 */
public class Student {

    // Private components:

    private String lastName;
    private String firstName;

    // Constructors:

    public Student (String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    // Queries:

    /**
     * This Student's last name.
     */
    public String lastName () {
        return lastName;
    }

    /**
     * This Student's first name.
     */
    public String firstName () {
        return firstName;
    }
}
