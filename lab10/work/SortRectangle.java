import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.awt.*;
import java.util.*;

public class SortRectangle {


   public static void main(String[] args) {
      Rectangle rec1 = new Rectangle(2, 3);
      Rectangle rec2 = new Rectangle(3, 4);
      Rectangle rec3 = new Rectangle(1, 3);
      Rectangle[] rec = {rec1, rec2, rec3};
      sortIncrByArea(rec);
      System.out.println(rec);
   }

   public static void sortIncrByArea(Rectangle[] rec) {

      Arrays.sort(rec, new RectangleComparator());
      Set<Integer> s = new HashSet<Integer>();

   }



   public static Map<String, Boolean> wordsMoreThanOnce(ArrayList<String> words) {
      HashMap<String, Boolean> map = new HashMap();
      int[] nums = {1, 2};
      boolean b = nums.length == 0;
      for (String word : words) {
         if (!map.containsKey(word)) {
            map.put(word, false);
         } else {
            map.put(word, true);
         }
      }
      return map;
   }

   public static int findLast(int[] nums, int target) {
      LinkedList<Integer> list = new LinkedList<>();
      for (int i = 0; i < nums.length; i++) {
         list.add(nums[i]);
      }
      return findLastHelper(list, target);
   }

   private static int findLastHelper(LinkedList<Integer> list, int target) {
      if (list.size() == 0) {
         return -1;
      }
      if (list.getLast() == target) {
         return list.size() - 1;
      }
      else {
         list.removeLast();
         return findLastHelper(list, target);
      }
   }


}
