package mazeGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;

public class MazeView extends JFrame implements Observer {

    private static final int NUM_ROOMS = 5;
    private static final int NUM_BTNS = 4;
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private static final String[] BTN_LABELS =
        {"Up","Down","Left","Right"};

    private Maze maze;

    private RoomView[] rooms = new RoomView[NUM_ROOMS];
    private JButton[] buttons = new JButton[NUM_BTNS];

    public MazeView () {
        super("Maze View");

        Explorer explorer = new Explorer();
        maze = new Maze(explorer);
        add(mazeDisplay(), BorderLayout.NORTH);
        add(buttonPanel(), BorderLayout.SOUTH);

        new ExplorerController(explorer);
        explorer.addObserver(this);
        update(explorer,null);
    }

    public JPanel mazeDisplay () {
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints constraints =
            new GridBagConstraints();
        int[] xCoords = new int[]{0,1,1,1,2};
        int[] yCoords = new int[]{0,0,1,2,1};
        for (int i = 0; i < NUM_ROOMS; i = i+1) {
            rooms[i] = new RoomView(maze.getRoom(i));
            constraints.gridx = xCoords[i];
            constraints.gridy = yCoords[i];
            p.add(rooms[i], constraints);
        }
        return p;
    }

    public JPanel buttonPanel () {
        JPanel p = new JPanel();
        for (int i = 0; i < NUM_BTNS; i = i+1) {
            buttons[i] = new JButton(BTN_LABELS[i]);
            p.add(buttons[i]);
        }
        return p;
    }

    public void update (Observable model, Object arg) {
        Explorer explorer = (Explorer)model;
        for (int i = 0; i < Maze.NUM_ROOMS; i = i+1)
            if (maze.getRoom(i) == explorer.location())
                rooms[i].enter();
            else
                rooms[i].exit();
    }

    private class ExplorerController
        implements ActionListener {

        private Explorer target;

        public ExplorerController (Explorer target) {
            this.target = target;
            for (JButton b : MazeView.this.buttons)
                b.addActionListener(this);
        }

        public void actionPerformed (ActionEvent e) {
            JButton b = (JButton)(e.getSource());
            if (b == buttons[UP])
                target.setDirection(Explorer.NORTH);
            else if (b == buttons[DOWN])
                target.setDirection(Explorer.SOUTH);
            else if (b == buttons[RIGHT])
                target.setDirection(Explorer.EAST);
            else
                target.setDirection(Explorer.WEST);
            target.move();
        }
    }

    public static void main (String[] argv) {
        MazeView ui = new MazeView();
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
