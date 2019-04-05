package nhUtilities.containers;
import java.util.Comparator;

/**
 * Base class for implementing interface <code>OrderedList</code>. The methods implemented
 * herein are not particualrly efficient. To complete an implementation,
 * the following methods must be implemented:
 * <pre>   public int size ()
 *   public Element get (int)
 *   public void add (Element)
 *   public void remove (int)
 *   public OrderedList&lt;Element&gt; copy ()
 * </pre>
 * For efficiency, the following protected methods should also be overridden.
 * <pre>   protected void clear ()
 *   protected int itemIndex (Element item)
 * </pre>
 */
public abstract class AbstractOrderedList<Element> implements OrderedList<Element> {
  
  protected java.util.Comparator<Element> order;
  
  /**
   * Create a new empty <code>DefaultOrderedList&lt;Element&gt;</code>, ordered by the specified
   * <code>Comparator</code>.
   * @ensure     <code>this.isEmpty()</code>
   *             <code>this.ordering().equals(order)</code>
   */
  protected AbstractOrderedList (Comparator<Element> order) {
    this.order = order;
  }
  
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
   * This implementation invokes <code>this.size()</code> and <code>this.get(int)</code>.
   * @ensure     if <code>this.indexOf(element) &lt;= 0<br>
   *             &nbsp;&nbsp;this.get(this.indexOf(element)).equals(element)<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>: <code>j &lt; this.indexOf(element)</code> implies<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code><br>
   *             if <code>this.indexOf(element) == -1<br>
   *             &nbsp;&nbsp;</code>for all indexes <code>j</code>,<br>
   *             <code>&nbsp;&nbsp;&nbsp;&nbsp;!this.get(j).equals(element)</code>
   */
  public int indexOf (Element element) {
    int i = itemIndex(element);
    int size = this.size();
    while (i < size && !this.get(i).equals(element) && order.compare(this.get(i),element) == 0)
      i = i+1;
    if (i < size && this.get(i).equals(element))
      return i;
    else
      return -1;
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
   * This implementation invokes <code>this.remove(int)</code>.
   */
  public void remove (Element element) {
    int index = indexOf(element);
    if (index != -1)
      this.remove(index);
  }
  
  /**
   * {@inheritDoc}
   */
  public Comparator<Element> ordering () {
    return this.order;
  }
  
  /**
   * {@inheritDoc}
   * <p>
   * This implementation invokes <code>this.add(Element)</code> for each element of <code>list</code>.
   * @ensure     <code>this.size() == list.size()</code><br>
   *             for all indexes <code>i</code>,<br>
   *             <code>&nbsp;&nbsp;this.get(i).equals(list.get(j))</code>, for some <code>j</code>.
   */
  public void populate (List<Element> list) {
    this.clear();
    for (int i = 0; i < list.size(); i = i+1)
      this.add(list.get(i));
  }
  
  /**
   * Create a new <code>List</code> containing the elements of this <code>OrderedList</code>.
   * <p>
   * This implementation invokes <code>this.size()</code> and <code>this.get(int)</code>.
   * @ensure     <code>this.toList().size() == this.size()</code><br>
   *             for all indexes <code>i</code>,<br>
   *             <code>&nbsp;&nbsp;this.toList().get(i).equals(this.get(j))</code>
   */
  public List<Element> toList () {
    List<Element> theList = new DefaultList<Element>();
    for (int i = 0; i < this.size(); i = i+1)
      theList.add(this.get(i));
    return theList;
  }
    
  /**
   * Validate ordering, reordering if necessary.
   * <p>
   * This implementation invokes <code>this.size()</code>, <code>this.get(int)</code>,
   * <code>this.toList()</code>, <code>this.Poplulate(List&lt;Element&gt;)</code>.
   * @ensure     for all indexes <code>i</code>, <code>j</code>:<br>
   *             <code>&nbsp;&nbsp;ordering().compare(get(i),get(j)) &lt; 0</code>
   *             implies <code>i &lt; j</code>.<br>
   */
  public void validateOrder () {
    boolean orderOk = true;
    int i = 0;
    while (orderOk && i+1 < this.size()) {
      orderOk = order.compare(this.get(i),this.get(i+1)) <= 0;
      i = i+1;
    }
    if (!orderOk) {
      List<Element> temp = this.toList();
      this.populate(temp);
    }
  }
  
  /**
   * {@inheritDoc}
   * <p>
   * This implementation provides a simple iterator that uses indexing.
   */
  public java.util.Iterator<Element> iterator () {
    return new IndexingIterator<Element>(this);
  }
    
  /**
   * String representation of this <code>DefaultOrderedList</code>.
   * <p>
   * This implementation invokes <code>this.size()</code>, and <code>this.get(int)</code> for each
   * <code>OrderedList</code> index.
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
   * Empty this <code>OrderedList</code>.
   * <p>
   * This implementation should be overridden for efficiency.
   */
  protected void clear () {
    int count = this.size();
    for (int i = count-1; i >=0; i = i-1)
      this.remove(i);
  }
  
  /**
   * The proper place for the specified item on the specified list.
   * <p>
   * This implementation should be overriden for a random access -- e.g., array-based
   * list.
   * @require    <code>this</code> is sorted according to <code>order</code>.
   * @ensure     <code>0 &lt;= result &amp;&amp; result &lt;= this.size()</code>
   *             for all indexes <code>i</code>: <code>i &lt; result</code> implies<br>
   *             <code>&nbsp;&nbsp;order.compare(list.get(i),item) &lt; 0<br>
   *             for all indexes <code>i</code>: <code>i &gt;= result</code> implies<br>
   *             <code>&nbsp;&nbsp;order.compare(list.get(i),item) &gt;= 0</code>
   */
  protected int itemIndex (Element item) {
    int i = 0;
    while (i < this.size() && order.compare(this.get(i),item) < 0)
      i = i+1;
    return i;
  }
  
}
