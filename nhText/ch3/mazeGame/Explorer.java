package mazeGame;

/**
 * A maze game player.
 */
public class Explorer {

  // Constructors:
 
  /**
   * Create a new Explorer with the specified name, initial location, annoyability,
   * and tolerance.
   */
  public Explorer (String name, Room location, int annoyability, int tolerance) {
  }
  
  // Queries:
  
  /**
   * Name of this Explorer.
   */
  public String name () {
    return null;
  }
  
  /**
   * Room in which this Explorer is currently located.
   */
  public Room location () {
    return null;
  }

  /**
   * Annoyance (hit points) this Explorer causes when poking an opponent.
   */
  public int annoyability () {
    return 0;
  }

  /**
   * Annoyance (hit points) required to vanquish this Explorer.
   */
  public int tolerance () {
    return 0;
  }

  // Commands:
  
  /**
   * Move to the specified Room.
   */
  public void move (Room newRoom) {
  }
  
  /**
   * Receive a poke of the specified number of hit points.
   */
  public void takeThat (int annoyance) {
  }

  /**
   * Poke the specified Denizen.
   */
  public void poke (Denizen opponent) {
  }

