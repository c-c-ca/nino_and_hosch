package accumulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SimpleAccumulatorUI extends JFrame {

    // Named constants:

    private static final int TEXT_FIELD_WIDTH = 5;
    private static final String MAIN_LABEL = "Enter a number:";
    private static final String INPUT_LABEL = "Input:";
    private static final String OUTPUT_LABEL = "Output:";
    private static final String ADD_LABEL = "+";
    private static final String RESET_LABEL = "Reset";
    private static final String ERR_MSG =
        "Invalid input. Please enter an integer in decimal format.";

    // Private components:

    private Accumulator accumulator;
    private JTextField input;
    private JTextField output;
    private JButton addButton;
    private JButton resetButton;

    // Constructors:

    public SimpleAccumulatorUI(Accumulator accumulator) {
        super("Accumulator");
        this.accumulator = accumulator;

        input = new JTextField(TEXT_FIELD_WIDTH);
        output = new JTextField(TEXT_FIELD_WIDTH);
        output.setEditable(false);

        addButton = new JButton(ADD_LABEL);
        addButton.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    try {
                        accumulator.setSummand(
                            Integer.parseInt(input.getText()));
                        accumulator.add();
                        output.setText(
                            Integer.toString(accumulator.sum()));
                    } catch (NumberFormatException ex) {
                        Component frame = (Component)(e.getSource());
                        JOptionPane.showMessageDialog(frame, ERR_MSG,
                        "Important", JOptionPane.INFORMATION_MESSAGE);
                        input.setText("");
                    }
                }
            });

        resetButton = new JButton(RESET_LABEL);
        resetButton.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    accumulator.reset();
                    input.setText("");
                    output.setText("");
                }
            });

        this.getContentPane().add(
            toPanel(new JLabel(MAIN_LABEL)),BorderLayout.NORTH);
        this.getContentPane().add(
            toPanel(new JLabel(INPUT_LABEL),input,
                    new JLabel(OUTPUT_LABEL),output),BorderLayout.CENTER);
        this.getContentPane().add(
            toPanel(addButton,resetButton),BorderLayout.SOUTH);

        this.addWindowListener(
            new WindowAdapter () {
                public void windowClosing(WindowEvent e) {
                    Window w = e.getWindow();
                    w.dispose();
                }
                public void windowClosed(WindowEvent e) {
                    System.exit(0);
                }
            });
    }

    private JPanel toPanel (Component... components) {
        JPanel panel = new JPanel();
        for (Component c : components) {
            panel.add(c);
        }
        return panel;
    }

    public static void main (String[] argv) {
        SimpleAccumulatorUI ui =
            new SimpleAccumulatorUI(new Accumulator());
        ui.pack();
        ui.setVisible(true);
    }

}
