package switches;

import java.awt.*;
import javax.swing.*;

public class OnOffButton extends JButton {

    public OnOffButton (String label) {
        super(label);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
    }

    public Dimension getPreferredSize () {
        // make the width 100 pixels, height 100
        return new Dimension(100,100);
    }

    public Dimension getMinimumSize () {
        return this.getPreferredSize();
    }
}
