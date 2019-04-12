package trafficSimulation;

/**
 * Models a simple green-yellow-red traffic signal with left-turn signal.
 */
public class TrafficSignal {

  // Named constants

  private static final int GREEN = 0;      // The green signal light.
  private static final int YELLOW = 1;     // The yellow signal light.
  private static final int RED = 2;        // The red signal light.
  private static final int LEFT_TURN = 3;  // The left turn signal light.

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
   * The light for this TrafficSignal is currently green.
   */
  public Boolean isGreenLight () {
      return light == GREEN;
  }

  /**
   * The light for this TrafficSignal is currently yellow.
   */
  public Boolean isYellowLight () {
      return light == YELLOW;
  }

  /**
   * The light for this TrafficSignal is currently red.
   */
  public Boolean isRedLight () {
      return light == RED;
  }

  /**
   * The light for this TrafficSignal is currently the left turn signal.
   */
  public Boolean isLeftTurn () {
      return light == LEFT_TURN;
  }

  /**
   * Change to the next light.
   */
  public void change () {
      light = (light + 1) % 4;
  }

}
