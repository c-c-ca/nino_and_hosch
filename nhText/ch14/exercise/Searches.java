package ch14.exercise;
import nhUtilities.containers.*;
import java.util.Comparator;

public class Searches {
  
  private static int linearCount;
  private static int binaryCount;
  
  /**
   * The index of the first occurrence of the specified element,
   * or -1 if this List does not contain the specified element.
   */
  public static <Element> int linearSearch (Element item, List<Element> list) {
    linearCount = 0;
    int i = 0;
    while (i < list.size() && !list.get(i).equals(item)) {
      linearCount = linearCount + 1;
      i = i+1;
    }
    System.out.println("Number of steps: " + linearCount);
    if (i < list.size())
      return i;
    else
      return -1;
  }
  
  /**
   * The index of the specified item on the specified list, located by binary search.
   * Returns -1 if the item is not on the list.
   * @require
   *     item != null
   *     list is sorted according to the order
   * @ensure
   *     if result == -1 then
   *         item equals no element of list
   *     else
   *         item.equals(list.get(result)),
   *         and result is the smallest value for which this is true
   */  
  public static <Element> int binarySearch (Element item, List<Element> list,
                                            Comparator<Element> order) {
    binaryCount = 0;
    int i = itemIndex(item, list, order);
    while (i < list.size() && !list.get(i).equals(item) &&
           order.compare(item,list.get(i)) == 0) {
      binaryCount = binaryCount + 1;
      i = i + 1;
    }
    System.out.println("Number of steps: " + binaryCount);
    if (i < list.size() && list.get(i).equals(item))
      return i;
    else
      return -1;
  }
  
  /**
   * The proper place for the specified item on the specified list,
   * found using binary search.
   * @require
   *     list is sorted according to order.
   * @ensure
   *     0 <= result && result <= list.size()
   *     for 0 <= i && i < result
   *         order.compare(list.get(i),item) < 0
   *     for result <= i && i < list.size()
   *         order.compare(list.get(i),item) >= 0
   */
  private static <Element> int itemIndex (Element item, List<Element> list,
                                   Comparator<Element> order) {
    int low;     // the lowest index being examined
    int high;    // the highest index begin examined
    /*
     * list.get(low)...list.get(high) is the segment
     * of the list still to be considered.
     * for all indexes i: i < low implies
     *    order.compare(list.get(i),item) < 0
     * for all indexs i: i > high implies
     *    order.compare(list.get(i),item) >= 0
     */
    int mid;     // the middle item between low and high. mid == (low+high)/2
    low = 0;
    high = list.size() - 1;
    while (low <= high) {
      binaryCount = binaryCount + 1;
      mid = (low+high)/2;
      if (order.compare(list.get(mid),item) < 0)
        low = mid+1;
      else
        high = mid-1;
    }
    return low;
  }
