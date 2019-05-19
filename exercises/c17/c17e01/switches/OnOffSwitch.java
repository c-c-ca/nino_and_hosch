package switches;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OnOffSwitch extends JFrame {

    public OnOffSwitch () {
        super("On/Off Switch"); // frame title

        // create button and set its colors
        OnOffButton button = new OnOffButton("On/Off");
        button.setForeground(Color.black);
        button.setBackground(Color.white);
        button.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                Component source = (Component)e.getSource();
                Color oldForeground = source.getForeground();
                source.setForeground(source.getBackground());
                source.setBackground(oldForeground);
            }
        });

        // use FlowLayoaut and add button to JFrame's
        // content pane:
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(
            button, BorderLayout.CENTER);

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
}
