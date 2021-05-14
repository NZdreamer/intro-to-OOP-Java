// Name: Yufei Lu
// USC NetID: yufeilu
// CS 455 PA3
// Spring 2021

import org.junit.Assert;
import org.junit.Test;

public class MineFieldTester {

   public static void main(String[] args) {
      MineField mineFiled = new MineField(3, 3, 2);
      mineFiled.populateMineField(1, 1);
      accessorsTest();

   }

   @Test
   public static void accessorsTest() {
      MineField mineFiled = new MineField(new boolean[10][10]);
      System.out.println(mineFiled.numCols()+ " " + mineFiled.numRows());
      System.out.println(mineFiled.toString());
      Assert.assertEquals(true, mineFiled.inRange(0, 0));
      Assert.assertEquals(true, mineFiled.inRange(4, 6));
      Assert.assertEquals(true, mineFiled.inRange(9, 9));
      Assert.assertEquals(false, mineFiled.inRange(10, 0));

      MineField mineField2 = new MineField(5, 5, 6);
      System.out.println(mineField2.numCols() + " " + mineField2.numRows());
      System.out.println(mineField2.toString());
      Assert.assertEquals(true, mineField2.inRange(0, 0));
      Assert.assertEquals(false, mineField2.inRange(4, 6));

   }
}
