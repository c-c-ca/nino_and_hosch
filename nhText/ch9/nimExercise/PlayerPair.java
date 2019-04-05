package ch9.nimExercise;

/**
 * A class supporting an exercise.
 */
public class PlayerPair {
  
  private Player player1;
  private Player player2;
  
  public PlayerPair (Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
  }
  
  public Player getPlayer (int which) {
    if (which == 1)
      return player1;
    else
      return player2;
  }
  
}

