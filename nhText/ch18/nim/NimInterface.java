package nim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * A user interface for the simple nim game. Observes a Game.
 * (The Game is created by the controller as part of the initialization
 * process.)
 */
public class NimInterface extends JPanel implements Observer {
  
  private NimController controller; // the controller for this interface
  private ReportPanel reportPanel; // panel for reporting sticks left
  private PlayerPanel userPanel; // panel for reporting user moves
  private PlayerPanel computerPanel; // panel for reporting computer moves
  private JButton button1; // user button for taking 1 stick
  private JButton button2; // user button for taking 2 sticks
  private JButton button3; // user button for taking 3 sticks
  private InteractivePlayer user; // the user
  private AutomatedPlayer computer; // the computer
    
  /**
   * Build a user interface for the simple nim game.
   */
  public NimInterface() {
    // Create Players
    user = new InteractivePlayer("User");
    computer = new AutomatedPlayer("Computer");
    
    // Create the controller
    controller = new NimController();
    
    // Create the display
    setLayout(new BorderLayout());
    reportPanel = new ReportPanel();
    add(reportPanel, BorderLayout.NORTH);
    userPanel = new PlayerPanel(user);
    add(userPanel, BorderLayout.EAST);
    computerPanel = new PlayerPanel(computer);
    add(computerPanel, BorderLayout.WEST);
    add(buttonPanel(), BorderLayout.SOUTH);
  }
  
  /**
   * buttonPanel displays three buttons for user input.
   */
  private JPanel buttonPanel () {
    
    button1 = new JButton("Take 1");
    button1.setActionCommand("1");
    button1.addActionListener(controller);
    
    button2 = new JButton("Take 2");
    button2.setActionCommand("2");
    button2.addActionListener(controller);
    
    button3 = new JButton("Take 3");
    button3.setActionCommand("3");
    button3.addActionListener(controller);
    
    JPanel buttonPanel = new JPanel();
    enableButtons(false);
    buttonPanel.add(button1);
    buttonPanel.add(button2);
    buttonPanel.add(button3);
    return buttonPanel;
  }

  /**
   * The controller for this interface.
   */
  public NimController controller () {
    return controller;
  }
 
  /**
   * A play has been made in the Game. Update the display.
   */
  public void update (Observable game, Object obj) {
    Game g = (Game)game;
    reportPanel.reportSticksLeft(g.sticksLeft());
    if (g.gameOver()) {
      reportWinner(g.winner());
      reset();
    }
  }

  /**
   * Reset the display.
   */
  private void reset () {
    reportPanel.reset();
    userPanel.reset();
    computerPanel.reset();
  }
  
  /**
   * The game is over, report the winner.
   */
  private void reportWinner (Player winner) {
    JOptionPane.showMessageDialog(this.getTopLevelAncestor(),
                                  winner.name() + " wins!",
                                  "Game Over",
                                  JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Enable/disable the user input buttons.
   */
  private void enableButtons (boolean enabled) {
    button1.setEnabled(enabled);
    button2.setEnabled(enabled);
    button3.setEnabled(enabled);
  }
 
  /**
   * Highlight or unhighlight user player panel.
   */
  private void highLightUser (boolean highLight) {
    userPanel.highLight(highLight);
  }
  
  /**
   * Highlight or unhighlight computer player panel.
   */
  private void highLightComputer (boolean highLight) {
    computerPanel.highLight(highLight);
  }

  /**
   * ReportPanel displays the number of sticks remaining in the pile.
   */
  private class ReportPanel extends JPanel {
    
    private JLabel report; // used to report the number of sticks remaining
    // the initial message:
    private final static String START_TEXT = "The game of Simple Nim";
    // the report message:
    private final static String REPORT_TAG = "Sticks left in pile: ";
    /**
     * Create a ReportPanel containinghte initial message.
     */
    public ReportPanel () {
     report = new JLabel(START_TEXT);
     add(report);
    }

    /**
     * Report that the specified number of sticks remian in the pile.
     */
    public void reportSticksLeft (int number) {
      this.report.setText(REPORT_TAG + number);
    }

    /**
     * Reset the message to the initial message.
     */
    public void reset () {
      this.report.setText(START_TEXT);
    }
  } // end of class ReportPanel

  /**
   * PlayerPanel displays a Player's move.
   */
  private class PlayerPanel extends JPanel {
    
    private JTextField playerField; // displays number of sticks taken on Player's
                                    // most recent turn.
    private Color background; // background color for un-highlighted text field.
    private Color foreground; // foreground color for unhighlighted text field.

    /**
     * Create a panel displaying the moves of the specified Player.
     */
    public PlayerPanel (Player player) {
      JLabel playerLabel = new JLabel(player.name() + " takes: ");
      playerField = new JTextField(5);
      playerField.setEditable(false);
      background = playerField.getBackground();
      foreground = playerField.getForeground();
      JPanel innerPanel = new JPanel();
      innerPanel.add(playerLabel);
      innerPanel.add(playerField);
      innerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
      add(innerPanel);
      setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      
      // Create a PlayerView observing the Player and reporting in this panel
      new PlayerView(player, playerField);
    }

    /**
     * Reset this PlayerPanel.
     */
    public void reset () {
      playerField.setText("");
      highLight(false);
    }

    /**
     * Highlight this PlayerPanel if the argument is true; otherwise, set it
     * to "normal." (A PlayerPanel is highlighted to indicate that it is that
     * Player's turn.)
     */
    public void highLight (boolean highLight) {
      if (highLight) {
        playerField.setText("");
        playerField.setForeground(background);
        playerField.setBackground(foreground);
      } else {
        playerField.setForeground(foreground);
        playerField.setBackground(background);
      }        
    }
  } // end of class PlayerPanel

  /**
   * A view for a single nim Player. Observes a Player.
   */
  private class PlayerView implements Observer {
    
    private JTextField view; // the field in which to report the Player's move

    /**
     * Create a Player view for the specified Player, reporting in the speciifed
     * text field.
     */
    public PlayerView (Player player, JTextField view) {
      ((Observable)player).addObserver(this);
      this.view = view;
    }

    /**
     * The player has made a move.
     */
    public void update (Observable player, Object obj) {
      final int numberTaken = ((Player)player).numberTaken();
      view.setText(numberTaken + "");
    }
  } // end of class PlayerView

  /**
   * Controller for the game. The controller listens to the buttons for user
   * input, and commands the game to play a round when the user presses a
   * button.
   * 
   * The Controller also offers initialization function. (Perhaps this should
   * not be in this object.)
   */
  public class NimController implements ActionListener {

    private final static int DELAY = 2000; // delay (millieseconds) in computer's move
    private int sticksToStart; // number of sticks to start with
    private boolean userFirst; // user plays first
    private Game game; // the Game being controlled

    /**
     * Create a new NimController.
     */
    public NimController () {
      // these are actually set as part of the initialization
      sticksToStart = 0;
      userFirst = true;
    }
    
    /**
     * Create a new Game as directed by the user.
     */
    public void initializeGame () {
      // configuration dialog sets sticksToStart and userFirst
      new ConfigurationDialog((Frame)NimInterface.this.getTopLevelAncestor(), this);
      
      NimInterface.this.reportPanel.reportSticksLeft(sticksToStart);
      if (userFirst)
        game = new Game(user, computer, sticksToStart);
      else
        game = new Game(computer, user, sticksToStart);
      game.addObserver(NimInterface.this);
      
      // "wait" for fist user action
      if (userFirst) {
        NimInterface.this.enableButtons(true);
        NimInterface.this.highLightUser(true);
      } else {
        NimInterface.this.highLightComputer(true);
        computerPlay();
      }
    }

    /**
     * The user has pressed a button makign a play.
     */
    public void actionPerformed (ActionEvent e) {
      String command = e.getActionCommand();
      int number = Integer.valueOf(command).intValue();
      user.setNumberToTake(number);
      userPlay();
      computerPlay();
    }

    /**
     * User takes a turn.
     */
    private void userPlay () {
      NimInterface.this.enableButtons(false);
      NimInterface.this.highLightUser(false);
      game.play();
      if (!game.gameOver())
        NimInterface.this.highLightComputer(true);
    }

    /**
     * Computer taks a turn.
     */
    private void computerPlay () {
      // So that the computer's play doesn't happen instantaneously after the
      // user's play, the computer's play is scheduled with a timer. The timer
      // waits DELAY milleseconds and fires an action event. Note: just sleeping
      // here will not work, since the display repaints don't happen unitl after
      // the event is handled; i.e., the display changes resulting from the user
      // action are all scheduled and don't take place unitl after all the
      // event handling code has completed.
      javax.swing.Timer computerDelay =
        new javax.swing.Timer(DELAY,
                              new ActionListener () {
        public void actionPerformed (ActionEvent e) {
          game.play();
          NimInterface.this.highLightComputer(false);
          if (!game.gameOver()) {
            NimInterface.this.highLightUser(true);
            NimInterface.this.enableButtons(true);
          }
        }
      });
      computerDelay.setRepeats(false);
      computerDelay.start();
    }      
 
    /**
     * Set the initial number of sticks int he game. This should be invoked
     * by the configuration dialog.
     */
    void setStartingSticks (int number) {
      this.sticksToStart = number;
    }
    
    /**
     * Set whether user or computer plays first. This should be invoked
     * by the configuration dialog.
     */
    void setUserPlaysFirst (boolean userFirst) {
      this.userFirst = userFirst;
    }
  }
}
