package ch12.sets;
import nhUtilities.containers.*;

/**
 * A skeletal implemetation of a finite set of integers.
 */
public class IntegerSet {
  
  private List<Integer> elements;
  
  /**
   * Create a new IntegerSet containing the elements of the specified List.
   */
  public IntegerSet (List<Integer> elements) {
     this.elements = elements.copy();
     removeDuplicates();
  }
  
  /**
   * Remove duplicates from the component List.
   */
  private void removeDuplicates () {
    int i =0;
    while (i < elements.size()) {
      Integer item = elements.get(i);   // remove duplicates of this
      int j = i+1;                      // index of element to check
      while (j < elements.size())
        if (item.equals(elements.get(j)))
          elements.remove(j);
        else
          j = j+1;
      i = i+1;
    }
  }
  
}
