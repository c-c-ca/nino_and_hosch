package universityRegistration;

import nhUtilities.containers.*;

public class Example {
    public static void main (String[] argv) {
        Student john = new Student("John",0);
        Student jacob = new Student("Jacob",0);
        Student bill = new Student("Bill",0);
        Student mary = new Student("Mary",0);
        Course course = new Course();
        course.enroll(john);
        course.enroll(jacob);
        course.enroll(bill);
        course.enroll(mary);
        System.out.println(
            "After enrolling four students: " + course);
        course.drop(jacob);
        System.out.println(
            "After dropping Jacob: " + course);
    }
}
