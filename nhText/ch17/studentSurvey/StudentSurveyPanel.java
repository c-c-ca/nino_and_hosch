package studentSurvey;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

/**
 * A panel for collecting student survey data.
 */
class StudentSurveyPanel extends JPanel {
  
  private JTextField ageField;
  private JComboBox collegeChooser;
  private JCheckBox worksBox;
  private JCheckBox hasKidsBox;
  private JCheckBox ownsPCBox;
  private JRadioButton maleButton;
  private JRadioButton femaleButton;

  /**
   * Create a new panel.
   */
  public StudentSurveyPanel () {
    setLayout(new BorderLayout());
    add(agePanel(), BorderLayout.NORTH);
    add(collegePanel(), BorderLayout.WEST);
    add(sexPanel(), BorderLayout.CENTER);
    add(miscPanel(), BorderLayout.EAST);
    add(finishedPanel(), BorderLayout.SOUTH);
  }

  /**
   * A panel containing the "Finished" button.
   */
  private JPanel finishedPanel () {
    JButton button = new JButton("Finished!");
    button.setBorder(BorderFactory.createRaisedBevelBorder());
    button.addActionListener(new DoneListener());
    JPanel finishedPanel = new JPanel();
    finishedPanel.add(button);
    return finishedPanel;
  }
 
  /**
   * A panel containing a text field for entering age.
   */
  private JPanel agePanel () {
    JLabel agePrompt = new JLabel("Age: ");
    ageField = new JTextField(10);
    ageField.addActionListener(new AgeListener());
    JPanel innerPanel = new JPanel();
    innerPanel.add(agePrompt);
    innerPanel.add(ageField);
    innerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    JPanel agePanel = new JPanel();
    agePanel.add(innerPanel);
    agePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    return agePanel;
  }

  /**
   * A panel containing a combo box for selecting a college.
   */
  private JPanel collegePanel () {
    collegeChooser = new JComboBox();
    collegeChooser.addItem("Sciences");
    collegeChooser.addItem("Liberal Arts");
    collegeChooser.addItem("Engineering");
    collegeChooser.addItem("Fine Arts");
    collegeChooser.addActionListener(new CollegeListener());
    
    JPanel collegePanel = new JPanel();
    collegePanel.add(collegeChooser);
    collegePanel.setBorder(
      BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.red), "College"));
    return collegePanel;
  }

  /**
   * A panel containing miscelaneous check boxes.
   */
  private JPanel miscPanel () {
    MiscellaneousListener miscListener =
      new MiscellaneousListener();
    
    worksBox = new JCheckBox("Work");
    worksBox.addItemListener(miscListener);
    hasKidsBox = new JCheckBox("Have children");
    hasKidsBox.addItemListener(miscListener);
    ownsPCBox = new JCheckBox("Own pc");
    ownsPCBox.addItemListener(miscListener);
    
    JPanel miscPanel = new JPanel();
    miscPanel.setLayout(new GridLayout(3,1));
    miscPanel.add(worksBox);
    miscPanel.add(hasKidsBox);
    miscPanel.add(ownsPCBox);
    miscPanel.setBorder(
      BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.red),
        "Misc",
        TitledBorder.RIGHT,
        TitledBorder.TOP));
    
    return miscPanel;
  }

  /**
   * A panel containing radio buttons for indicating sex.
   */
  private JPanel sexPanel () {
    SexListener sexListener = new SexListener();
    maleButton = new JRadioButton("Male");
    maleButton.setActionCommand("male");
    maleButton.addActionListener(sexListener);
    femaleButton = new JRadioButton("Female");
    femaleButton.setActionCommand("female");
    femaleButton.addActionListener(sexListener);
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

  /**
   * Reset the display.
   */
  private void resetView () {
    ageField.setText("");
    ageField.requestFocus();
    collegeChooser.setSelectedIndex(0);
    worksBox.setSelected(false);
    hasKidsBox.setSelected(false);
    ownsPCBox.setSelected(false);
    femaleButton.setSelected(true);
  }

  /**
   * An object that handles a press of the Finished button.
   */
  private class DoneListener implements ActionListener {
    
    /**
     * The Finished button has been pressed.
     */
    public void actionPerformed (ActionEvent e) {
      System.out.println("Finished button pressed.");
    }
  }
  
  /**
   * An object that handles an entry into the Age text field.
   */
  private class AgeListener implements ActionListener {
    
    /**
     * Text has been entered.
     */
    public void actionPerformed (ActionEvent e) {
      String text = ageField.getText();
      System.out.println("Text \"" + text + "\" entered in Age field.");
    }
  }

  /**
   * An object that handles a selection from the college combo box.
   */
  private class CollegeListener implements ActionListener {
    
    /**
     * An item has been selected.
     */
    public void actionPerformed (ActionEvent e) {
      String college = (String)collegeChooser.getSelectedItem();
      System.out.println("College " + college + " selected.");
    }
  }

  /**
   * An object that handles a check box selection.
   */
  private class MiscellaneousListener implements ItemListener {
    
    /**
     * A box has been selected or deselected.
     */
     public void itemStateChanged (ItemEvent e) {
       JCheckBox box = (JCheckBox)(e.getItemSelectable());
       if (box == worksBox)
         if (e.getStateChange() == ItemEvent.SELECTED)
           System.out.println("Work box selected");
         else
           System.out.println("Work box deselected");
       else if (box == hasKidsBox)
         if (e.getStateChange() == ItemEvent.SELECTED)
           System.out.println("Have children box selected");
         else
           System.out.println("Have children  box deselected");
       else if (box == ownsPCBox)
         if (e.getStateChange() == ItemEvent.SELECTED)
           System.out.println("Own PC box selected");
         else
           System.out.println("Own OC box deselected");
     }
  }

  /**
   * An object that handles the radio buttons.
   */
  private class SexListener implements ActionListener {
    
    /**
     * A radio button has been pressed.
     */
    public void actionPerformed (ActionEvent e) {
      if (e.getActionCommand().equals("male"))
        System.out.println("Male selected.");
      else
        System.out.println("Female selected.");
    }
  }
  
