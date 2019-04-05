package nhUtilities.utilities;

/**
 * Precondition verification utilities. These methods can be used in place of the
 * standard <code>assert</code> statement. Unlike <code>assert</code>, they do not
 * to be specifically enabled when the program is run.
 */
public class Require {
  
  /**
   * Verify that the specified condition is true.<br>
   * Throws an <code>AssertionError</code> error if it is not.
   */
  public static void condition (boolean condition) {
    if (!condition) throw new AssertionError();
  }
  
  /**
   * Verify that the specified condition is true.<br>
   * Throws an <code>AssertionError</code> error containing the
   * specified message if it is not.
   */
  public static void condition (boolean condition, String message) {
    if (!condition) throw new AssertionError(message);
  }

  /**
   * Verify that the reference <code>object</code> is not <em>null</em><br>
   * Throws an <code>AssertionError</code> error if it is.
   */
  public static void nonNull (Object object) {
    if (object == null) throw new AssertionError("null argument");
  }
}
