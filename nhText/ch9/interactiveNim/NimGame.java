package ch9.interactiveNim;

/**
 * The game of simple nim. User observes game
 * played by means of a simple text based interface.
 */
public class NimGame {
  public static void main (String[] argv) {
    (new NimTUI()).start();
  }
}
