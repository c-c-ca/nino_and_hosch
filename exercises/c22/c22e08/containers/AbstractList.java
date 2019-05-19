package containers;

import java.util.*;

/**
 * This class was designed as a solution to Exercise 8 of Chapter 22.
 * The purpose of the RobustIterator is to specify the behaviors
 * for all Iterators of a List when a single Iterator modifies
 * the list (i.e. adds or removes an element).
 *
 * Given the openness of the problem statement, the task appears
 * to be to specify and implement the behavior for an Iterator
 * that differs from its previous behavior to show that the behavior
 * for an Iterator is alterable, and thereby controllable,
 * knowable, and predictable.  This would resolve the problem of
 * undefined Iterators.  It would then seem reasonable to make some
 * small improvement on the current implementation for a given List.
 *
 * In this solution, the list chosen for improvement is the AbstractList
 * which uses an array-based implementation to support its functionality.
 *
 * To be more precise, the behavior for the Iterator of an AbstractList
 * is altered, such that the RobustIterator is 'committed' to an element,
 * rather than an index, unless its add, remove, or advance method is
 * invoked.
 *
 * That is, if a preceding element is removed or another element is added in
 * front of the element currently referenced by the RobustIterator, then the
 * RobustIterator will continue to reference the same element.
 *
 * A few small interesting points should be noted regarding the nuances
 * discovered in implementing this Iterator.  First, how should adding
 * elements such that all elements continue to refer to the same element
 * prior to the modification other than the iterator used for the insertion
 * be handled?  Another problem encountered, and probably the most pesky,
 * is what to do about Iterators when the element they refer to is no longer
 * in the list.  Since they are no longer valid, it is probably most
 * sensible to say so in the preconditions.  However, as an extra precaution,
 * the index referenced by these Iterators is -1 meaning that an exception
 * will be thrown if they are used to access an element on the list.
 */
public abstract class AbstractList<Element> extends Observable
    implements List<Element> {

  public Iterator<Element> iterator () {
    RobustIterator iterator = new RobustIterator();
    iterator.current = -1;
    this.addObserver(iterator);
    iterator.reset();
    return iterator;
  }

  public boolean isEmpty () {
    return this.size() == 0;
  }

  public Element get (Iterator<Element> iterator) {
    assert iterator.traverses(this) && !iterator.done();
    return iterator.get();
  }

  public int indexOf (Element element) {
    Iterator<Element> i = this.iterator();
    int index = 0;
    while (!i.done() && !i.get().equals(element)) {
      i.advance();
      index = index + 1;
    }
    if (i.done())
      return -1;
    else
      return index;
  }

  public Iterator<Element> iteratorAt (Element element) {
    Iterator<Element> iterator = this.iterator();
    while (!iterator.done() && !element.equals(iterator.get()))
      iterator.advance();
    return iterator;
  }

  public boolean contains (Element element) {
    return this.indexOf(element) != -1;
  }

  public void add (Element element) {
    this.add(this.size(),element);
  }

  public void add (Iterator<Element> iterator, Element element) {
    assert iterator.traverses(this);
    if (iterator.done()) {
      add(element);
    } else {
      RobustIterator i = (RobustIterator)iterator;
      add(i.current,element);
      i.current = i.current - 1;
    }
  }

  public void set (Iterator<Element> iterator, Element element) {
    assert iterator.traverses(this);
    RobustIterator i = (RobustIterator)iterator;
    set(i.current,element);
  }

  public void remove (Element element) {
    int index = indexOf(element);
    if (index != -1)
      this.remove(index);
  }

  public void remove (Iterator<Element> iterator) {
    assert iterator.traverses(this);
    RobustIterator i = (RobustIterator)iterator;
    int index = i.current;
    remove(i.current);
    i.current = index;
  }

  public String toString () {
    String s = "[";
    Iterator i = this.iterator();
    if (!i.done()) {
      s = s + i.get().toString();
      for (i.advance(); !i.done(); i.advance())
        s = s + ", " + i.get().toString();
    }
    s = s + "]";
    return s;
  }

  /**
   * An indexed-based iterator, suitable for traversing array-based lists.
   */
  private class RobustIterator extends AbstractIterator<Element>
    implements Observer {

    private int current;            // index into the List

    /**
     * Create a new iterator for this <code>AbstractList</code>.
     */
    public RobustIterator () {
      this.reset();
    }

    public void reset () {
      current = 0;
    }

    public void advance () {
      current = current + 1;
    }

    public boolean done () {
      return current >= AbstractList.this.size();
    }

    public Element get () {
      return AbstractList.this.get(current);
    }

    public boolean equals (Object obj) {
      if (obj instanceof AbstractList<?>.RobustIterator) {
        RobustIterator other = (RobustIterator)obj;
        return this.current == other.current &&
          other.traverses(AbstractList.this);
      } else
        return false;
    }

    public boolean traverses (Object container) {
      return container == AbstractList.this;
    }

    public void setEqualTo (Iterator<Element> other) {
      this.current = ((RobustIterator)other).current;
    }

    public void update (Observable model, Object arg) {
        RIMessage msg = (RIMessage)arg;
        if (current >= msg.index())
            if (msg.addedElement())
                current = current + 1;
            else if (msg.index() == current &&
                     !msg.addedElement())
                current = -1;
            else
                current = current - 1;
    }
  }

  class RIMessage {

      int index;
      boolean addedElement;

      public RIMessage (int index, boolean addedElement) {
          this.index = index;
          this.addedElement = addedElement;
      }

      public int index () {
          return index;
      }

      public boolean addedElement () {
          return addedElement;
      }
  }
}
