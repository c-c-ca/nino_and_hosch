package textFields;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TextFieldFrame extends JFrame {

    // Named constants:

    private static final int FIELD_WIDTH = 10;

    // Private components:

    private JTextField textField;

    // Constructors:

    public TextFieldFrame () {
        super("Text Field Frame");
        textField = new JTextField(FIELD_WIDTH);
        JButton button = new JButton("Enter");
        button.addActionListener(
            new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    System.out.println(textField.getText());
                    textField.setText("");
                }
            });
        JPanel textPanel = new JPanel();
        textPanel.add(textField);
        textPanel.add(button);
        this.add(textPanel, BorderLayout.CENTER);

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
        JFrame f = new TextFieldFrame();
        f.pack();
        f.setVisible(true);
    }
}
