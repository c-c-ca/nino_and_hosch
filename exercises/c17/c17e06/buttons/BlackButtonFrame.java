package buttons;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BlackButtonFrame extends JFrame {

    private static final int BTN_WIDTH = 100;
    private static final int BTN_HEIGHT = 100;

    public BlackButtonFrame () {
        super("Black Button Frame"); // name JFrame

        // create button
        JButton button = new JButton();
        button.setBackground(Color.black);
        Dimension size = new Dimension(BTN_WIDTH,BTN_HEIGHT);
        button.setPreferredSize(size);
        button.setMinimumSize(size);


        // create ActionListener for button
        button.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    JButton b = (JButton)(e.getSource());
                    Dimension oldSize = b.getSize();
                    int height = (int) oldSize.getHeight();
                    int width = (int) oldSize.getWidth();
                    Dimension newSize = new Dimension(width-2,height-2);
                    b.setPreferredSize(newSize);
                    b.setMinimumSize(newSize);
                    b.invalidate();
                    b.getParent().validate();
                }
            });

        // create JPanel with GridBagLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());

        // configure GridBagConstraints
        GridBagConstraints constraints =
            new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(50,50,50,50);

        // add button and button panel to JFrame
        buttonPanel.add(button,constraints);
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
            });
    }

    public static void main (String[] argv) {
        BlackButtonFrame f = new BlackButtonFrame();
        f.pack();
        f.setVisible(true);
    }
}
