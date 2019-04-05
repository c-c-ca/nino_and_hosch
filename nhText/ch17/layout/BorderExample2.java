package ch17.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple exercise example with a 5-button BorderLayout.
 */
public class BorderExample2 {
  
  public static void main (String [] args) {
    BorderFrame frame = new BorderFrame("BorderLayout");
    frame.setSize(300,200);
    frame.setVisible(true);
  }
  
  private static class BorderFrame extends JFrame {
    
    public BorderFrame (String title) {
      super(title);
      this.getContentPane().add(new JButton("NORTH"),BorderLayout.NORTH);
      this.getContentPane().add(new JButton("SOUTH"),BorderLayout.SOUTH);
      this.getContentPane().add(new JButton("EAST"),BorderLayout.EAST);
      this.getContentPane().add(new JButton("WEST"),BorderLayout.WEST);
      this.getContentPane().add(new JButton("CENTER"),BorderLayout.CENTER);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  }
}
