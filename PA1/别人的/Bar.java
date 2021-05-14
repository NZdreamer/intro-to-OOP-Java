// Name:
// USC NetID:
// CS 455 PA1
// Spring 2021

// we included the import statements for you

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;


/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * <p>
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 */
public class Bar {
    private final int width;
    private final int heightInPixels;
    private final int bottom;
    private final int left;
    private final Color color;
    private static final Color STRING_COLOR = Color.BLACK;
    private final String label;

    private Dimension frameSize;



    /**
     * Creates a labeled bar.  You give the height of the bar in application
     * units (e.g., population of a particular state), and then a scale for how
     * tall to display it on the screen (parameter scale).
     *
     * @param bottom    location of the bottom bar    =================== vb
     * @param left      location of the left side of the bar ============ m*x-w/2 (m = 1,2,3)
     * @param width     width of the bar (in pixels)  =================== w
     * @param barHeight height of the bar in application units ========== n
     * @param scale     how many pixels per application unit ============ s
     * @param color     the color of the bar
     * @param label     the label under the bar
     */
    public Bar(int bottom, int left, int width, int barHeight,
               double scale, Color color, String label) {
        this.heightInPixels = (int) (barHeight * scale);

        this.bottom = (int) (bottom - barHeight * scale);
        this.width = width;
        this.left = left - (width/2);

        this.color = color;
        this.label = label;
    }

    /**
     * Draw the labeled bar.
     *
     * @param g2 the graphics context
     */
    public void draw(Graphics2D g2) {
        String shownLabel = label;
        Font font = g2.getFont();
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D labelBounds = font.getStringBounds(label, context);
        int widthOfLabel = (int) labelBounds.getWidth();
        int heightOfLabel = (int) labelBounds.getHeight();
        Rectangle rectangle = new Rectangle(left,bottom ,width,heightInPixels);
        g2.setColor(color);
        g2.fill(rectangle);
        g2.setColor(STRING_COLOR);
        g2.drawString(shownLabel,left+(width/2)-(widthOfLabel/2),bottom+heightInPixels+heightOfLabel);
    }
}
