package ch9.exercise;

/**
 * A pair of Strings.
 */
public class StringPair implements Pair {

  private String first;
  private String second;
  
  /**
   * Create a StringPair with empty components.
   */
  public StringPair () {
    first = new String("");
    second = new String("");
  }

  public Object first () {
    return first;
  }
  
  public Object second () {
    return second;
  }
  
}
  
