package figures;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class CircleView extends JFrame {

    // Named constants:

    private final static int FIELD_WIDTH = 3;
    private final static String INPUT_LABEL = "Enter radius:";
    private static final String ERR_MSG =
        "Invalid input. Please enter a non-negative integer.";

    // Private components:

    private JTextField inputField;
    private GraphicView display;

    // Constructors:

    public CircleView (Circle model) {
        super("Circle View");

        inputField = new JTextField(FIELD_WIDTH);
        inputField.setText(String.valueOf(model.radius()));
        display = new GraphicView();

        this.getContentPane().add(
            toPanel(new JLabel(INPUT_LABEL),inputField),
                    BorderLayout.NORTH);
        this.getContentPane().add(display, BorderLayout.SOUTH);

        model.addObserver(display);
        display.update(model,null);
        new CircleController(model);
    }

    private JPanel toPanel (Component... components) {
        JPanel p = new JPanel();
        for (Component c : components)
            p.add(c);
        return p;
    }

    // Inner classes:

    private class GraphicView extends JPanel implements Observer {

        // Named constants:

        private final static int OFFSET = 10;

        // Private components:

        int diameter;
        int size;

        public void GraphicView () {
            this.diameter = 0;
            this.size = 0;
        }

        public void update (Observable model, Object arg) {
            diameter = 2 * ((Circle)model).radius();
            size = diameter + 2 * OFFSET;
            repaint();
            Container w = getTopLevelAncestor();
            if (w instanceof Window)
                ((Window)w).pack();
        }

        public void paintComponent (Graphics g) {
            super.paintComponent(g);
            g.setColor(getForeground());
            g.drawOval(OFFSET,OFFSET,diameter,diameter);
        }

        public Dimension getPreferredSize() {
            return new Dimension(size,size);
        }

        public Dimension getMinimumSize() {
            return getPreferredSize();
        }
    }

    private class CircleController implements ActionListener {

        // Private components:

        private Circle target;

        // Constructors:

        public CircleController (Circle target) {
            this.target = target;
            CircleView.this.inputField.addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            try {
                int radius = Integer.parseInt(inputField.getText());
                if (radius < 0)
                    throw new NumberFormatException();
                target.setRadius(radius);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(inputField, ERR_MSG,
                "Important", JOptionPane.INFORMATION_MESSAGE);
                inputField.setText("");
            }
        }
    }

    public static void main (String[] argv) {
        CircleView ui = new CircleView(new Circle(100));
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
