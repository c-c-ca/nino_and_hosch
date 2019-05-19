package counters;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class DollarsAndCentsCounterView extends JFrame implements Observer {

    // Named constants:

    private final static int FIELD_WIDTH = 5;
    private final static String BALANCE_LABEL = "Current balance:";
    private final static String DEPOSIT_BTN_LABEL = "Deposit";
    private final static String WITHDRAW_BTN_LABEL = "Withdraw";
    private final static String DOLLAR_LABEL = "Dollars:";
    private final static String CENT_LABEL = "Cents:";
    private final static String RESET_BTN_LABEL = "Reset";
    private static final String ERR_MSG =
        "Invalid input. Please enter an integer in decimal format.";

    // Private components:

    private CounterController controller;
    private JTextField balanceField;
    private JTextField dollarField;
    private JTextField centField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton resetButton;

    // Constructors:

    public DollarsAndCentsCounterView (DollarsAndCentsCounter model) {
        super("Dollars and Cents Counter");

        balanceField = new JTextField(FIELD_WIDTH);
        balanceField.setEditable(false);
        dollarField = new JTextField(FIELD_WIDTH);
        centField = new JTextField(FIELD_WIDTH);

        depositButton = new JButton(DEPOSIT_BTN_LABEL);
        withdrawButton = new JButton(WITHDRAW_BTN_LABEL);
        resetButton = new JButton(RESET_BTN_LABEL);

        this.getContentPane().add(
            toPanel(new JLabel(BALANCE_LABEL), balanceField),
                    BorderLayout.NORTH);
        this.getContentPane().add(
            toPanel(new JLabel(DOLLAR_LABEL), dollarField,
                    new JLabel(CENT_LABEL), centField),
                    BorderLayout.CENTER);
        this.getContentPane().add(
            toPanel(depositButton,withdrawButton,resetButton),
                    BorderLayout.SOUTH);

        model.addObserver(this);
        controller = new CounterController(model);
        this.update(model,null);
    }

    public void update (Observable model, Object arg) {
        dollarField.setText("");
        centField.setText("");
        int dollars = ((DollarsAndCentsCounter)model).dollars();
        int cents = ((DollarsAndCentsCounter)model).cents();
        String leadingZero = (cents < 10) ? "0" : "";
        String amountStr = "$" + String.valueOf(dollars) +
                           "." + leadingZero + String.valueOf(cents);
        balanceField.setText(amountStr);
    }

    private JPanel toPanel (Component... components) {
        JPanel p = new JPanel();
        for (Component c : components)
            p.add(c);
        return p;
    }

    // Inner class:

    private class CounterController implements ActionListener {

        // Private components:

        private DollarsAndCentsCounter target;

        // Constructors:

        public CounterController (DollarsAndCentsCounter target) {
            this.target = target;
            DollarsAndCentsCounterView.this.depositButton.
                addActionListener(this);
            DollarsAndCentsCounterView.this.withdrawButton.
                addActionListener(this);
            DollarsAndCentsCounterView.this.resetButton.
                addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == depositButton ||
                e.getSource() == withdrawButton) {
                int dollars = readAmount(dollarField);
                int cents = readAmount(centField);
                if (e.getSource() == depositButton)
                    target.add(dollars,cents);
                else
                    target.subtract(dollars,cents);
            } else
                target.reset();
        }

        private int readAmount (JTextField field) {
            try {
                return Integer.parseInt(field.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(field, ERR_MSG,
                "Important", JOptionPane.INFORMATION_MESSAGE);
                field.setText("");
                return 0;
            }

        }
    }

    public static void main (String[] argv) {
        DollarsAndCentsCounter counter = new DollarsAndCentsCounter();
        DollarsAndCentsCounterView ui =
            new DollarsAndCentsCounterView(counter);
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
