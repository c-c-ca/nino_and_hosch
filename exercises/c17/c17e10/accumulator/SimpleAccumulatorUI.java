package accumulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class SimpleAccumulatorUI extends JFrame {

    // Named constants:

    private int TEXT_FIELD_WIDTH = 15;

    // Private components:

    private Accumulator accumulator;
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public SimpleAccumulatorUI(Accumulator accumulator) {
        super("Accumulator");
        this.accumulator = accumulator;

        label = new JLabel("Enter a number:");
        
        textField = new JTextField(TEXT_FIELD_WIDTH);
        textField.getDocument().addDocumentListener(
            new DocumentListener() {
                public void insertUpdate (DocumentEvent e) {
                    update();
                }
                public void removeUpdate (DocumentEvent e) {
                    update();
                }
                public void changedUpdate (DocumentEvent e) {}
                private void update () {
                    try {
                        accumulator.setSummand(
                            Integer.parseInt(textField.getText()));
                    } catch (NumberFormatException e) {
                        accumulator.setSummand(0);
                    }
                }
            });

        button = new JButton("+");
        button.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    accumulator.add();
                    textField.setText(
                        Integer.toString(accumulator.sum()));
                }
            });

        this.getContentPane().add(
            toPanel(label),BorderLayout.NORTH);
        this.getContentPane().add(
            toPanel(textField),BorderLayout.CENTER);
        this.getContentPane().add(
            toPanel(button),BorderLayout.SOUTH);

        this.addWindowListener(
            new WindowAdapter () {
                public void windowClosing(WindowEvent e) {
                    Window w = e.getWindow();
                    w.dispose();
                }
                public void windowClosed(WindowEvent e) {
                    System.exit(0);
                }
            }
        );
    }

    private JPanel toPanel (Component c) {
        JPanel panel = new JPanel();
        panel.add(c);
        return panel;
    }

    public static void main (String[] argv) {
        SimpleAccumulatorUI ui =
            new SimpleAccumulatorUI(new Accumulator());
        ui.pack();
        ui.setVisible(true);
    }

}
