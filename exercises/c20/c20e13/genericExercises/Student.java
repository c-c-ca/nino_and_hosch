package genericExercises;

public class Student {

    // Private components:

    private String name;
    private Integer score;

    // Constructors:

    public Student (String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    // Queries:

    public String name () {
        return name;
    }

    public Integer score () {
        return score;
    }
}
