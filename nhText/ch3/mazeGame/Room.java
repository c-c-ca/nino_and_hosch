package mazeGame;

/**
 * A room in the maze.
 */
public class Room {
  
  // Private components:
  
  private String description;

  // Constructors:
  
  /**
   * Create a new Room with the specified decription.
   */
  public Room (String description) {
    this.description = description;
  }
  
  // Queries:

  /**
   * String representation of this Room.
   */
  public String toString () {
    return "Room: " + description;
  }

  // Commands:
  
