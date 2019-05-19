package accumulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleAccumulatorUI extends JFrame {

    // Named constants:

    private int TEXT_FIELD_WIDTH = 15;

    // Private components:

    private JLabel label;
    private JTextField textField;
    private JButton button;

    public SimpleAccumulatorUI(Accumulator accumulator) {
        super("Accumulator");

        label = new JLabel("Enter a number:");
        textField = new JTextField(TEXT_FIELD_WIDTH);
        button = new JButton("+");

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
