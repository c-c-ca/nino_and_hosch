package counters;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class CounterView extends JFrame implements Observer {

    // Named constants:

    private final static int FIELD_WIDTH = 4;
    private final static String INC_BTN_LABEL = "+";
    private final static String RESET_BTN_LABEL = "Reset";
    private final static int MAXVAL = 10;

    // Private components:

    private CounterController controller;
    private JTextField tf;
    private JButton incButton;
    private JButton resetButton;

    // Constructors:

    public CounterView (Counter model) {
        super("Counter");

        tf = new JTextField(FIELD_WIDTH);
        tf.setEditable(false);
        incButton = new JButton(INC_BTN_LABEL);
        resetButton = new JButton(RESET_BTN_LABEL);

        this.getContentPane().add(
            toPanel(tf), BorderLayout.NORTH);
        this.getContentPane().add(
            toPanel(incButton,resetButton), BorderLayout.SOUTH);

        model.addObserver(this);
        controller = new CounterController(model);
        this.update(model,null);
    }

    public void update (Observable model, Object arg) {
        int count = ((Counter)model).count();
        tf.setText(String.valueOf(count));
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

        private Counter target;

        // Constructors:

        public CounterController (Counter target) {
            this.target = target;
            CounterView.this.incButton.addActionListener(this);
            CounterView.this.resetButton.addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == incButton)
                target.increment();
            else
                target.reset();
        }
    }

    public static void main (String[] argv) {
        Counter counter = new Counter();
        Counter modCounter = new ModulusCounter(MAXVAL);
        CounterView ui = new CounterView(modCounter);
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
