package counters;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class BaseballCounterView extends JFrame implements Observer {

    // Named constants:

    private final static int FIELD_WIDTH = 1;
    private final static String BALL_LABEL = "Balls:";
    private final static String STRIKE_LABEL = "Strikes:";
    private final static String BALL_BTN_LABEL = "Ball";
    private final static String STRIKE_BTN_LABEL = "Strike";
    private final static String RESET_BTN_LABEL = "Reset";

    // Private components:

    private CounterController controller;
    private JTextField ballField;
    private JTextField strikeField;
    private JButton ballButton;
    private JButton strikeButton;
    private JButton resetButton;

    // Constructors:

    public BaseballCounterView (BaseballCounter model) {
        super("Baseball Counter");

        ballField = new JTextField(FIELD_WIDTH);
        ballField.setEditable(false);
        strikeField = new JTextField(FIELD_WIDTH);
        strikeField.setEditable(false);

        ballButton = new JButton(BALL_BTN_LABEL);
        strikeButton = new JButton(STRIKE_BTN_LABEL);
        resetButton = new JButton(RESET_BTN_LABEL);

        this.getContentPane().add(
            toPanel(new JLabel(BALL_LABEL), ballField,
                    new JLabel(STRIKE_LABEL), strikeField),
                    BorderLayout.NORTH);
        this.getContentPane().add(
            toPanel(ballButton,strikeButton,resetButton),
                    BorderLayout.SOUTH);

        model.addObserver(this);
        controller = new CounterController(model);
        this.update(model,null);
    }

    public void update (Observable model, Object arg) {
        int balls = ((BaseballCounter)model).balls();
        int strikes = ((BaseballCounter)model).strikes();
        ballField.setText(String.valueOf(balls));
        strikeField.setText(String.valueOf(strikes));
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

        private BaseballCounter target;

        // Constructors:

        public CounterController (BaseballCounter target) {
            this.target = target;
            BaseballCounterView.this.ballButton.
                addActionListener(this);
            BaseballCounterView.this.strikeButton.
                addActionListener(this);
            BaseballCounterView.this.resetButton.
                addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == ballButton)
                target.incrementBalls();
            else if (e.getSource() == strikeButton)
                target.incrementStrikes();
            else
                target.reset();
        }
    }

    public static void main (String[] argv) {
        BaseballCounter counter = new BaseballCounter();
        BaseballCounterView ui = new BaseballCounterView(counter);
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
