package ch9.interactiveNim;

/**
 * Models an object that needs to be informed when a InteractivePlayer
 * is about to make a play.
 */
public interface PlayerObserver {

  /**
   * The specified InteractivePlayer is making a play.
   */
  public void update (InteractivePlayer player);

}
