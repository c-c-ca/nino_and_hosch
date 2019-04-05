package mazeGame;

/**
 * A maze game player.
 */
public class Explorer {
  
  private int annoyability;
  private int tolerance;
  
  /**
   * Create a new Explorer with the specified name, initial location, annoyability,
   * and tolerance.
   */
  public Explorer (int annoyability, int tolerance) {
    this.annoyability = annoyability;
    this.tolerance = tolerance;
  }
  
  /**
   * Annoyance (hit points) this Explorer causes when poking an opponent.
   */
  public int annoyability () {
    return annoyability;
  }
  
  /**
   * Annoyance (hit points) required to vanquish this Explorer.
   */
  public int tolerance () {
    return tolerance;
  }
  
  /**
   * Receive a poke of the specified number of hit points.
   */
  public void takeThat (int annoyance) {
    if (annoyance <= tolerance) 
      tolerance = tolerance - annoyance;
    if (annoyance > tolerance) 
      tolerance = 0;
  }
  
