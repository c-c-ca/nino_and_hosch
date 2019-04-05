package studentSurvey;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The student survey.
 */
public class StudentSurvey {
  
  public static void main (String[] args) {
    JFrame top = new JFrame("Student survey");
    top.getContentPane().add(new StudentSurveyPanel(), BorderLayout.CENTER);
    top.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          Window w = e.getWindow();
          w.dispose();
        }
        public void windowClosed(WindowEvent e) {
          System.exit(0);
        }
    });
    top.pack();
    top.setVisible(true);
  }
