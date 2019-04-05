package ch12.equals;

/**
 * Just for exercise putproses.
 */
public class Test {
  
  public static void report (FauxString s1, FauxString s2) {
    if (s1.equals(s2))
      System.out.println("The FauxStrings are equal.");
    else
      System.out.println("The FauxStrings are not equal.");
    if (s1.toString().equals(s2.toString()))
      System.out.println("The Strings are equal.");
    else
      System.out.println("The Strings are not equal.");
  }
}
