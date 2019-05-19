package sets;

import nhUtilities.containers.*;

/**
 * Models a finite set: an unstructured container that
 * does not permit duplicate occurrences of an item.
 */
public class Set<Element> {

    // Private components:

    private List<Element> elements;

    // Constructors:

    /**
     * Create a new Set containing the elements of the
     * specified List.
     */
    public Set (List<Element> elements) {
        this.elements = elements.copy();
        removeDuplicates();
    }

    /**
     * Remove duplicates from the component List.
     */
    private void removeDuplicates () {
        for (int i = 0; i < elements.size()-1; i = i + 1) {
            Element item = elements.get(i);
            for (int j = i+1; j < elements.size();)
                if (item.equals(elements.get(j)))
                    elements.remove(j);
                else
                    j = j+1;
        }
    }

    // Queries:

    /**
     * The number of elements in this Set.
     */
    public int size () {
        return elements.size();
    }

    /**
     * This Set has no members.
     */
    public boolean isEmpty () {
        return elements.isEmpty();
    }

    /**
     * This Set contains the specified item.
     */
    public boolean contains (Element item) {
        return elements.contains(item);
    }

    /**
     * This Set is a subset of the specified Set.
     */
    public boolean isSubSetOf (Set<Element> other) {
        for (Element item : elements)
            if (!other.contains(item))
                return false;
        return true;
    }

    // Commands:

    /**
     * Add the specified item to this Set.
     */
    public void add (Element item) {
        if (!contains(item))
            elements.add(item);
    }

    /**
     * Remove the specified item from this Set.
     */
    public void remove (Element item) {
        elements.remove(item);
    }

    /**
     * String representation of this Set.
     */
    public String toString () {
        String s = "{";
        if (elements.size() > 1)
            s = s + elements.get(0);
        for (int i = 1; i < elements.size(); i = i + 1)
            s = s + ", " + elements.get(i);
        s = s + "}";
        return s;
    }
}
