package locks;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class CombinationLockView extends JFrame implements Observer {

    // Named constants:

    private final static int FIELD_WIDTH = 3;
    private final static int COMBINATION = 123;
    private final static String INPUT_LABEL = "Enter a digit (0-9):";
    private final static String STATUS_TXT = "Lock open? ";
    private final static String LOCKED_STATUS = "NO";
    private final static String UNLOCKED_STATUS = "YES";
    private final static String ENTER_LABEL = "Enter";
    private final static String RESET_LABEL = "Reset";
    private static final String ERR_MSG =
        "Invalid input. Please enter a digit (0-9).";

    // Private components:

    private CLController controller;
    private JTextField inputField;
    private JButton enterButton;
    private JButton resetButton;
    private JLabel label;

    // Constructors:

    public CombinationLockView (CombinationLock model) {
        super("Combination Lock");

        inputField = new JTextField(FIELD_WIDTH);
        enterButton = new JButton(ENTER_LABEL);
        resetButton = new JButton(RESET_LABEL);
        label = new JLabel();

        this.getContentPane().add(
            toPanel(label), BorderLayout.NORTH);
        this.getContentPane().add(
            toPanel(new JLabel(INPUT_LABEL), inputField),
                    BorderLayout.CENTER);
        this.getContentPane().add(
            toPanel(enterButton, resetButton),
                    BorderLayout.SOUTH);

        model.addObserver(this);
        controller = new CLController(model);
        this.update(model,null);
    }

    public void update (Observable model, Object arg) {
        inputField.setText("");
        String status;
        if (((CombinationLock)model).isOpen())
            status = UNLOCKED_STATUS;
        else
            status = LOCKED_STATUS;
        label.setText(STATUS_TXT + status);
    }

    private JPanel toPanel (Component... components) {
        JPanel p = new JPanel();
        for (Component c : components)
            p.add(c);
        return p;
    }

    // Inner class:

    private class CLController implements ActionListener {

        // Private components:

        private CombinationLock target;

        // Constructors:

        public CLController (CombinationLock target) {
            this.target = target;
            CombinationLockView.this.enterButton.
                addActionListener(this);
            CombinationLockView.this.resetButton.
                addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == enterButton)
                try {
                    int digit = Integer.parseInt(inputField.getText());
                    if (digit < 0 || digit > 9)
                        throw new NumberFormatException();
                    target.enter(digit);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(inputField, ERR_MSG,
                    "Important", JOptionPane.INFORMATION_MESSAGE);
                    inputField.setText("");
                }
            else
                target.close();
        }
    }

    public static void main (String[] argv) {
        CombinationLock lock = new CombinationLock(COMBINATION);
        lock.close();
        CombinationLockView ui = new CombinationLockView(lock);
        ui.addWindowListener(
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    e.getWindow().dispose();
                }
                public void windowClosed (WindowEvent e) {
                    System.exit(0);
                }
            });
        ui.pack();
        ui.setVisible(true);
    }
}
