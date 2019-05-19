package textFields;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TextFieldFrame
    extends JFrame {

    private static final int FIELD_WIDTH = 10;

    private JTextField textField;

    public TextFieldFrame () {
        super("Text Field Frame");
        textField = new JTextField(FIELD_WIDTH);
        textField.addActionListener(
            new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    JTextField textField = (JTextField)(e.getSource());
                    System.out.println(textField.getText());
                    textField.setText("");
                }
            });
        JPanel textPanel = new JPanel();
        textPanel.add(textField);
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
            }
        );
    }

    public static void main (String[] argv) {
        JFrame f = new TextFieldFrame();
        f.pack();
        f.setVisible(true);
    }
}
