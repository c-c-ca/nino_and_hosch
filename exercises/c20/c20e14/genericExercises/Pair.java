package genericExercises;

public class Pair<Type> {

    private Type first;
    private Type second;

    public Pair (Type first, Type second) {
        this.first = first;
        this.second = second;
    }

    public Type first () {
        return first;
    }

    public Type second () {
        return second;
    }

    public void setFirst (Type value) {
        this.first = value;
    }

    public void setSecond (Type value) {
        this.second = second;
    }

    public boolean equals (Object other) {
        if (other instanceof Pair<?>) {
            Pair<?> p = (Pair<?>)other;
            return first.equals(p.first()) &&
                   second.equals(p.second());
        } else
            return false;
    }
}
