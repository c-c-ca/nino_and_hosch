package nim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Dialog for initializing a game.
 */
public class ConfigurationDialog extends JDialog {

  private Frame top;
  private NimInterface.NimController controller;
  
  /**
   * Create a new dialog, with the specified frame parent and controller.
   */
  public ConfigurationDialog (Frame parent, NimInterface.NimController controller) {
    super(parent, "Configure Game", true);
    this.top = parent;
    this.controller = controller;
    final ConfigurationPanel panel = new ConfigurationPanel();
    this.getContentPane().add(panel);
    
    addWindowListener(new WindowAdapter () {
      public void windowClosing (WindowEvent e) {
        panel.okAction.actionPerformed(new ActionEvent(ConfigurationDialog.this,
                                                       ActionEvent.ACTION_PERFORMED,
                                                       "Window Closed"));
        e.getWindow().dispose();
      }
    });

    pack();
    setLocationRelativeTo(parent);
    setVisible(true);
  }

  /**
   * A panel for initializing a game.
   */
  private class ConfigurationPanel extends JPanel {
    
    private final static int DEFAULT_STICKS = 10; // default number of sticks
    private JTextField sticksField; // field for specifying the number of sticks
                                    // to start with
    private ActionListener okAction; // listener for the OK button
    private ActionListener playerSelection; // listener for the player selection
                                            // buttons
    private boolean userPlaysFirst; // user plays first
    
    /**
     * Create a new ConfigurationPanel.
     */
    public ConfigurationPanel () {
    
      okAction =
        new ActionListener () {
          public void actionPerformed (ActionEvent e) {
            controller.setStartingSticks(startingSticks());
            controller.setUserPlaysFirst(userPlaysFirst);
            ConfigurationDialog.this.dispose();
          }
      };
    
      playerSelection =
        new ActionListener () {
          public void actionPerformed (ActionEvent e) {
            userPlaysFirst = e.getActionCommand().equals("user");
          }
      };
    
      setLayout(new GridLayout(3,1));
      add(sticksPanel());
      add(firstPlayerPanel());
      add(okPanel());
    }

    /**
     * Panel containing a text filed for entering the number of sticks to start with.
     */
    private JPanel sticksPanel () {
      JLabel sticksPrompt = new JLabel("Number of sticks to start with: ");
      sticksField = new JTextField(5);
      JPanel innerPanel = new JPanel();
      innerPanel.add(sticksPrompt);
      innerPanel.add(sticksField);
      innerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
      JPanel sticksPanel = new JPanel();
      sticksPanel.add(innerPanel);
      sticksPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
      return sticksPanel;
    }

    /**
     * Panel for selecting whether user or computer plays first, using radio
     * buttons.
     */
    private JPanel firstPlayerPanel () {
      
      JRadioButton user = new JRadioButton("User plays first");
      user.setActionCommand("user");
      user.setSelected(true);
      user.addActionListener(playerSelection);
      userPlaysFirst = true;
      
      JRadioButton computer = new JRadioButton("Computer plays first");
      computer.setActionCommand("computer");
      computer.setSelected(false);
      computer.addActionListener(playerSelection);
      
      ButtonGroup group = new ButtonGroup();
      group.add(user);
      group.add(computer);
      
      JPanel firstPlayerPanel = new JPanel();
      firstPlayerPanel.add(user);
      firstPlayerPanel.add(computer);
      
      return firstPlayerPanel;
    }

    /**
     * Panle containing the "OK" button.
     */
    private JPanel okPanel () {
      JPanel okPanel = new JPanel();
      JButton ok = new JButton("OK");
      ok.addActionListener(okAction);
      okPanel.add(ok);
      return okPanel;
    }

    /**
     * The number of sticks to start with, as entered by the user. If the
     * user has not entered a meaningful integer, DEFAULT_STICKS is returned.
     */
    private int startingSticks () {
      int number;
      try {
        number = Integer.valueOf(sticksField.getText()).intValue();
      } catch (NumberFormatException e) {
        number = DEFAULT_STICKS;
      }
      return number > 0 ? number : DEFAULT_STICKS;
    }
  }
}
