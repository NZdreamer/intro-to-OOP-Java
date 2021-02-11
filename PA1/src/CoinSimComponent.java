// Name: Yufei Lu
// USC NetID: yufeilu
// CS 455 PA1
// Spring 2021

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * CoinSimComponent class
 *
 * extends JComponent class, this component draws three bars.
 */
public class CoinSimComponent extends JComponent {

    private static final Color TWOHEADS_COLOR = Color.RED;
    private static final Color HEADTAIL_COLOR = Color.GREEN;
    private static final Color TWOTAILS_COLOR = Color.BLUE;

    private static final int VERTICAL_BUFFER = 30;
    private static final int BAR_WIDTH = 80;

    private final CoinTossSimulator simulator;

    /**
     * Constructor of the CoinSimComponent with the coinTossSimulator
     * @param simulator the coin toss simulator
     */
    public CoinSimComponent(CoinTossSimulator simulator) {
        this.simulator = simulator;
    }


    /**
     * Do some calculations and draw three bars,
     * when the window size changed by the user, this method refresh,
     * and the heights and positions of the bars change with it.
     * @param g the graphics context
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int windowWidth = getWidth();
        int windowHeight = getHeight();

        int x = windowWidth / 4;
        int left1 = x - BAR_WIDTH / 2;
        int left2 = 2 * x - BAR_WIDTH / 2;
        int left3 = 3 * x - BAR_WIDTH / 2;
        int bottom = windowHeight - VERTICAL_BUFFER;
        double scale = (double) (windowHeight - 2 * VERTICAL_BUFFER) / 100;

        int trialsNum = simulator.getNumTrials();
        int twoHeadsNum = simulator.getTwoHeads();
        int twoTailsNum = simulator.getTwoTails();
        int headTailNum = simulator.getHeadTails();

        int twoHeadsPercent = (int) Math.round((double) twoHeadsNum * 100 / trialsNum);
        int twoTailsPercent = (int) Math.round((double) twoTailsNum * 100 / trialsNum);
        int headTailPercent = (int) Math.round((double) headTailNum * 100 / trialsNum);

        String twoHeadsLabel = "Two Heads: " + twoHeadsNum + "(" + twoHeadsPercent + "%)";
        String twoTailsLabel = "Two Tails: " + twoTailsNum + "(" + twoTailsPercent + "%)";
        String headTailLabel = "A Head and a Tail" + headTailNum + "(" + headTailPercent + "%)";

        Bar twoHeadsBar = new Bar(bottom, left1, BAR_WIDTH, twoHeadsPercent, scale, TWOHEADS_COLOR, twoHeadsLabel);
        Bar headTailBar = new Bar(bottom, left2, BAR_WIDTH, headTailPercent, scale, HEADTAIL_COLOR, headTailLabel);
        Bar twoTailsBar = new Bar(bottom, left3, BAR_WIDTH, twoTailsPercent, scale, TWOTAILS_COLOR, twoTailsLabel);
        twoHeadsBar.draw(g2);
        headTailBar.draw(g2);
        twoTailsBar.draw(g2);
    }


}
