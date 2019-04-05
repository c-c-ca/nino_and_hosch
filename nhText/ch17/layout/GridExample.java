package ch17.layout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple exercise example with a GridLayout.
 */
public class GridExample {
  
  public static void main (String [] args) {
    GridFrame frame = new GridFrame("GridLayout(3,2)");
    frame.setSize(300,200);
    frame.setVisible(true);
  }
  
  private static class GridFrame extends JFrame {
    
    public GridFrame (String title) {
      super(title);
      Container pane = this.getContentPane();
      // Create a 3 row x 2 column grid
      pane.setLayout(new GridLayout(3,2));
      // add 10 buttons to the grid
      for (int i = 1; i <= 6; i = i+1)
        pane.add(new JButton(""+i));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  }
}
