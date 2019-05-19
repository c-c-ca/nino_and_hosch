package containers;

import nhUtilities.containers.*;

/**
 * Modified version of DefaultList as provided in the nhUtilities
 * library to test alternate implementations of the indexOf method
 * suggested in Chapter 12 Exercise 10.
 */
public class ModifiedDefaultList<Element> extends DefaultList<Element> {

  public int indexOf (Element element) {
      return indexOfB(element);
  }

  /**
   * First suggested implementation (a).
   * invariant: all elements with an index less than i-1
   *            are not equal to the specified element
   */
  private int indexOfA (Element element) {
    boolean found = false;
    int i = 0;
    while (i < this.size() && !found) {
        found = this.get(i).equals(element);
        i = i+1;
    }
    if (i-1 < this.size())
        return i-1;
    else
        return -1;
  }

  /**
   * Second suggested implementation (b).
   * invariant: item is less than 0 when all elements with
   *            an index less than i are not equal to the
   *            specified element
   */
  private int indexOfB (Element element) {
    int item = -1;
    int i = 0;
    while (i < this.size() && item < 0) {
        if (this.get(i).equals(element))
            item = i;
        i = i+1;
    }
    return item;
  }


}
