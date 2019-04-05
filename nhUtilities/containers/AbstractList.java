package nhUtilities.containers;

/**
 * Base class for implementing interface <code>List</code>. To complete an implementation,
 * the following methods must be implemented:
 * <pre>   public int size ()
 *   public Element get (int)
 *   public void set (int, Element)
 *   public void add (int, Element)
 *   public void remove (int)
 *   public List&lt;Element&gt; copy ()
 * </pre>
 */
public abstract class AbstractList<Element> implements List<Element> {
  
  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.size()</code>.
   */
  public boolean isEmpty () {
    return this.size() == 0;
  }

  /**
   * {@inheritDoc}
   * <p>
   * This implementation iterates through the list invoking <code>this.get(int)</code>
   * until element is found or the list is exhausted. <code>this.size()</code> is also invoked.
   * @ensure     if <code>this.indexOf(element) &gt;= 0<br>
   *             &nbsp;&nbsp;this.get(this.indexOf(element)).equals(element)<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>: <code>j &lt; this.indexOf(element)</code> implies<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code><br>
   *             if <code>this.indexOf(element) == -1<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>,<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code>
   */
  public int indexOf (Element element) {
    int i = 0;
    while (i < this.size() && !this.get(i).equals(element))
      i = i + 1;
    if (i == this.size())
      return -1;
    else
      return i;
  }

  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.indexOf(element)</code>.
   */
  public boolean contains (Element element) {
    return this.indexOf(element) != -1;
  }

  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.add(this.size(),element)</code>.
   * @require    <code>element != null</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             <code>this.get(this.size()-1).equals(element)</code>
   */
  public void add (Element element) {
    this.add(this.size(),element);
  }

  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.remove(int)</code>.
   */
  public void remove (Element element) {
    int index = indexOf(element);
    if (index != -1)
      this.remove(index);
  }

  /**
   * String representation of this <code>List</code>.
   * <p>
   * This implementation invokes <code>this.size()</code>, and <code>this.get(int)</code> for each
   * <code>List</code> index.
   */
  public String toString () {
    String s = "[";
    int n = this.size();
    if (n > 0) {
      s = s + this.get(0).toString();
      int index;
      for (index = 1; index < n; index = index+1)
        s = s + ", " + this.get(index).toString();
    }
    s = s + "]";
    return s;
  }

  /**
   * {@inheritDoc}
   * <p>
   * This implementation provides a simple iterator that uses indexing.
   */
  public java.util.Iterator<Element> iterator () {
    return new IndexingIterator<Element>(this);
  }
  
}
