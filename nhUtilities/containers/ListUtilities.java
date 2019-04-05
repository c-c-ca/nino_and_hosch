package nhUtilities.containers;
import java.util.Comparator;

/**
 * Sort and search utilities.
 */
public class ListUtilities {
  
  /**
   * Sort the specified <code>List&lt;Element&gt;</code> using selection sort.
   * @ensure     for all indexes <code>i</code>, <code>j</code>:<br>
   *             <code>&nbsp;&nbsp;order.compare(list.get(i),list.get(j)) &lt; 0</code> implies <code>i &lt; j</code>.
   */
  public static <Element> void selectionSort (List<Element> list, Comparator<Element> order) {
    int first;    // index of first element to consider on this step
    int last;     // index of last element to consider on this step
    int small;    // index of smallest of list.get(first)...list.get(last)
    last = list.size() - 1;
    first = 0;
    while (first < last) {
      small = smallestOf(list, first, last, order);
      interchange(list, first, small);
      first = first+1;
    }
  }
  
  /**
   * Index of the smallest of <code>list.get(first)</code> through <code>list.get(last)</code>.
   * @require    <code>0 &lt;= first &amp;&amp; first &lt;= last &amp;&amp; last &lt; list.size()</code>
   * @ensure     for all <code>i</code>: <code>first &lt;= i &amp;&amp; i &lt;= last</code> implies
   *             <code>&nbsp;&nbsp;compare(list.get(result),list.get(i)) &lt;= 0</code>
   */
  private static <Element> int smallestOf (List<Element> list, int first, int last,
                                           Comparator<Element> order) {
    int next;     // index of next element to examine.
    int small;    // index of the smallest of get(first)...get(next-1)
    small = first;
    next = first+1;
    while (next <= last) {
      if (order.compare(list.get(next), list.get(small)) < 0)
        small = next;
      next = next+1;
    }
    return small;
  }
  
  /**
   * Sort specified <code>List&lt;Element&gt;</code> using bubble sort.
   * @ensure     for all indexes <code>i</code>, <code>j</code>:<br>
   *             <code>&nbsp;&nbsp;order.compare(list.get(i),list.get(j)) &lt; 0</code> implies <code>i &lt; j</code>.
   */
  public static <Element> void bubbleSort (List<Element> list, Comparator<Element> order) {
    int last;      // index of last element to position on this pass
    boolean done;  // pass made with no interchanges
    last = list.size() - 1;
    done = false;
    while (!done && last > 0) {
      done = makePassTo(list, last, order);
      last = last-1;
    }
  }
  
  /*
   * Make a pass through list, bubbling an element to position
   * <code>last</code>, and report if anything needed to be changed.
   * @require    <code>0 &lt last &amp;&amp; last &lt list.size()</code>
   * @ensure     for all <code>i</code>: <code>0 &lt= i &amp;&amp; i &lt last</code> implies<br>
   *             <code>&nbsp;&nbsp;order.compare(list.get(i),list.get(last)) &lt= 0</code><br>
   *             <code>result == true</code> iff<br>
   *             <code>&nbsp;&nbsp;</code>for all <code>i</code>, <code>j</code>: <code>0 &lt= i &amp;&amp; i &lt= last &amp;&amp; 0 &lt= j &amp;&amp; j &lt= last</code>,<br>
   *             <code>&nbsp;&nbsp;order.compare(list.get(i),list.get(j)) &lt 0</code> implies <code>i &lt j</code>.
   */
  private static <Element> boolean makePassTo (List<Element> list, int last,
                                               Comparator<Element> order) {
    int next;                // index of next pair to examine.
    boolean noItemsSwapped;  // no out of order items found
    next = 0;
    noItemsSwapped = true;
    while (next < last) {
      if (order.compare(list.get(next+1),list.get(next)) < 0) {
        interchange(list, next, next+1);
        noItemsSwapped = false;
      }
      next = next+1;
    }
    return noItemsSwapped;
  }
  
 /**
   * Interchange <code>list.get(i)</code> and <code>list.get(j)</code>
   * @require    <code>0 &lt;= i &amp;&amp; i &lt; list.size() &amp;&amp; 0 &lt;= j &amp;&amp; j &lt; list.size()</code>
   * @ensure     <code>list.old.get(i) == list.get(j)</code><br>
   *             <code>list.old.get(j) == list.get(i)</code>
   */
  private static <Element> void interchange (List<Element> list, int i, int j) {
    Element temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
}
