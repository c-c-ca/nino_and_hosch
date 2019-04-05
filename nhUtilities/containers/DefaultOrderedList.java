package nhUtilities.containers;
import java.util.Comparator;

/**
 * Default implementation of the interface <code>nhUtilities.containers.OrderedList</code>.
 * This implementation wraps an array.
 */
public class DefaultOrderedList<Element> extends AbstractOrderedList<Element> {
  
  private Object[] elements;
  private int size;
  
  /**
   * Create a new empty <code>DefaultOrderedList&lt;Element&gt;</code>, ordered by the specified
   * <code>Comparator</code>.
   * @ensure     <code>this.isEmpty()</code>
   *             <code>this.ordering().equals(order)</code>
   */
  public DefaultOrderedList (Comparator<Element> order) {
    super(order);
    elements = new Object[10];
  }
  
  /**
   * Create a new <code>DefaultOrderedList</code> copying the specified
   * <code>DefaultOrderedList</code>.
   */
  private DefaultOrderedList (DefaultOrderedList<Element> list) {
    super(list.ordering());
    size = list.size();
    elements = list.elements.clone();
  }
  
  /**
   * {@inheritDoc}
   * @ensure     <code>this.size() &gt;= 0</code>
   */
  public int size () {
    return this.size;
  }
  
  /**
   * {@inheritDoc}
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   */
  public Element get (int index) {
    return (Element)this.elements[index];
  }
  
  /**
   * {@inheritDoc}
   * @require    <code>element != null</code>
   * @ensure     <code>this.size() == old.size() + 1</code><br>
   *             for some index <code>i</code>,<br>
   *             <code>&nbsp;&nbsp;this.get(i).equals(element)</code>
   */
  public void add (Element element) {
    if (this.size == elements.length)
      expand(size/2 + 1);
    int i = size-1;
    while (i >= 0 && order.compare(element,(Element)(elements[i])) < 0) {
      elements[i+1] = elements[i];
      i = i-1;
    }
    elements[i+1] = element;
    size = size + 1;
  }
  
  /**
   * {@inheritDoc}
   * @require    <code>0 &lt;= index &amp;&amp; index &lt; this.size()</code>
   * @ensure     <code>this.size() == old.size() - 1</code><br>
   *             for all <code>j</code>: <code>index &lt;= j &amp;&amp; j &lt; this.size()</code> inmplies<br>
   *             <code>&nbsp;&nbsp;this.get(j).equals(old.get(j+1))</code>
   */
  public void remove (int index) {
    for (int i = index+1; i < size; i = i+1)
      elements[i-1] = elements[i];
    // this is really not necessary, but we remove a
    // useless reference
    elements[size-1] = null;
    size = size-1;
  }
  
  /**
   * {@inheritDoc}
   * @ensure     <code>this.copy() != this</code><br>
   *             <code>this.copy().size() == this.size()</code><br>
   *             for all indexes <code>j</code>,<br>
   *             <code>&nbsp;&nbsp;this.get(j).equals(this.copy().get(j))</code>
   */
  public OrderedList<Element> copy () {
    return new DefaultOrderedList<Element>(this);
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
    if (!orderOk)
      java.util.Arrays.sort(elements,0,size,(Comparator<Object>)order);
  }
  
  /**
   * Empty this <code>OrderedList</code>.
   */
  protected void clear () {
    for (int i = 0; i < this.size; i = i+1)
      this.elements[i] = null;
    this.size = 0;
  }
  
  /**
   * The proper place for the specified item on the specified list,
   * found using binary search.
   * @require    <code>this</code> is sorted according to <code>order</code>.
   * @ensure     <code>0 &lt;= result &amp;&amp; result &lt;= this.size()</code>
   *             for all indexes <code>i</code>: <code>i &lt; result</code> implies<br>
   *             <code>&nbsp;&nbsp;order.compare(list.get(i),item) &lt; 0<br>
   *             for all indexes <code>i</code>: <code>i &gt;= result</code> implies<br>
   *             <code>&nbsp;&nbsp;order.compare(list.get(i),item) &gt;= 0</code>
   */
  protected int itemIndex (Element item) {
    int low;      // the lowest index being examined
    int high;     // the highest index begin examined
    /*
     * this.get(low)...this.get(high) is the segment
     * of the list still to be considered.
     * for all indexes i: i < low implies
     *  order.compare(this.get(i),item) < 0
     * for all indexes i: i > high implies
     *  order.compare(this.get(i),item) >= 0
     */
    int mid;     // the middle item between low and high. mid == (low+high)/2
    low = 0;
    high = this.size() - 1;
    while (low <= high) {
      mid = (low+high)/2;
      if (order.compare((Element)this.elements[mid],item) < 0)
        low = mid+1;
      else
        high = mid-1;
    }
    return low;
  }
  
  /**
   * Create a new <code>elements</code> array bigger than the current
   * one by the specified amount. Copy values from current array to new.
   * @require    <code>increase &gt;= 0</code>
   * @ensure     <code>elements.length == old.elements.length + increase</code><br>
   *             for all <code>i</code>, <code>0 &lt;= i &amp;&amp; i &lt; old.elements.length</code>,<br>
   *      elements[i] == old.elements[i]
   */
  private void expand (int increase) {
    Object[] newElements =
      new Object[elements.length + increase];
    for (int i = 0; i < elements.length; i = i+1)
      newElements[i] = elements[i];
    elements = newElements;
  }
}
