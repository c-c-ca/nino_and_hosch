package nim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The simple nim game. The game is played by two players with a pile of sticks.
 * Each player in turn removes one, two, or three sticks from the pile. The player
 * removing the last stick loses.
 */
public class NimGame {
  
  private final static String title = "Simple Nim";
  
  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event-dispatching thread.
   */
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame top = new JFrame(title);
    NimInterface nimGUI = new NimInterface();
    top.getContentPane().add(nimGUI, BorderLayout.CENTER);
    top.setJMenuBar(new NimMenuBar(nimGUI.controller()));
    top.addWindowListener(new WindowAdapter() {
      public void windowClosing (WindowEvent e) {
        e.getWindow().dispose();
      }
      public void windowClosed (WindowEvent e) {
        System.exit(0);
      }
    });
    top.pack();
    top.setVisible(true);  
  }
  
  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }  
}
