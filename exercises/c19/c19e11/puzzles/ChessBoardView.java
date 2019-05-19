package puzzles;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.border.*;

import nhUtilities.containers.List;

public class ChessBoardView extends JPanel {

    private final static int SIZE = 600;
    private final static int OFF_SET = SIZE/10;
    private final static Color LINE_COLOR = Color.black;
    private final static Color FILL_COLOR = new Color(66,220,244);
    private final static int DELAY = 100;

    private List<Queen> board;
    private int size, width;

    public ChessBoardView (List<Queen> board, int solutionNumber,
                           int totalSolutions) {
        this.board = board;
        this.size = board.size();
        this.width = (SIZE-2*OFF_SET)/size;

        setBorder(new TitledBorder(
            LineBorder.createBlackLineBorder(),
            "Solution " + (solutionNumber+1) + " of " + totalSolutions,
            TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
            new Font(Font.MONOSPACED, Font.BOLD, SIZE/25)));
    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(LINE_COLOR);
        int pos = OFF_SET;
        for (int i = 0; i <= size; i = i+1) {
            g.drawLine(pos,OFF_SET,pos,SIZE-OFF_SET);
            g.drawLine(OFF_SET,pos,SIZE-OFF_SET,pos);
            pos = pos + width;
        }
        g.setColor(FILL_COLOR);
        for (int i = 1; i <= size; i = i+1) {
            int j = (i%2 == 0) ? 1 : 2;
            for (; j <= size; j = j+2) {
                int x, y;
                x = (j-1) * width + 1 + OFF_SET;
                y = (i-1) * width + 1 + OFF_SET;
                g.fillRect(x,y,width-1,width-1);
            }
        }

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

        for (Queen q : board) {
            int x, y;
            x = (q.column()-1) * width + 1 + OFF_SET;
            y = (q.row()-1) * width + 1 + OFF_SET;
            g.drawImage(img,x+imgOff,y+imgOff,null);
        }
    }

    public Dimension getPreferredSize () {
        return new Dimension(SIZE,SIZE);
    }

    public Dimension getMinimumSize () {
        return getPreferredSize();
    }
}
