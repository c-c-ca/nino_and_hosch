package ch15.exercise;
import nhUtilities.containers.*;

/**
 * An exercise class for generating some common exceptions.
 */
public class ExceptionGenerator {
  
  private int divisor;
  private Object myObject;
  private List<Integer> myList;
  private Integer myInteger;
  private int maxInt;
  
  public ExceptionGenerator () {
    myObject = "123";
    myList = new DefaultList<Integer>();
    maxInt = Integer.MAX_VALUE;
  }
  
  public int tryIt (int option) throws java.io.FileNotFoundException {
    assert 1 <= option && option <= 6;
    if (option == 1)
      return 1/divisor;
    else if (option == 2)
      return ((Integer)myObject).intValue();
    else if (option == 3)
      return myList.get(0).intValue();
    else if (option == 4)
      return myInteger.intValue();
    else if (option == 5)
      return 1+maxInt;
    else if (option == 6) {
      java.io.FileReader input = new java.io.FileReader("TheFileThatWasNotThere");
      return 0;
    } else
      return -1;
  }
  
}

  
