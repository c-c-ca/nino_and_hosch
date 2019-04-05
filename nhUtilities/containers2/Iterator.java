package nhUtilities.containers2;

/**
 * Iterator for accessing and traversing elements of a container.
 */
public interface Iterator<Element> extends Cloneable, java.util.Iterator<Element> {

  /**
   * Initialize this <code>Iterator</code> to reference the first element.
   */
  public void reset ();

  /**
   * Advance this <code>Iterator</code> to the next element.
   * @require    <code>!this.done()</code>
   */
  public void advance ();

  /**
   * No more elements to traverse in the container.
   */
  public boolean done ();

  /**
   * Element this <code>Iterator</code> currently references.
   * @require    <code>!this.done()</code>
   */
  public Element get ();

  /**
   * The specified <code>Object</code> is an <code>Iterator</code> of the same class as this,
   * and references the same relative element of the same container.
   */
  public boolean equals (Object obj);
  
  /**
   * This <code>Iterator</code> traverses the specified container.
   */
  public boolean traverses (Object container);

  /**
   * A copy of this <code>Iterator</code>.
   */
  public Object clone ();
  
  /**
   * Set this <code>Iterator</code> to reference the same container element as the speciifed
   * <code>Iterator</code>. Both <code>Iterator</code>s must traverse the same container.
   * @require    <code>this.traverses(container)</code> implies <code>other.traverses(container)</code>
   * @ensure     <code>this.equals(other)</code>
   */
  public void setEqualTo (Iterator<Element> other);

  /**
   * There are more elements to traverse. Equivalent to <code>!this.done()</code>.
   */
  public boolean hasNext ();
  
  /**
   * Return the current element and advance to the next.
   * @require    <code>!this.done()</code>
   */
  public Element next ();
  
  /**
   * Throw <code>UnsupportedOperationException</code>. (Removal with this
   * iterator is not allowed.)
   */
  public void remove ();
}
