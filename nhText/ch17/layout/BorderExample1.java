package ch17.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple exercise example with a 1-button BorderLayout.
 */
public class BorderExample1 {
  
  public static void main (String [] args) {
    OneButtonFrame frame = new OneButtonFrame("BorderLayout");
    frame.setSize(300,200);
    frame.setVisible(true);
  }
  
  private static class OneButtonFrame extends JFrame {
    
    public OneButtonFrame (String title) {
      super(title);
      JButton button = new JButton("Press Me");
      button.setForeground(Color.white);
      button.setBackground(Color.black);
      this.getContentPane().add(button,BorderLayout.NORTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  }
}
