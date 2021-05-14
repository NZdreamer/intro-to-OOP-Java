import java.util.ArrayList;

public class BookshelfKeeperTester {
   public static void main(String[] args) {
      BookshelfKeeper bookshelfKeeper = new BookshelfKeeper();
      System.out.println(bookshelfKeeper.toString());
      ArrayList<Integer> books = new ArrayList<>();
      books.add(5);
      Bookshelf bookshelf = new Bookshelf(books);
      BookshelfKeeper bookshelfKeeper1 = new BookshelfKeeper(bookshelf);
      System.out.println(bookshelfKeeper1.toString());
      System.out.println("numbers of books is: " + bookshelfKeeper1.getNumBooks());
      testPickPut(bookshelfKeeper1);
   }

   private static void testPickPut(BookshelfKeeper keeper) {
      int callOnceNums = keeper.putHeight(2);
      System.out.println("After putHeight 2 [exp:[2,5] 1 1]: " + keeper.toString() + " " + callOnceNums + " " + keeper.getTotalOperations());
      int num2 = keeper.putHeight(7);
      System.out.println("After putHeight 7 [exp:[2,5,7] 1 2]: " + keeper.toString() + " " + num2 + " " + keeper.getTotalOperations());
      int num3 = keeper.putHeight(1);
      System.out.println("After putHeight 1 [exp:[1,2,5,7] 1 3]: " + keeper.toString() + " " + num3 + " " + keeper.getTotalOperations());
      int num4 = keeper.putHeight(6);
      System.out.println("After putHeight 6 [exp:[1,2,5,6,7] 3 6]: " + keeper.toString() + " " + num4 + " " + keeper.getTotalOperations());
      int num5 = keeper.putHeight(3);
      System.out.println("After putHeight 3 [exp:[1,2,3,5,6,7] 5 11]: " + keeper.toString() + " " + num5 + " " + keeper.getTotalOperations());
      int num6 = keeper.pickPos(0);
      System.out.println("After pickPos 0 [exp:[2,3,5,6,7] 1 12]: " + keeper.toString() + " " + num6 + " " + keeper.getTotalOperations());
      int num7 = keeper.pickPos(4);
      System.out.println("After pickPos 4 [exp:[2,3,5,6] 1 13]: " + keeper.toString() + " " + num7 + " " + keeper.getTotalOperations());
      int num8 = keeper.pickPos(1);
      System.out.println("After pickPos 1 [exp:[2,5,6] 3 16]: " + keeper.toString() + " " + num8 + " " + keeper.getTotalOperations());
      int num9 = keeper.putHeight(4);
      System.out.println("After putHeight 4 [exp:[2,4,5,6] 3 19]:" + keeper.toString() + " " + num9 + " " + keeper.getTotalOperations());
      int num10 = keeper.pickPos(2);
      System.out.println("After pickPos 2 [exp:[2,4,6] 3 22]: " + keeper.toString() + " " + num10 + " " + keeper.getTotalOperations());

   }

}
