import java.util.ArrayList;

public class BookshelfTester {

   public static void main(String[] args) {
      constructorsTester();

   }

   /**
    * test the two constructors and toString method in Bookshelf class
    */
   private static void constructorsTester() {
      Bookshelf bookshelf = new Bookshelf();
      System.out.println("The bookshelf [exp:] :" + bookshelf.toString());

      ArrayList<Integer> books = new ArrayList<Integer>();
      Bookshelf bookshelf1 = new Bookshelf(books);
      System.out.println("The bookshelf [exp:] :" + bookshelf1.toString());

      books.add(1);
      Bookshelf bookshelf2 = new Bookshelf(books);
      System.out.println("The bookshelf [exp:[1]] :" + bookshelf2.toString());

      books.add(2);
      books.add(5);
      books.add(9);
      Bookshelf bookshelf3 = new Bookshelf(books);
      System.out.println("The bookshelf [exp:[1, 2, 5, 9]] :" + bookshelf3.toString());
   }

}
