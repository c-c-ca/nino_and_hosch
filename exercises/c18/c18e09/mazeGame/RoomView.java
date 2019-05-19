package mazeGame;

import java.awt.*;
import javax.swing.*;

public class RoomView extends JPanel {

    private final static int OFFSET = 5;
    private final static int WIDTH = 100;
    private final static int HEIGHT = 75;

    private boolean isOccupied;

    public RoomView (Room model) {
        isOccupied = false;
    }

    public void enter () {
        isOccupied = true;
        repaint();
    }

    public void exit () {
        isOccupied = false;
        repaint();
    }

    public void paintComponent (Graphics g) {
            super.paintComponent(g);
            if (!isOccupied)
                g.setColor(getBackground());
            else
                g.setColor(getForeground());
            g.fillRect(OFFSET,OFFSET,WIDTH,HEIGHT);
            g.setColor(getForeground());
            g.drawRect(OFFSET,OFFSET,WIDTH,HEIGHT);
        }

        public Dimension getPreferredSize() {
            return new Dimension(WIDTH+2*OFFSET,HEIGHT+2*OFFSET);
        }

        public Dimension getMinimumSize() {
            return getPreferredSize();
        }

}
