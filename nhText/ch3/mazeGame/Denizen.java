package mazeGame;

/**
 * A denizen in the maze.
 */
public class Denizen {
  
  // Private components:
  
  private int tolerance;
  private static final int DEFAULT_TOLERANCE = 100;

  // Constructors:
  
  /**
   * Create a new Denizen.
   */
  public Denizen () {
    this.tolerance = DEFAULT_TOLERANCE;
  }
  
  // Queries:

  /**
   * Annoyance (hit points) required to vanquish this Denizen.
   */
  public int tolerance () {
    return tolerance;
  }

  // Commands:
  
  /**
   * Receive a poke of the specified number of hit points.
   */
  public void takeThat (int annoyance) {
    tolerance = tolerance - annoyance;
  }

