// Name: Yufei Lu
// USC NetID: yufeilu
// CSCI455 PA2
// Spring 2021


import java.util.ArrayList;

public class BookshelfTester {

   public static void main(String[] args) {
      System.out.println("Test for constructors:");
      Bookshelf bookshelf = new Bookshelf();
      System.out.println("The bookshelf [exp:[]] : " + bookshelf.toString());

      ArrayList<Integer> books1 = new ArrayList<Integer>();
      Bookshelf bookshelf1 = new Bookshelf(books1);
      System.out.println("The bookshelf [exp:[]] : " + bookshelf1.toString());

      ArrayList<Integer> books2 = new ArrayList<Integer>();
      books2.add(1);
      Bookshelf bookshelf2 = new Bookshelf(books2);
      System.out.println("The bookshelf [exp:[1]] : " + bookshelf2.toString());

      ArrayList<Integer> books3 = new ArrayList<Integer>();
      books3.add(1);
      books3.add(2);
      books3.add(5);
      books3.add(9);
      Bookshelf bookshelf3 = new Bookshelf(books3);
      System.out.println("The bookshelf [exp:[1, 2, 5, 9]] : " + bookshelf3.toString());
      System.out.println();

      addAndRemoveTest(bookshelf1, bookshelf2, bookshelf3);
      restTest(bookshelf1, bookshelf2, bookshelf3);
   }

   /**
    * test for addFront, addLast. removeFront, removeLast methods
    */
   private static void addAndRemoveTest(Bookshelf bookshelf1, Bookshelf bookshelf2, Bookshelf bookshelf3) {
      System.out.println("Test for add and remove:");
      Bookshelf bookshelf = new Bookshelf();
      System.out.println("The bookshelf [exp:[]] : " + bookshelf1.toString());
      bookshelf.addFront(1);
      System.out.println("After addFront(1), the bookshelf [exp:[1]] : " + bookshelf.toString());
      bookshelf.addLast(2);
      System.out.println("After addLast(2), the bookshelf [exp:[1, 2]] : " + bookshelf.toString());
      bookshelf.removeFront();
      System.out.println("After removeFront(), the bookshelf [exp:[2]] : " + bookshelf.toString());
      bookshelf.removeLast();
      System.out.println("After removeLast(), the bookshelf [exp:[]] : " + bookshelf.toString());
      System.out.println();
   }

   /**
    * test for size, getHeight, isSorted methods
    */
   private static void restTest(Bookshelf bookshelf1, Bookshelf bookshelf2, Bookshelf bookshelf3) {
      System.out.println("Test for the rest methods:");

      System.out.println("For the bookshelf [1, 2, 5, 9] ");
      System.out.println("The size of the bookshelf is [exp:4] : " + bookshelf3.size());
      System.out.println("Whether the bookshelf is sorted [exp:true] : " + bookshelf3.isSorted());
      System.out.println("The height of the book in position 0 is [exp:1] : " + bookshelf3.getHeight(0));
      System.out.println("The height of the book in position 2 is [exp:5] : " + bookshelf3.getHeight(2));
      System.out.println("The height of the book in position 3 is [exp:9] : " + bookshelf3.getHeight(3));
      bookshelf3.addLast(6);

      System.out.println("For bookshelf [1, 2, 5, 9, 6] \n" +
            "whether the bookshelf is sorted [exp:false] : " + bookshelf3.isSorted());

      System.out.println("For the bookshelf []");
      System.out.println("The size of the bookshelf is [exp:0] : " + bookshelf1.size());
      System.out.println("Whether the bookshelf is sorted [exp:true] : " + bookshelf1.isSorted());

      System.out.println("For the bookshelf [1]");
      System.out.println("The size of the bookshelf is [exp:1] : " + bookshelf2.size());
      System.out.println("The height of the book in position 0 is [exp:1] : " + bookshelf2.getHeight(0));
      System.out.println("Whether the bookshelf is sorted [exp:true] : " + bookshelf2.isSorted());
      System.out.println();
   }


}
