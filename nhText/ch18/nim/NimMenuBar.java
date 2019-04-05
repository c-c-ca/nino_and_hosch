package nim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A menu bar for the nim game.
 */
public class NimMenuBar extends JMenuBar {
  
  private NimInterface.NimController controller;
 
  /**
   * Create a new menu bar, talking to the specified controller.
   */
  public NimMenuBar (NimInterface.NimController controller) {
    this.controller = controller;
    add(new GameMenu());
    add(new HelpMenu());
  }

  /**
   * A menu for playing/quitting the game.
   */
  private class GameMenu extends JMenu {

    /**
     * Create a new Game menu.
     */
    public GameMenu () {
      super("Game");
      JMenuItem newGame = new JMenuItem("New Game");
      newGame.addActionListener(initializer);
      this.add(newGame);
      this.addSeparator();
      JMenuItem exit = new JMenuItem("Exit");
      exit.addActionListener(exiter);
      this.add(exit);
    }
  }

  /**
   * A menu for help options.
   */
  private class HelpMenu extends JMenu { 

    /**
     * Create a new help menu. (Currently, we off no help.)
     */
    public HelpMenu () {
      super("Help");
    }
  }

  /**
   * Handles the "exit" menu option.
   */
  private ActionListener exiter =
    new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      Window top = (Window)NimMenuBar.this.getTopLevelAncestor();
      top.dispatchEvent(new WindowEvent(top,WindowEvent.WINDOW_CLOSING));
    }
  };

  /**
   * Handles the "new game" menu option.
   */
  private ActionListener initializer =
    new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      controller.initializeGame();
    }
  };
}

