package nhUtilities.utilities;

/**
 * Thread based utilities.
 */
public class Control {

  /**
   * Sleep the specified number of seconds.
   * @require    <code>seconds &gt;= 0</code>
   */
  public static void sleep (int seconds) {
    int delay = seconds*1000; // java.lang.Thread.sleep takes milisecs.
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {}
  }
}
