package ch17.threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import nhUtilities.utilities.Control;

/**
 * A simple exercise example illustrating delays in the event dispatching thread.
 */
public class DelayExample {
  
  public static void main (String [] args) {
    ButtonCounter frame = new ButtonCounter("DelayExample");
    frame.pack(); // size the frame according to the preferred sizes of its components
    frame.setVisible(true);
  }

  private static class ButtonCounter extends JFrame {
    
    public ButtonCounter (String title) {
      super(title);
      Container pane = this.getContentPane();
      pane.add(new ButtonPanel(0),BorderLayout.WEST);
      pane.add(new ButtonPanel(0),BorderLayout.EAST);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  
    private class ButtonPanel extends JPanel {
      
      private int count;
      private JTextField countField;
      private int delay;
 
      /**
       * delay is number of seconds action listener will sleep before returning
       */
      public ButtonPanel (int delay) {
        this.delay = delay;
        this.count = 0;
        this.countField = new JTextField(10);
        countField.setEnabled(false);    // user can't key into the text field
        countField.setText(""+0);
        countField.setBorder(BorderFactory.createCompoundBorder(
                                 BorderFactory.createEmptyBorder(5,10,10,10),
                                 BorderFactory.createEtchedBorder()));
        JButton button = new JButton("Press Me");
        button.addActionListener(new ActionListener() {
          public void actionPerformed (ActionEvent e) {
            count = count+1;
            countField.setText(""+count);
            // "ButtonPanel.this" refers to the ButtonPanel this inner class is
            // contained in.
            if (ButtonPanel.this.delay > 0)
              Control.sleep(ButtonPanel.this.delay);
          }
        });
        button.setBorder(BorderFactory.createCompoundBorder(
                             BorderFactory.createEmptyBorder(10,10,5,10),
                             BorderFactory.createRaisedBevelBorder()));
        this.setLayout(new GridLayout(2,1));
        this.add(button);
        this.add(countField);
      }
    }
    
  }
}
