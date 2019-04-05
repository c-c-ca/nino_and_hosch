package ch19.quickSort;
import nhUtilities.containers.*;

public class SortUtilities {
  
  private static int quickCount;
  private static int selectionCount;
  
  /**
   * Sort specified List<Element> using quick sort.
   * @ensure
   *     for 0 <= i <= list.size() && 0 <= j < list.size(),
   *         order.inOrder(list.get(i),list.get(j)) implies i < j.
   */
  public static <Element> void quickSort (List<Element> list, Order<Element> order) {
    quickCount = 0;
    quickSort(list,0,list.size()-1,order);
    System.out.println("Number of steps: " + quickCount);
  }
  
  private static <Element> void quickSort (List<Element> list, int first, int last,
                                           Order<Element> order) {
    int position;     // the pivot index
    if (first < last) {
      position = partition(list,first,last,order);
      quickSort(list,first,position-1,order);
      quickSort(list,position+1,last,order);
    }
  }
  
/**
 * Partition list elements indexed first through last for quick sort;
 * return the pivot position.
 * @require    0 <= first && first < last && last < list.size()
 * @ensure     first <= result && result <= last
 *             for all i: first <= i && i < result,
 *                 list.get(i) < list.get(result)
 *                 i.e., order.inOrder(list.get(i),list.get(result))
 *             for all i: result <= i && i <= last,
 *                 list.get(i) >= list.get(result)
 *                 i.e., !order.inOrder(list.get(i),list.get(result))
 */
  private static <Element> int partition (List<Element> list, int first, int last,
                                          Order<Element> order) {
    int pi;     // pivot index
    int i;     // index of the next to examine
    Element item;     // pivot item
    int mid = (first+last)/2;
    item = list.get(mid);

    // put pivot item at end of list for now
    interchange(list,mid,last);

    pi = first;
    i = first;     // haven't examined anything yet

    /* loop invariant:
     *  for all j: first <= j && j < pi
     *      list.get(j) < item
     *  for all j: pi <= j && j < i
     *      list.get(j) >= item
     */
    while (i != last) {   // list.get(last) is pivot item
      if (order.inOrder(list.get(i),item)) {
        interchange(list,pi,i);
        pi = pi+1;
      }
      i = i+1;
      quickCount = quickCount + 1;
    }
    interchange(list,pi,last);     // put pivot item in place
    return pi;
  }
  
  /**
   * Sort the specified List<Element> using selection sort.
   * @ensure
   *     for 0 <= i < list.size() && 0 <= j < list.size(),
   *         order.inOrder(list.get(i),list.get(j)) implies i < j.
   */
  public static <Element> void selectionSort (List<Element> list, Order<Element> order) {
    int first;     // index of first element to consider on this step
    int last;      // index of last element to consider on this step
    int small;     // index of smallest of list.get(first)...list.get(last)
    last = list.size() - 1;
    first = 0;
    selectionCount = 0;
    while (first < last) {
      small = smallestOf(list,first,last,order);
      interchange(list,first,small);
      first = first+1;
    }
    System.out.println("Number of steps: " + selectionCount);
  }

  /**
   * Index of the smallest of
   * list.get(first) through list.get(last)
   * @require    0 <= first <= last < list.size()
   * @ensure
   *     for first <= i <= last,
   *         ! order.inOrder(list.get(i),list.get(result))
   */
  private static <Element> int smallestOf (List<Element> list, int first, int last, Order<Element> order) {
    int next;     // index of next element to examine.
    int small;    // index of the smallest of get(first)...get(next-1)
    small = first;
    next = first+1;
    while (next <= last) {
      selectionCount = selectionCount + 1;
      if (order.inOrder(list.get(next),list.get(small)))
        small = next;
      next = next+1;
    }
    return small;
  }

  /*
   * Interchange list.get(i) and list.get(j)
   * @require   0 <= i < list.size() && 0 <= j < list.size()
   * @ensure
   *     list.old.get(i) == list.get(j)
   *     list.old.get(j) == list.get(i)
   */
  private static <Element> void interchange (List<Element> list, int i, int j) {
    Element temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
}

  
