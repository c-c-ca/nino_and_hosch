package ch9.nimExercise;

/**
 * A class supporting an exercise.
 */
public class Assignments {
  
  private TimidPlayer timmie = new TimidPlayer();
  private CleverPlayer lassie = new CleverPlayer();
  private Player player;
  private PlayerPair pair = new PlayerPair(timmie,lassie);
  
  public void testAssignments () {
    player = timmie;
    player = lassie;
    // lassie = player;
    // timmie = pair.getPlayer(1);
    // timmie = (TimidPlayer)player;
  }
}
