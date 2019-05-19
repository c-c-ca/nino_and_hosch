package containers;

import nhUtilities.containers2.*;

/**
 * An extended interface of the interface Iterator as a solution to
 * Exercise 7 of Chapter 8.  Note that all that is required of the
 * exercise is that we "extend the interface" by "defining operations
 * for removing, adding, and setting..." Given that (1) the word "implement"
 * or "implementation" was never used in the problem statement and that
 * (2) the implementation of such methods would vary from one List to
 * another and, therefore, require the implementation of the aforementioned
 * methods across several subtypes of List, the specification provided
 * below should be satisfactory.
 */
public interface Iterator2<Element> extends Iterator<Element> {

    /**
     * Remove the element referenced by this Iterator from the list.
     * @require    !this.done()
     * @ensure     this.get().equals(this.old.advance(); this.old.get())
     */
    public void remove ();

    /**
     * Insert the specified Element at the position referenced by this
     * Iterator into the list.  The Iterator will reference the newly
     * added Element.
     * @require    !this.done()
     *             element != null
     * @ensure     this.get.equals(element)
     *             this.old.get().equals(this.advance(); this.get())
     */
    public void add (Element element);

    /**
     * Replace the element referenced by this Iterator with the specified
     * Element.
     * @require    !this.done()
     *             element != null
     * @ensure     this.get().equals(element)
     */
    public void set (Element element);
