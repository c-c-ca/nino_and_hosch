/**
 * Models a person with name and mother.
 */
public class Person {

    private String myName;
    private Person myMother;

    /**
     * Create a new Person with the specified name and no mother.
     */
    public Person (String name) {
        myName = name;
        myMother = null;
    }

    /**
     * This Person's name.
     */
    public String name () {
        return myName;
    }

    /**
     * This Person's mother.
     */
    public Person mother () {
        return myMother;
    }

    /**
     * Set this Person's mother to the specified Person.
     */
    public void setMother (Person mom) {
        myMother = mom;
    }

    /**
     * Change this Person's name to the specifed value.
     */
    public void setName (String newName) {
        myName = newName;
    }
    
}
