import java.awt.*;
import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle> {

   @Override
   public int compare(Rectangle r1, Rectangle r2) {
      int area1 = r1.height * r1.width;
      int area2 = r2.height * r2.width;
      if (area1 > area2) {
         return 1;
      }
      else if (area1 < area2) {
         return -1;
      }
      return 0;
   }
}
