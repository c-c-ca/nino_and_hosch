package trafficSimulation;

/**
 * Models a simple green-yellow-red traffic signal.
 */
public class TrafficSignal {

  // Named constants

  /**
   * The green signal light.
   */
  public static final int GREEN = 0;
  /**
   * The yellow signal light.
   */
  public static final int YELLOW = 1;
  /**
   * The red signal light.
   */
  public static final int RED = 2;

  // Private components:

  private int light;      // current light

  // Constructors:

  /**
   * Create a new TrafficSignal, initially green.
   */
  public TrafficSignal () {
      light = GREEN;
  }

  // Queries:

  /**
   * The current light that is on.
   * @ensure     result == TrafficSignal.GREEN ||
   *             result == TrafficSignal.YELLOW ||
   *             result == TrafficSignal.RED
   */
  public int light () {
      return light;
  }

  // Commands:

  /**
   * Change to the next light.
   */
  public void change () {
      light = (light + 1) % 3;
  }

}
