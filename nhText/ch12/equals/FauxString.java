package ch12.equals;

/**
 * A class mimicking a String. Only for exercise puporses.
 * Unlike java.lang.String, this class is not final.
 */
public class FauxString {
  
  private String value;
 
  /**
   * Create a new FauxString.
   */
  public FauxString (String s) {
    value = s;
  }
  
  /**
   * This FauxString as a String.
   */
  public String toString () {
    return value;
  }
 
  /**
   * Two FauxStrings are equal if they contain the same characters.
   */
  public boolean equals (Object s) {
    if (s instanceof FauxString)
      return s.toString().equals(this.toString());
    else
      return false;
  }
}
