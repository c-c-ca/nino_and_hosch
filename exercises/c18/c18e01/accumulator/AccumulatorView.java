package accumulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

class AccumulatorView extends JFrame implements Observer {

    // Named constants:

    private static final int FIELD_SIZE = 5;
    private static final String MAIN_LABEL = "Enter a number:";
    private static final String INPUT_LABEL = "Input:";
    private static final String OUTPUT_LABEL = "Output:";
    private static final String ADD_LABEL = "+";
    private static final String RESET_LABEL = "Reset";
    private static final String ERR_MSG =
        "Invalid input. Please enter an integer in decimal format.";

    // Private components:

    private AccumulatorController controller;
    private JTextField input;
    private JTextField output;
    private JButton addButton;
    private JButton resetButton;

    // Constructors:

    /**
     * Create an AccumulatorView instance.
     */
    public AccumulatorView (Accumulator model) {
        super("Accumulator");

        input = new JTextField(FIELD_SIZE);
        output = new JTextField(FIELD_SIZE);
        output.setEditable(false);

        addButton = new JButton(ADD_LABEL);
        resetButton = new JButton(RESET_LABEL);

        this.getContentPane().add(
            toPanel(new JLabel(MAIN_LABEL)),BorderLayout.NORTH);
        this.getContentPane().add(
            toPanel(new JLabel(INPUT_LABEL),input,
                    new JLabel(OUTPUT_LABEL),output),BorderLayout.CENTER);
        this.getContentPane().add(
            toPanel(addButton,resetButton),BorderLayout.SOUTH);

        this.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    e.getWindow().dispose();
                }
                public void windowClosed(WindowEvent e) {
                    System.exit(0);
                }
            });

        model.addObserver(this);
        controller = new AccumulatorController(model);
        update(model,null);
    }

    private JPanel toPanel (Component... components) {
        JPanel panel = new JPanel();
        for (Component c : components)
            panel.add(c);
        return panel;
    }

    public void update (Observable model, Object arg) {
        int sum = ((Accumulator)model).sum();
        output.setText(String.valueOf(sum));
        if (sum == 0)
            input.setText("");

    }

    // Inner class:

    private class AccumulatorController implements ActionListener {

        private Accumulator model;

        public AccumulatorController (Accumulator model) {
            this.model = model;
            AccumulatorView.this.addButton.addActionListener(this);
            AccumulatorView.this.resetButton.addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == AccumulatorView.this.addButton)
                try {
                    model.setSummand(
                        Integer.parseInt(input.getText()));
                    model.add();
                } catch (NumberFormatException ex) {
                    Component frame = (Component)(e.getSource());
                    JOptionPane.showMessageDialog(frame, ERR_MSG,
                    "Important", JOptionPane.INFORMATION_MESSAGE);
                }
            else
                model.reset();
        }
    }

    public static void main (String[] argv) {
        AccumulatorView ui =
            new AccumulatorView(new Accumulator());
        ui.pack();
        ui.setVisible(true);
    }
}
