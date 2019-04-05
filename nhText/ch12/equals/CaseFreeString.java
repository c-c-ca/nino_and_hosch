package ch12.equals;

/**
 * Two CaseFreeStrings are equal if their character sequences
 * are the same, ignoring case. Only for exercise purposes.
 */
public class CaseFreeString extends FauxString {
 
  /**
   * Create a new CaseFreeString.
   */
  public CaseFreeString (String s) {
    super(s);
  }
  
  /**
   * Two CaseFreeStrings are equal if their character sequences
   * are the same, ignoring case.
   */
  public boolean equals (Object s) {
    if (s instanceof CaseFreeString)
      return this.toString().equalsIgnoreCase(s.toString());
    else
      return false;
  }
}

