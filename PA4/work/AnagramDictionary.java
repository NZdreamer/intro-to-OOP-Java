// Name: Yufei Lu
// USC NetID: yufeilu
// CS 455 PA4
// Spring 2021


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */
public class AnagramDictionary {

   /**
    * Representation invariant:
    * the size of anagramWords is <= the words in dictionaryFile
    */
   private TreeMap<String, ArrayList<String>> anagramWords;

   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
      @throws IllegalDictionaryException  if the dictionary has any duplicate words
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException,
                                                    IllegalDictionaryException {
      HashSet<String> words = new HashSet<>();
      anagramWords = new TreeMap<>();
      File dictionaryFile = new File(fileName);
      Scanner dicScanner = new Scanner(dictionaryFile);

      while (dicScanner.hasNext()) {
         String thisWord = dicScanner.next();
         if (words.contains(thisWord)) {
            throw new IllegalDictionaryException(thisWord);
         }
         else {
            words.add(thisWord);
            String sortedWord = sort(thisWord);
            ArrayList<String> arrayList;
            if (anagramWords.containsKey(sortedWord)) {
               arrayList = anagramWords.get(sortedWord);
               arrayList.add(thisWord);
               anagramWords.put(sortedWord, arrayList);
            }
            else {
               arrayList = new ArrayList<>();
               arrayList.add(thisWord);
               anagramWords.put(sortedWord, arrayList);
            }
         }
      }
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
      s = sort(s);
      ArrayList<String> arrayList = anagramWords.get(s);
      return arrayList;

   }

   /**
    * sort the characters in the word, so that it represents in a special form
    * two different words with exact the same characters in them becomes the same
    * string after sort()
    * @param word the word to be sort
    * @return
    */
   private String sort(String word) {
      LinkedList<Character> linkedList = new LinkedList<>();
      for (int i = 0; i < word.length(); i++) {
         linkedList.add(word.charAt(i));
      }
      Collections.sort(linkedList);
      return linkedList.toString();
   }
   
}
