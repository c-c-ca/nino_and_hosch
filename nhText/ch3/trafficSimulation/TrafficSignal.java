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
  
  // Constructor
  
  /**
   * Create a new TrafficSignal, initially green.
   */
  public TrafficSignal () {
  }
  
  /**
   * The current light that is on.
   * Returns TrafficSignal.GREEN,
   * TrafficSignal.YELLOW, or TrafficSignal.RED.
   */
  public int light () {
    return 0;
  }
  
  /**
   * Change to the next light.
   */
  public void change () {
  }
  
}
