// Name: Yufei Lu
// USC NetID: yufeilu
// CSCI455 PA2
// Spring 2021


import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
 */

public class Bookshelf {

   /**
    * Representation invariant:
    * <p>
    * -- bookshelf is not null
    * -- books represented by its height are integers and > 0
    */
   private ArrayList<Integer> books;


   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      books = new ArrayList<Integer>();
      assert isValidBookshelf();
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * <p>
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      books = new ArrayList<Integer>(pileOfBooks);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * <p>
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      books.add(0, height);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * <p>
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      books.add(height);
      assert isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * <p>
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      return books.remove(0);
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * <p>
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      return books.remove(books.size() - 1);
   }

   /*
    * Gets the height of the book at the given position.
    *
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {

      return books.get(position);

   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {

      return books.size();

   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {

      return books.toString();

   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      for (int i = 0; i < size() - 1; i++) {
         if (books.get(i) > books.get(i + 1)) {
            return false;
         }
      }
      return true;
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {

      if (books == null) {
         return false;
      }
      for (int i = 0; i < size(); i++) {
         if (books.get(i) <= 0) {
            return false;
         }
      }
      return true;

   }

   public class RecComparator implements Comparator<Rectangle> {

      @Override
      public int compare(Rectangle o1, Rectangle o2) {
         return 0;
      }
   }

}
