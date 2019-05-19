package universityRegistration;

import nhUtilities.containers.*;

public class Course {

    // Private components:

    private List<Student> enrollees;

    // Constructors:

    public Course () {
        this.enrollees = new DefaultList<Student>();
    }

    // Commands:

    /**
     * Enroll the specified Student in this Course.
     */
    public void enroll (Student student) {
        if (!enrollees.contains(student))
            enrollees.add(student);
    }

    /**
     * Drop the specified Student from this Course.
     */
    public void drop (Student student) {
        enrollees.remove(student);
    }

    /**
     * String representation of this Course.
     */
    public String toString () {
        String s = "";
        if (enrollees.size() > 0)
            s = enrollees.get(0).name();
        for (int i = 1; i < enrollees.size(); i = i + 1)
            s = s + ", " + enrollees.get(i).name();
        return s;
    }
}
