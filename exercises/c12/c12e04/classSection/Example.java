package classSection;

import nhUtilities.containers.*;

public class Example {

    public static void main (String[] argv) {
        Student s1 = new Student("John",82);
        Student s2 = new Student("Jacob",50);
        Student s3 = new Student("Bill",65);
        Student s4 = new Student("Mary",96);
        Course c = new Course();
        c.enroll(s1);
        c.enroll(s2);
        c.enroll(s3);
        c.enroll(s4);
        List<Student> failingStudents = c.failingStudents();
        for (Student s : failingStudents)
            System.out.println(s.name());
    }
}
