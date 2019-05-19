package trafficSimulation;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class TrafficSignalView extends JFrame implements Observer {

    // Named constants:

    private final static String NS_LABEL = "North-South";
    private final static String EW_LABEL = "East-West";
    private final static String BTN_LABEL = "Change";

    // Private components:

    private TSController controller;
    private TrafficLightGraphic nsDisplay;
    private TrafficLightGraphic ewDisplay;
    private JButton button;

    // Constructors:

    public TrafficSignalView (Intersection model) {
        super("Traffic Signal View");

        add(lightPanel(),BorderLayout.NORTH);

        button = new JButton(BTN_LABEL);
        add(buttonPanel(),BorderLayout.SOUTH);

        model.addObserver(this);
        controller = new TSController(model);
        update(model,null);
    }

    public void update (Observable model, Object arg) {
        Intersection intersection = (Intersection)model;
        nsDisplay.setLight(intersection.northSouth());
        ewDisplay.setLight(intersection.eastWest());
    }

    private JPanel lightPanel () {
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints constraints =
            new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);

        nsDisplay = new TrafficLightGraphic();
        p.add(new JLabel(NS_LABEL),constraints);
        p.add(nsDisplay,constraints);

        constraints.gridx = 1;
        ewDisplay = new TrafficLightGraphic();
        p.add(new JLabel(EW_LABEL),constraints);
        p.add(ewDisplay,constraints);
        return p;
    }

    private JPanel buttonPanel () {
        JPanel p = new JPanel();
        button = new JButton(BTN_LABEL);
        p.add(button);
        return p;
    }

    // Inner classes:

    private class TrafficLightGraphic extends JPanel {

        // Named constants:

        private final static int NUM_LIGHTS = 3;
        private final static int GREEN = 0;
        private final static int YELLOW = 1;
        private final static int RED = 2;
        private final static int BORDER_THICKNESS = 5;

        // Private components:

        private LightPanel[] lights = new LightPanel[NUM_LIGHTS];

        public TrafficLightGraphic () {
            setLayout(new GridBagLayout());
            GridBagConstraints constraints =
                new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = GridBagConstraints.RELATIVE;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.insets = new Insets(5,5,5,5);
            lights[GREEN] = new LightPanel(Color.green);
            lights[YELLOW] = new LightPanel(Color.yellow);
            lights[RED] = new LightPanel(Color.red);
            add(lights[GREEN],constraints);
            add(lights[YELLOW],constraints);
            add(lights[RED],constraints);
            setBorder(new LineBorder(getForeground(),BORDER_THICKNESS));
        }

        public void setLight (int light) {
            for (LightPanel p : lights)
                p.turnOff();
            if (light == TrafficSignal.GREEN)
                lights[GREEN].turnOn();
            else if (light == TrafficSignal.YELLOW)
                lights[YELLOW].turnOn();
            else
                lights[RED].turnOn();
            for (LightPanel p : lights)
                p.repaint();
        }

        public void paintComponent (Graphics g) {
            super.paintComponent(g);
            g.setColor(getForeground());
            g.fillRect(0,0,getPreferredSize().width,
                       getPreferredSize().height);
        }
    }

    private class LightPanel extends JPanel {

        private static final int DIAMETER = 25;
        private static final int OFFSET = DIAMETER/5;
        private static final int SIZE = 2 * OFFSET + DIAMETER;

        private Color color;
        private boolean isOn;

        public LightPanel (Color color) {
            this.color = color;
            this.isOn = false;
        }

        public void turnOn () {
            isOn = true;
        }

        public void turnOff () {
            isOn = false;
        }

        public void paintComponent (Graphics g) {
            super.paintComponent(g);
            g.setColor(getForeground());
            g.fillRect(0,0,SIZE,SIZE);
            g.drawOval(OFFSET,OFFSET,DIAMETER,DIAMETER);
            if (isOn)
                g.setColor(color);
            else
                g.setColor(getBackground());
            g.fillOval(OFFSET,OFFSET,DIAMETER,DIAMETER);
        }

        public Dimension getPreferredSize() {
            return new Dimension(SIZE,SIZE);
        }

        public Dimension getMinimumSize() {
            return getPreferredSize();
        }
    }

    private class TSController implements ActionListener {

        private Intersection target;

        public TSController (Intersection target) {
            this.target = target;
            TrafficSignalView.this.button.addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            target.change();
        }
    }

    public static void main (String[] argv) {
        TrafficSignalView ui =
            new TrafficSignalView(
                new Intersection());
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
