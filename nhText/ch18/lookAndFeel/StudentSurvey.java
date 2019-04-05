package ch18.lookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class StudentSurvey {
  
  public static void main (String[] args) {
//    try {
//        UIManager.setLookAndFeel(
//               "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//    } catch (Exception e) { }
    JFrame top = new JFrame("Student survey");
    top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    top.getContentPane().add(new StudentSurveyPanel(), BorderLayout.CENTER);
    top.pack();
    top.setVisible(true);
  }
}

class StudentSurveyPanel extends JPanel {
  
  public StudentSurveyPanel () {
    setLayout(new BorderLayout());
    add(agePanel(), BorderLayout.NORTH);
    add(collegePanel(), BorderLayout.WEST);
    add(sexPanel(), BorderLayout.CENTER);
    add(miscPanel(), BorderLayout.EAST);
    add(finishedPanel(), BorderLayout.SOUTH);
    this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
  }
  
  private JPanel finishedPanel () {
    JButton button = new JButton("Finished!");
    button.setBorder(BorderFactory.createRaisedBevelBorder());
    button.addActionListener(
                             new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(StudentSurveyPanel.this,
                                      "Are you finished?",
                                      "Important", JOptionPane.QUESTION_MESSAGE);
      }
    });
    JPanel finishedPanel = new JPanel();
    finishedPanel.add(button);
    return finishedPanel;
  }
  
  private JPanel agePanel () {
    JLabel agePrompt = new JLabel("Age: ");
    JTextField ageField = new JTextField(10);
    JPanel innerPanel = new JPanel();
    innerPanel.add(agePrompt);
    innerPanel.add(ageField);
    innerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    JPanel agePanel = new JPanel();
    agePanel.add(innerPanel);
    agePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    return agePanel;
  }
  
  private JPanel collegePanel () {
    JComboBox collegeChooser = new JComboBox();
    collegeChooser.addItem("Sciences");
    collegeChooser.addItem("Liberal Arts");
    collegeChooser.addItem("Engineering");
    collegeChooser.addItem("Fine Arts");
    JPanel collegePanel = new JPanel();
    collegePanel.add(collegeChooser);
    collegePanel.setBorder(BorderFactory.createTitledBorder(
                                                            BorderFactory.createLineBorder(Color.red),"College"));
    return collegePanel;
  }
  
  private JPanel miscPanel () {
    JCheckBox worksBox = new JCheckBox("Work");
    JCheckBox hasKidsBox = new JCheckBox("Work");
    JCheckBox ownsPCBox = new JCheckBox("Work");
    JPanel miscPanel = new JPanel();
    miscPanel.setLayout(new GridLayout(3,1));
    miscPanel.add(worksBox);
    miscPanel.add(hasKidsBox);
    miscPanel.add(ownsPCBox);
    miscPanel.setBorder(BorderFactory.createTitledBorder(
                                                         BorderFactory.createLineBorder(Color.red),"Misc",TitledBorder.RIGHT,
                                                         TitledBorder.TOP));
    return miscPanel;
  }
  
  private JPanel sexPanel () {
    JRadioButton maleButton = new JRadioButton("Male");
    JRadioButton femaleButton = new JRadioButton("Female");
    femaleButton.setSelected(true);
    ButtonGroup sexGroup = new ButtonGroup();
    sexGroup.add(maleButton);
    sexGroup.add(femaleButton);
    JPanel innerPanel = new JPanel();
    innerPanel.setLayout(new GridLayout(2,1));
    innerPanel.add(maleButton);
    innerPanel.add(femaleButton);
    JPanel sexPanel = new JPanel();
    sexPanel.add(innerPanel);
    return sexPanel;
  }
}

