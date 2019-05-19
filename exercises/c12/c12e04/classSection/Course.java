package classSection;

import nhUtilities.containers.*;

public class Course {

    // Named constants:

    /**
     * The minimum passing score a student can receive on a test.
     */
    public final static int MINIMUM_PASS = 70;

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

    // Queries:

    /**
     * Returns a List<Student> of the Students
     * with a finalGrade less than MINIMUM_PASS.
     */
    public List<Student> failingStudents () {
        List<Student> failingStudents =
            new DefaultList<Student>();
        for (Student s : enrollees)
            if (s.finalGrade() < MINIMUM_PASS)
                failingStudents.add(s);
        return failingStudents;
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
