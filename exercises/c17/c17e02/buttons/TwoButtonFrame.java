package buttons;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TwoButtonFrame extends JFrame {

    // Inner classes:

    private class ButtonListener
        implements ActionListener {
        public void actionPerformed (
            ActionEvent e) {
            String button =
                (e.getSource() == b1) ? "one" : "two";
            System.out.println(
                "Button " + button + " pressed");
        }
    }

    // Private components:

    private JButton b1;
    private JButton b2;

    // Constructors:

    public TwoButtonFrame () {
        super("Two Button Frame");
        b1 = new JButton("One");
        b2 = new JButton("Two");
        ButtonListener listener =
            new ButtonListener();
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        this.getContentPane().add(
            buttonPanel, BorderLayout.CENTER);

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

    public static void main (String[] argv) {
        TwoButtonFrame f = new TwoButtonFrame();
        f.pack();
        f.setVisible(true);
    }
}
