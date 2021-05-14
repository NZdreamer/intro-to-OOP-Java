// Name: Yufei Lu
// USC NetID: yufeilu
// CSCI455 PA2
// Spring 2021


/**
 * Class BookshelfKeeper
 * <p>
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in
 * non-decreasing order by height, with the restriction that single books can only be added
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper {

   /**
    * Representation invariant:
    * <p>
    * - bookshelf is not null
    * - bookshelf is in non-decreasing order
    * - callsNum is >= 0
    */

   private Bookshelf bookshelf;
   private int callsNum;


   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      bookshelf = new Bookshelf();
      callsNum = 0;
      assert isValidBookshelfKeeper();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    * <p>
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      bookshelf = sortedBookshelf;
      callsNum = 0;
      assert isValidBookshelfKeeper();
   }


   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted
    * after picking up the book.
    * <p>
    * Returns the number of callsNum to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * <p>
    * PRE: position must be in the range [0, getNumBooks()).
    */
   public int pickPos(int position) {
      int size = bookshelf.size();
      int nums = 0;
      if (position >= bookshelf.size() / 2.0) {
         nums = size - position - 1;
         Bookshelf tempBookShelf = storeLast(nums);
         bookshelf.removeLast();
         putBackLast(tempBookShelf);
      } else {
         nums = position;
         Bookshelf tempBookShelf = storeFront(nums);
         bookshelf.removeFront();
         putBackFront(tempBookShelf);
      }
      int callOnceNums = 2 * nums + 1;
      callsNum += callOnceNums;
      assert isValidBookshelfKeeper();
      return callOnceNums;
   }


   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted
    * after the insertion.
    * <p>
    * Returns the number of callsNum to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * <p>
    * PRE: height > 0
    */
   public int putHeight(int height) {
      int size = bookshelf.size();
      int nums = 0;
      int callOnceNums = 0;
      if (bookshelf.size() > 0) {
         boolean isFromEnd = height > bookshelf.getHeight(size / 2);
         if (isFromEnd) {
            callOnceNums = putHeightFromEnd(height);
         } else {
            callOnceNums = putHeightFromStart(height);
         }
      } else {
         bookshelf.addFront(height);
         callOnceNums += 1;
      }
      callsNum += callOnceNums;
      assert isValidBookshelfKeeper();
      return callOnceNums;
   }

   /**
    * Returns the total number of callsNum made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {

      return callsNum;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {

      return bookshelf.size();
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed
    * by the number of bookshelf mutator callsNum made to perform the last pick or put operation,
    * followed by the total number of such callsNum made since we created this BookshelfKeeper.
    * <p>
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    */
   public String toString() {

      return bookshelf.toString();

   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {

      if (bookshelf != null && bookshelf.isSorted() && callsNum >= 0) {
         return true;
      }
      return false;

   }


   /**
    * store nums of books into a temporary bookshelf from the front of bookshelf
    *
    * @param nums the number of books to store
    * @return the temporary bookshelf
    */
   private Bookshelf storeFront(int nums) {
      Bookshelf tempBookshelf = new Bookshelf();
      for (int i = 0; i < nums; i++) {
         tempBookshelf.addLast(bookshelf.removeFront());
      }
      return tempBookshelf;
   }

   /**
    * store nums of books into a temporary bookshelf from the end of bookshelf
    *
    * @param nums the number of books to store
    * @return the temporary bookshelf
    */
   private Bookshelf storeLast(int nums) {
      Bookshelf tempBookshelf = new Bookshelf();
      for (int i = 0; i < nums; i++) {
         tempBookshelf.addFront(bookshelf.removeLast());
      }
      return tempBookshelf;
   }

   /**
    * put back the books stored in the temporary bookshelf into the original bookshelf
    * from the front
    *
    * @param tempBookshelf the temporary bookshelf
    */
   private void putBackFront(Bookshelf tempBookshelf) {
      int nums = tempBookshelf.size();
      for (int i = 0; i < nums; i++) {
         bookshelf.addFront(tempBookshelf.removeLast());
      }
   }

   /**
    * put back the books stored in the temporary bookshelf into the original bookshelf
    * from the end
    *
    * @param tempBookshelf the temporary bookshelf
    */
   private void putBackLast(Bookshelf tempBookshelf) {
      int nums = tempBookshelf.size();
      for (int i = 0; i < nums; i++) {
         bookshelf.addLast(tempBookshelf.removeFront());
      }
   }


   /**
    * Insert book with specified height into the shelf from the end of bookshelf.
    *
    * @param height the height of book to be inserted into shelf
    * @return the number of calls to mutators on the contained bookshelf used to complete this
    * operation.
    */
   private int putHeightFromEnd(int height) {
      int size = bookshelf.size();
      int nums = 0;
      for (int i = 0; i <= size / 2; i++) {
         if (height > bookshelf.getHeight(size - i - 1)) {
            nums = i;
            break;
         }
      }
      Bookshelf tempBookshelf = storeLast(nums);
      bookshelf.addLast(height);
      putBackLast(tempBookshelf);
      return nums * 2 + 1;
   }

   /**
    * Insert book with specified height into the shelf from the start of bookshelf.
    *
    * @param height the height of book to be inserted into shelf
    * @return the number of calls to mutators on the contained bookshelf used to complete this
    * operation.
    */
   private int putHeightFromStart(int height) {
      int size = bookshelf.size();
      int nums = 0;
      for (int i = 0; i <= size / 2; i++) {
         if (height < bookshelf.getHeight(i)) {
            nums = i;
            break;
         }
      }
      Bookshelf tempBookshelf = storeFront(nums);
      bookshelf.addFront(height);
      putBackFront(tempBookshelf);
      return nums * 2 + 1;
   }


}
