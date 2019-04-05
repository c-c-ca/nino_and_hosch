package ch13;
import nhUtilities.containers.*;

/**
 * A dummy class for illustrating array subtyping.
 */
public class Subtyping {
  
  public Subtyping () {
    Integer[] integerArray = new Integer[1];
    integerArray[0] = new Integer(100);
    List<Integer> integerList = new DefaultList<Integer>();
    integerList.add(new Integer(100));
    // setArrayElement(integerArray);
    setListElement(integerList);
  }
  
  /**
   * Set the first element of the array (index 0) to reference the empty String.
   * @require    array.length > 0
   */
  public void setArrayElement (Object[] array) {
    array[0] = "string";
  }
  
  /**
   * Set the first element of the List (index 0) to reference the empty String.
   * @require    list.size() > 0
   */
  public void setListElement (List<Object> list) {
    list.set(0,"string");
  }
}
