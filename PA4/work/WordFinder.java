// Name: Yufei Lu
// USC NetID: yufeilu
// CS 455 PA4
// Spring 2021

import java.io.FileNotFoundException;
import java.util.*;

/**
 * this class contains the main method and some helper methods.
 * to run the program, you should provide a dictionary as the command line argument,
 * if the dictionary is not provided by user, the program will use sowpods.txt.
 * Type in a String as the rack to get the result of the scrabble game
 * Type . to quit.
 */
public class WordFinder {

   /**
    * the main method processes the command-line argument, handles any error processing
    * and contains the command handling loop
    * @param args
    */
   public static void main(String[] args) {
      String fileName;
      if (args.length == 0) {
         fileName ="work/sowpods.txt";
      }
      else {
         fileName = args[0];
      }
      try {
         AnagramDictionary anagramDictionary = new AnagramDictionary(fileName);
         System.out.println("Type . to quit.");
         inputRack(anagramDictionary);
      }
      catch (FileNotFoundException exception) {
         System.out.println("ERROR: Dictionary file \"" + fileName + "\" does not exist.");
      }
      catch (IllegalDictionaryException exception) {
         System.out.println("ERROR: Illegal dictionary: dictionary file has a duplicate word: "
               + exception.getMessage());
      }
      return;
   }

   /**
    * contains a loop to handle the input command
    * exit the program when the user input "."
    * if the user input is a valid rack, find all words of the rack and print them out by order
    * @param anagramDictionary the anagramDictionary
    */
   private static void inputRack(AnagramDictionary anagramDictionary) {
      Scanner in = new Scanner(System.in);
      while (true) {
         System.out.print("Rack? ");
         String str = in.next();
         if (str.equals(".")) {
            break;
         }
         else {
            ArrayList<String> words = findAllWords(str, anagramDictionary);
            System.out.println("We can make " + words.size() + " words from \"" + str + "\"");
            if (words.size() != 0) {
               sortByScore(words);
            }
         }
      }
   }

   /**
    * find all words in the dictionary according to the string
    * @param str input string
    * @param anagramDictionary the dictionary
    * @return an ArrayList of words
    */
   private static ArrayList<String> findAllWords(String str, AnagramDictionary anagramDictionary) {
      Rack rack = new Rack(str);
      ArrayList<String> subsets = rack.allSubsets();
      ArrayList<String> words = new ArrayList<>();
      for (String subset : subsets) {
         if (!subset.equals("")) {
            ArrayList<String> anagramsArrayList = anagramDictionary.getAnagramsOf(subset);
            if (anagramsArrayList != null) {
               words.addAll(anagramsArrayList);
            }
         }
      }
      return words;
   }

   /**
    * sort the arraylist of words in decreasing order by score and print it out.
    * @param words the arraylist of words
    */
   private static void sortByScore(ArrayList<String> words) {

      TreeMap<String, Integer> wordsMap = new TreeMap<>();
      ScoreTable scoreTable = new ScoreTable();
      for (String word : words) {
         int score = scoreTable.wordScore(word);
         wordsMap.put(word, score);
      }
      System.out.println("All of the words with their scores (sorted by score):");
      ArrayList<Map.Entry<String, Integer>> entryArrayList = new ArrayList<>(wordsMap.entrySet());
      entryArrayList.sort(new wordsComparator());
      for (Map.Entry<String, Integer> wordEntry : entryArrayList) {
         System.out.println(wordEntry.getValue() + " : " + wordEntry.getKey());
      }
   }

}

/**
 * the words comparator class to compare words by score in decreasing order
 */
class wordsComparator implements Comparator<Map.Entry<String, Integer>> {

   @Override
   public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
      return Integer.compare(o2.getValue(), o1.getValue());
   }
}
