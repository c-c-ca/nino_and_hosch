package maps;

public class Student implements Keyed<String> {

    // Private components:

    private String name;
    private Integer score;

    // Constructors:

    public Student (String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    // Queries:

    public String getKey () {
        return name;
    }

    public Integer score () {
        return score;
    }
}
