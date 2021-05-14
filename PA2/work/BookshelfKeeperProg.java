// Name: Yufei Lu
// USC NetID: yufeilu
// CSCI455 PA2
// Spring 2021

import java.util.ArrayList;
import java.util.Scanner;

/**
 * BookshelfKeeperProg class allow users to create a bookshelfKeeper and perform a series of
 * pick and put operations on the BookshelfKeeper object. It scans user inputs in the terminal.
 * <p>
 * this class contains a main method and several static helper methods, including
 * initBookshelfKeeper: allow the user to initiate a bookshelfKeeper
 * executeCommand: to put or pick a book on the bookshelf or to end the program
 * put: to put a book by height on the shelf
 * pick: to put a book by position on the shelf
 * printBookshelf: print the current bookshelf in a certain format
 */
public class BookshelfKeeperProg {

   /**
    * run the BookshelfKeeperProg from here, it create a bookshelfKeeper and execute several put
    * and pick operations according to the user input
    * to create a bookshelfKeeper, user should type in a serial of numbers representing the heights
    * of books within one line and followed by newline
    * to put ot pick a book, user should type in "put" or "pick" and a integer within one line and
    * followed by newline
    * to exit the program, type "end"
    *
    * @param args
    */
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      BookshelfKeeper keeper = initBookshelfKeeper(in);
      if (keeper == null) {
         return;
      }
      System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
      while (true) {
         int exCode = executeCommand(in, keeper);
         if (exCode == -1) {
            break;
         }
      }
   }

   /**
    * initiate a bookshelfKeeper according to the user input, empty input is allowed
    *
    * @param in the scanner
    * @return the bookshelfKeeper to operate
    * <p>
    * PRE: all the input number are > 0 and in a non-decreasing order
    */
   private static BookshelfKeeper initBookshelfKeeper(Scanner in) {
      System.out.println("Please enter initial arrangement of books followed by newline:");
      String books = in.nextLine();
      Scanner lineScanner = new Scanner(books);
      ArrayList<Integer> arraylistBooks = new ArrayList<>();
      while (lineScanner.hasNextInt()) {
         int book = lineScanner.nextInt();
         if (book <= 0) {
            System.out.println("ERROR: Height of a book must be positive.");
            System.out.println("Exiting Program.");
            return null;
         }
         arraylistBooks.add(book);
      }
      Bookshelf bookshelf = new Bookshelf(arraylistBooks);
      if (!bookshelf.isSorted()) {
         System.out.println("ERROR: Heights must be specified in non-decreasing order.");
         System.out.println("Exiting Program.");
         return null;
      }
      BookshelfKeeper keeper = new BookshelfKeeper(bookshelf);
      printBookshelf(keeper, 0);
      return keeper;
   }

   /**
    * determine which is the command input by the user and respond to it
    *
    * @param in     the scanner
    * @param keeper the bookshelfKeeper
    * @return an exit code, -1 when there is an error
    * <p>
    * PRE: the input word should be one of "put", "pick" and "end"
    * height > 0
    * 0 <= position < keeper.getNumBooks()
    */
   private static int executeCommand(Scanner in, BookshelfKeeper keeper) {
      int exCode = 0;
      String line = in.nextLine();
      Scanner lineScanner = new Scanner(line);
      String command = lineScanner.next();
      if (command.equals("put")) {
         int height = lineScanner.nextInt();
         exCode = put(height, keeper);
      } else if (command.equals("pick")) {
         int position = lineScanner.nextInt();
         exCode = pick(position, keeper);
      } else if (command.equals("end")) {
         System.out.println("Exiting Program.");
         exCode = -1;
      } else {
         System.out.println("ERROR: Operation should be either pick or put.");
         System.out.println("Exiting Program.");
         exCode = -1;
      }
      return exCode;
   }

   /**
    * put the book into the bookshelfKeeper according to its height
    *
    * @param height the height of the book (input by the user)
    * @param keeper the bookshelfKeeper
    * @return an exit code, -1 when an error occurs
    * <p>
    * PRE: height > 0
    */
   private static int put(int height, BookshelfKeeper keeper) {
      if (height <= 0) {
         System.out.println("ERROR: Height of a book must be positive.");
         System.out.println("Exiting Program.");
         return -1;
      }
      printBookshelf(keeper, keeper.putHeight(height));
      return 1;
   }

   /**
    * pick a book in the bookshelfKeeper according to the position
    *
    * @param position the position of the book
    * @param keeper   the bookshlefKeeper
    * @return an exit code, -1 when an error occurs
    * <p>
    * PRE: 0 <= position < keeper.getNumBooks()
    */
   private static int pick(int position, BookshelfKeeper keeper) {
      if (position < 0 || position >= keeper.getNumBooks()) {
         System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
         System.out.println("Exiting Program.");
         return -1;
      }
      printBookshelf(keeper, keeper.pickPos(position));
      return 1;
   }

   /**
    * print the bookshelfKeeper and the numbers of operations taken for this time and total
    *
    * @param keeper      the bookshelfKeeper
    * @param callOnceNum the number of calls to the mutators in Bookshelf class
    *                    with one put or pick operation
    */
   private static void printBookshelf(BookshelfKeeper keeper, int callOnceNum) {
      System.out.println(keeper.toString() + " " + callOnceNum + " " + keeper.getTotalOperations());
   }
}
