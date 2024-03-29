// Name: Yufei Lu
// USC NetID: yufeilu
// CS 455 PA1
// Spring 2021

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   private final int width;
   private final int heightInPixels;   // = barHeight(constant) * scale(fixed value in pixels)
   private final int bottom;
   private final int left;
   private final Color color;
   private static final Color STRING_COLOR = Color.BLACK;

   private final String label;


   
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale).
  
      @param bottom  location of the bottom bar
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label under the bar
   */
   public Bar(int bottom, int left, int width, int barHeight, 
              double scale, Color color, String label) {
                 this.width = width;
                 this.heightInPixels = (int) (barHeight * scale);
                 this.bottom = bottom;
                 this.left = left;
                 this.color = color;
                 this.label = label;                 
   }
   
   /**
      Draw the labeled bar.
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {

      // draw the label
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(label, context);
      int widthOfLabel = (int) labelBounds.getWidth();
      int heightOfLabel = (int) labelBounds.getHeight();
      int labelLeft = left + width / 2 - widthOfLabel / 2;
      int labelBottom = bottom + heightOfLabel;
      g2.setColor(STRING_COLOR);
      g2.drawString(label, labelLeft, labelBottom);

      //draw the bar
      g2.setColor(color);
      int upper = bottom - heightInPixels;
      Rectangle bar = new Rectangle(left, upper, width, heightInPixels);
      g2.fill(bar);
   }

}
