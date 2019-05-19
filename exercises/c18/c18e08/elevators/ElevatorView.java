package elevators;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

class ElevatorView extends JFrame implements Observer {

    private final static int FLOORS = 5;
    private final static int FIELD_WIDTH = 3;
    private final static String FLOOR_LABEL = "Floor:";
    private final static String DIRECTION_LABEL = "Direction:";
    private final static String BTN_LABEL = "Change";
    private final static String UP_TXT = "Up";
    private final static String DOWN_TXT = "Down";
    private final static int INSET = 5;

    private JTextField floorField;
    private JTextField directionField;
    private JButton button;

    public ElevatorView (Elevator model) {
        super("Elevator View");

        floorField = new JTextField(FIELD_WIDTH);
        directionField = new JTextField(FIELD_WIDTH);
        floorField.setEditable(false);
        directionField.setEditable(false);

        button = new JButton(BTN_LABEL);

        add(displayPanel(), BorderLayout.NORTH);
        add(toPanel(button), BorderLayout.SOUTH);

        new ElevatorController(model);
        model.addObserver(this);
        update(model,null);
    }

    public void update (Observable model, Object arg) {
        Elevator e = (Elevator)model;
        floorField.setText(String.valueOf(e.floor()));
        String directionStr;
        if (e.goingUp())
            directionStr = UP_TXT;
        else
            directionStr = DOWN_TXT;
        directionField.setText(directionStr);
    }

    private JPanel displayPanel () {
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints =
            new GridBagConstraints();
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(INSET,INSET,INSET,INSET);

        displayPanel.add(new JLabel(FLOOR_LABEL),constraints);
        displayPanel.add(floorField,constraints);

        constraints.gridy = 1;
        displayPanel.add(new JLabel(DIRECTION_LABEL),constraints);
        displayPanel.add(directionField,constraints);
        return displayPanel;
    }

    private JPanel toPanel (Component... components) {
        JPanel p = new JPanel();
        for (Component c : components)
            p.add(c);
        return p;
    }

    private class ElevatorController implements ActionListener {

        private Elevator target;

        public ElevatorController (Elevator target) {
            this.target = target;
            ElevatorView.this.button.addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            target.move();
        }
    }

    public static void main (String[] argv) {
        ElevatorView ui = new ElevatorView(new Elevator(FLOORS));
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
