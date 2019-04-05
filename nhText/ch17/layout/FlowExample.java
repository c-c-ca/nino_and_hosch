package ch17.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple exercise example with a FlowLayout.
 */
public class FlowExample {
  
  public static void main (String [] args) {
    FlowFrame frame = new FlowFrame("FlowLayout");
    frame.setSize(300,200);
    frame.setVisible(true);
  }
  
  private static class FlowFrame extends JFrame {
    
    public FlowFrame (String title) {
      super(title);
      Container pane = this.getContentPane();
      pane.setLayout(new FlowLayout());
      for (int i = 1; i <= 10; i = i+1)
        pane.add(new JButton(""+i));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  }
}
