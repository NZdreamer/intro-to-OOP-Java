// Name: Yufei Lu
// USC NetID: yufeilu
// CSCI455 PA2
// Spring 2021

import java.util.ArrayList;

public class TestAssert {
   public static void main(String[] args) {
      ArrayList<Integer> books1 = new ArrayList<Integer>();
      books1.add(0);
      books1.add(1);
      Bookshelf bookshelf1 = new Bookshelf(books1);

      ArrayList<Integer> books2 = new ArrayList<>();
      books2.add(0);
      books2.add(-1);
      Bookshelf bookshelf2 = new Bookshelf(books2);
   }
}
