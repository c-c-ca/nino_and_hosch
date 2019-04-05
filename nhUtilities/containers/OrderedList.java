package nhUtilities.containers;
import java.util.Comparator;

/**
 * A finite ordered list of <code>Element</code>s.<br><br>
 * Class invariant:<br>
 * <code>&nbsp;&nbsp;</code>for all indexes <code>i</code>, <code>j</code>:<br>
 * <code>&nbsp;&nbsp;&nbsp;&nbsp;ordering().compare(get(i),get(j)) &lt; 0</code>
 * implies <code>i &lt; j</code>.<br>
 * <code>&nbsp;&nbsp;</code>Subject to no list item changing properties which determine the
 * relation defined by <code>ordering().compare</code>.
 */
public interface OrderedList<Element> extends java.lang.Iterable<Element>, Indexed<Element> {
  
  /**
   * Number of elements in this <code>OrderedList</code>.
   * @ensure     <code>this.size() &gt;= 0</code>
   */
  public int size ();

  /**
   * This <code>OrderedList</code> contains no elements.
   * <br>
   * <code>this.isEmpty() == (this.size() == 0)</code>
   */
  public boolean isEmpty ();

  /**
   * The <code>Element</code> with the specified index.
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   */
  public Element get (int index);

  /**
   * The index of the first occurrence of the specified element,
   * or -1 if this <code>OrderedList</code> does not contain the specified element.
   * @ensure     if <code>this.indexOf(element) &gt;= 0<br>
   *             &nbsp;&nbsp;this.get(this.indexOf(element)).equals(element)<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>: <code>j &lt; this.indexOf(element)</code> implies<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code><br>
   *             if <code>this.indexOf(element) == -1<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>,<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code>
   */
  public int indexOf (Element element);

  /**
   * This <code>OrderedList</code> contains the specified <code>Element</code>.
   * <br>
   * <code>this.contains(element) == (this.indexOf(element) &gt;= 0)</code>
   */
  public boolean contains (Element element);

  /**
   * Add the specified <code>Element</code> to the proper place in this <code>OrderedList</code>.
   * @require    <code>element != null</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             for some index <code>i</code>,<br>
   *             <code>&nbsp;&nbsp;this.get(i).equals(element)</code>
   */
  public void add (Element element);

  /**
   * Remove the element with the specified index.
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   * @ensure     <code>this.size() == old.size() - 1</code><br>
   *             for all <code>j</code>: <code>index &lt;= j &amp;&amp; j &lt; this.size()</code> inmplies<br>
   *             <code>&nbsp;&nbsp;this.get(j).equals(old.get(j+1))</code>
   */
  public void remove (int index);

  /**
   * Remove the first occurrence of the specified <code>Element</code> from this <code>OrderedList</code>.
   * Has no effect if the <code>Element</code> is not contained in this <code>OrderedList</code>.<br>
   * if <code>this.indexOf(element) &gt;= 0</code>, equivalent to <code>this.remove(this.indexOf(element))</code>.
   */
  public void remove (Element element);

  /**
   * A copy of this <code>OrderedList</code>.
   * @ensure     <code>this.copy() != this</code><br>
   *             <code>this.copy().size() == this.size()</code><br>
   *             for all indexes <code>i</code>,<br>
   *             <code>&nbsp;&nbsp;this.get(i).equals(this.copy().get(i))</code>
   */
  public OrderedList<Element> copy ();
 
  /**
   * The <code>Comparator</code> used to order this <code>OrderedList</code>.
   */
  public Comparator<Element> ordering ();

  /**
   * Populate this <code>OrderedList</code> from the specified <code>List</code>.
   * @ensure     <code>this.size() == list.size()</code><br>
   *             for all indexes <code>i</code>,<br>
   *             <code>&nbsp;&nbsp;this.get(i).equals(list.get(j))</code>, for some <code>j</code>.
   */
  public void populate (List<Element> list);
  
  /**
   * Create a new <code>List</code> containing the elements of this <code>OrderedList</code>.
   * @ensure     <code>this.toList().size() == this.size()</code><br>
   *             for all indexes <code>i</code>,<br>
   *             <code>&nbsp;&nbsp;this.toList().get(i).equals(this.get(j))</code>
   */
  public List<Element> toList ();
  
  /**
   * Validate ordering, reordering if necessary.
   * @ensure     for all indexes <code>i</code>, <code>j</code>:<br>
   *             <code>&nbsp;&nbsp;ordering().compare(get(i),get(j)) &lt; 0</code>
   *             implies <code>i &lt; j</code>.<br>
   */
  public void validateOrder ();

  /**
   * A <code>java.util.Iterator</code> for this <code>OrderedList</code>. (For
   * compatibility with the "enhanced <code>for</code>" semantics. sigh.)
   */
  public java.util.Iterator<Element> iterator ();
  
}
