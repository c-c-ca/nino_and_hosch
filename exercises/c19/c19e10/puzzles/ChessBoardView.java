package puzzles;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

import nhUtilities.containers.List;
import nhUtilities.containers.DefaultList;
import java.util.*;

public class ChessBoardView extends JPanel implements Observer {

    private final static int SIZE = 800;
    private final static int OFF_SET = SIZE/10;
    private final static Color LINE_COLOR = Color.black;
    private final static Color FILL_COLOR = new Color(66,220,244);
    private final static int DELAY = 100;

    private List<Queen> rows;
    private List<List<Queen>> steps;
    private int currentStep;
    private int r, width;
    private Timer timer;

    public ChessBoardView (PuzzleSolver model) {
        rows = null;
        steps = new DefaultList<List<Queen>>();
        currentStep = 0;
        model.addObserver(this);

        timer = new Timer(DELAY,
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    repaint();
                }
            });
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        if (currentStep == 0) {
            r = steps.get(steps.size()-1).size();
            width = (SIZE-OFF_SET*2)/r;
        }
        g.setColor(LINE_COLOR);
        int pos = OFF_SET;
        for (int i = 0; i <= r; i = i+1) {
            g.drawLine(pos,OFF_SET,pos,SIZE-OFF_SET);
            g.drawLine(OFF_SET,pos,SIZE-OFF_SET,pos);
            pos = pos + width;
        }
        g.setColor(FILL_COLOR);
        for (int i = 1; i <= r; i = i+1) {
            int j = (i%2 == 0) ? 1 : 2;
            for (; j <= r; j = j+2) {
                int x, y;
                x = (j-1) * width + 1 + OFF_SET;
                y = (i-1) * width + 1 + OFF_SET;
                g.fillRect(x,y,width-1,width-1);
            }
        }

        rows = steps.get(currentStep);
        currentStep = currentStep + 1;

        Image img = null;
        int imgOff = 0;
        try {
            img = ImageIO.read(new File("puzzles/queen.png"));
            ImageIcon icon = new ImageIcon(img);
            int imgSize = width/10*9;
            imgOff = width/20;
            img = icon.getImage().getScaledInstance(
                  imgSize,imgSize,Image.SCALE_DEFAULT);
        } catch (IOException e) {
            System.out.println(e);
        }

        for (Queen q : rows) {
            int x, y;
            x = (q.column()-1) * width + 1 + OFF_SET;
            y = (q.row()-1) * width + 1 + OFF_SET;
            g.drawImage(img,x+imgOff,y+imgOff,null);
        }

        if (currentStep == steps.size())
            timer.stop();
    }

    public void update (Observable model, Object arg) {
        steps.add((List<Queen>)arg);
    }

    public void runAnimation () {
        timer.start();
    }

    public Dimension getPreferredSize () {
        return new Dimension(SIZE,SIZE);
    }

    public Dimension getMinimumSize () {
        return getPreferredSize();
    }
}
