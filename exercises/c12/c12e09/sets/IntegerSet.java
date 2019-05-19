package sets;

import nhUtilities.containers.*;

/**
 * A finite set of integers.
 */
public class IntegerSet {

    // Private components:

    private List<Integer> elements;

    // Constructors:

    /**
     * Create a new IntegerSet containing the elements
     * of the specified List.
     */
    public IntegerSet (List<Integer> elements) {
        this.elements = elements.copy();
        removeDuplicates();
    }

    /**
     * Remove duplicates from the component List.
     */
    private void removeDuplicates () {
        for (int i = 0; i < elements.size()-1; i = i + 1) {
            Integer item = elements.get(i);
            for (int j = i+1; j < elements.size();)
                if (item.equals(elements.get(j)))
                    elements.remove(j);
                else
                    j = j+1;
        }
    }

    // Queries:

    /**
     * The number of elements in this IntegerSet.
     */
    public int size () {
        return elements.size();
    }

    /**
     * This IntegerSet has no members.
     */
    public boolean isEmpty () {
        return elements.isEmpty();
    }

    /**
     * This IntegerSet contains the specified Integer.
     */
    public boolean contains (Integer item) {
        return elements.contains(item);
    }

    /**
     * This IntegerSet is a subset of the specified IntegerSet.
     */
    public boolean isSubSetOf (IntegerSet other) {
        for (Integer item : elements)
            if (!other.contains(item))
                return false;
        return true;
    }

    // Commands:

    /**
     * Add the specified Integer to this IntegerSet.
     */
    public void add (Integer item) {
        if (!contains(item))
            elements.add(item);
    }

    /**
     * Remove the specified Integer from this IntegerSet.
     */
    public void remove (Integer item) {
        elements.remove(item);
    }

    /**
     * String representation of this Set.
     */
    public String toString () {
        String s = "{";
        if (elements.size() > 1)
            s = s + elements.get(0).intValue();
        for (int i = 1; i < elements.size(); i = i + 1)
            s = s + ", " + elements.get(i).intValue();
        s = s + "}";
        return s;
    }
}
