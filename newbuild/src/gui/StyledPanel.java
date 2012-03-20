package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * A panel used for conducting multi-parameter searches.
 * @author Brad Johnson
 *
 */
public class StyledPanel extends DisplayPanel {

    /**
     * ID.
     */
    private static final long serialVersionUID = 8285086013085907050L;


    /**
     * A styled panel for organizing objects within this panel.
     * @author Brad Johnson baj231 11044123
     *
     */
    class InnerPanel extends JPanel {

        /**
         * ID.
         */
        private static final long serialVersionUID = -4518288020085720362L;

        public InnerPanel() {

            this.setLayout(new FlowLayout(FlowLayout.RIGHT));
            this.setBackground(Color.WHITE);
            this.setOpaque(false);

        }

    }

    @Override
    /**
     * Draw background on the panel.
     * @param g the default graphics on the panel
     */
    public void paintComponent(final Graphics g) {

        Image background = null;

        /*
         * Load the image for the background
         */
        background = (new ImageIcon(getClass().getResource("innerbg.jpg"))).getImage();


        super.paintComponent(g);

        /*
         * Paint the background
         */
        if (background != null) {

            g.drawImage(background, 0, 0, background.getWidth(this),
                    background.getHeight(this), this);

        }

    }

}
