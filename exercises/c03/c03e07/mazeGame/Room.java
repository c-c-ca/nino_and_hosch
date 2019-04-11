package mazeGame;

/**
 * A room in the maze.
 */
public class Room {

  // Private components:

  private String description;
  private Boolean occupied;    // an explorer is in this room

  // Constructors:

  /**
   * Create a new Room with the specified decription.
   */
  public Room (String description) {
    this.description = description;
    this.occupied = false;
  }

  // Queries:

  /**
   * An Explorer is currently located in this Room.
   */
  public Boolean occupied () {
      return occupied;
  }

  /**
   * String representation of this Room.
   */
  public String toString () {
    return "Room: " + description;
  }

  // Commands:

  /**
   * The Explorer has entered this Room.
   */
  public void enter () {
      occupied = true;
  }

  /**
   * The Explorer has exited this Room.
   */
  public void exit () {
      occupied = false;
  }

}
