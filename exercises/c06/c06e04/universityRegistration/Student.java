package universityRegistration;

/**
 * Models a student in a university registration system.
 */
public class Student {

    // Private components:

    private String name;      // name
    private int creditHours;  // credit hours enrolled in

    // Constructors:

    /**
     * Create a new Student with the specified name.
     */
    public Student (String name, int creditHours) {
        this.name = name;
        this.creditHours = creditHours;
    }

    // Queries:

    /**
     * The fee amount for this Student.
     */
    public int fees () {
        int fees;
        if (creditHours <= 3)
            fees = 500;
        else if (creditHours <= 6)
            fees = 750;
        else if (creditHours <= 9)
            fees = 1000;
        else
            fees = 1250;
        return fees;
    }
}
