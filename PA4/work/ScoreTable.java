// Name: Yufei Lu
// USC NetID: yufeilu
// CS 455 PA4
// Spring 2021

/**
 *  has information about Scrabble scores for scrabble letters and words.
 *  In scrabble not every letter has the same value. Letters that occur
 *  more often in the English language are worth less.
 *
 */
public class ScoreTable {

   /**
    * calculate the score of a letter
    * @param c a character of letter
    * @return the score
    */
   public int letterScore(char c) {
      if (c < 97) {
         c = (char) (c + 32);
      }
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'l' || c == 'n'
               || c == 's' || c == 't' || c == 'r') {
         return 1;
      }
      else if (c == 'd' || c == 'g') {
         return 2;
      }
      else if (c == 'b' || c == 'c'|| c == 'm' || c == 'p') {
         return 3;
      }
      else if (c == 'f' || c == 'h' || c == 'v' || c == 'w' || c == 'y') {
         return 4;
      }
      else if (c == 'k') {
         return 5;
      }
      else if (c == 'j' || c == 'x') {
         return 8;
      }
      else if (c == 'q' || c == 'z'){
         return 10;
      }
      return 0;
   }

   /**
    * calculate the score of a word
    * @param s a string of word
    * @return the score
    */
   public int wordScore(String s) {
      int sum = 0;
      for (int i = 0; i < s.length(); i++) {
         sum += letterScore(s.charAt(i));
      }
      return sum;
   }

}
