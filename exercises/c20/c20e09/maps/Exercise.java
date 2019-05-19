package maps;

import nhUtilities.containers.*;
import java.util.*;

import static maps.KeyValueTableUtilities.tableSort;

public class Exercise {

    // Source data

    private static String[] names =
        new String[]{
            "Charlotte", "Joseph", "Samantha", "Paul", "Sophia",
            "Felicia", "Frank", "Susan", "Blanche", "Gerald"};

    private static Integer[] scores =
        new Integer[]{84, 81, 93, 81, 92, 73, 78, 82, 64, 97};

    // Private components:

    private static KeyValueTable<String, Student> grades;

    private static void displayTable () {
        for (int i = 0; i < grades.size(); i = i+1) {
            Student s = grades.get(i);
            System.out.println(s.getKey() + ": " + s.score());
        }
        System.out.println();
    }

    private static void sortTable () {
        tableSort(grades, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    public static void main (String[] argv) {
        grades = new KeyValueTable<String, Student>();
        for (int i = 0; i < names.length; i = i+1) {
            grades.add(new Student(names[i],scores[i]));
        }
        System.out.println("Before sort:");
        displayTable();
        sortTable();
        System.out.println("After sort:");
        displayTable();
    }
}
