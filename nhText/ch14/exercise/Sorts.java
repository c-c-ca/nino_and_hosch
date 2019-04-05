package ch14.exercise;
import nhUtilities.containers.*;
import java.util.Comparator;

public class Sorts {
  
  private static int bubbleCount;
  private static int selectionCount;
  
  /**
   * Sort the specified List<Element> using selection sort.
   * @ensure
   *     for 0 <= i < list.size() && 0 <= j < list.size(),
   *         order.compare(list.get(i),list.get(j))< 0 implies i < j.
   */
  public static <Element> void selectionSort (List<Element> list, Comparator<Element> order) {
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
   * Sort specified List<Element> using bubble sort.
   * @ensure
   *     for 0 <= i <= list.size() && 0 <= j < list.size(),
   *         order.compare(list.get(i),list.get(j)) < 0 implies i < j.
   */
  public static <Element> void bubbleSort (List<Element> list, Comparator<Element> order) {
    int last;        // index of last element to position on this pass
    boolean done;    // pass made with no interchanges
    last = list.size() - 1;
    done = false;
    bubbleCount = 0;
    while (!done && last > 0) {
      done = makePassTo(list, last, order);
      last = last-1;
    }
    System.out.println("Number of steps: " + bubbleCount);
  }


 /*
   * Index of the smallest of
   * list.get(first) through list.get(last)
   * @require    0 <= first <= last < list.size()
   * @ensure
   *     for first <= i <= last,
   *         order.compare(list.get(result),list.get(i)) <= 0
   */
  private static <Element> int smallestOf (List<Element> list, int first, int last, Comparator<Element> order) {
    int next;     // index of next element to examine.
    int small;    // index of the smallest of get(first)...get(next-1)
    small = first;
    next = first+1;
    while (next <= last) {
      selectionCount = selectionCount + 1;
      if (order.compare(list.get(next),list.get(small)) < 0)
        small = next;
      next = next+1;
    }
    return small;
  }

  /*
   * Make a pass through list, bubbling an element to position
   * last, and report if anything needed to be changed.
   * @require    0 < last < list.size()
   * @ensure
   *     for 0 <= i < last,
   *         order.compare(list.get(i),list.get(last)) <= 0
   *     result == true iff
   *         for 0 <= i <= last && 0 <= j <= last,
   *             order.compare(list.get(i),list.get(j)) < 0 implies i < j.
   */
  private static <Element> boolean makePassTo (List<Element> list, int last, Comparator<Element> order) {
    int next;                // index of next pair to examine.
    boolean noItemsSwapped;  // no out of order items found
    next = 0;
    noItemsSwapped = true;
    while (next < last) {
      bubbleCount = bubbleCount + 1;
      if (order.compare(list.get(next+1),list.get(next)) < 0) {
        interchange(list, next, next+1);
        noItemsSwapped = false;
      }
      next = next+1;
    }
    return noItemsSwapped;
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

  
