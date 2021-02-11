// Name: Yufei Lu
// USC NetID: yufeilu
// CS 455 PA1
// Spring 2021

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {

   private int twoHeadNum;
   private int twoTailNum;
   private int headTailNum;


   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      twoHeadNum = 0;
      twoTailNum = 0;
      headTailNum = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      Random random = new Random();
      for (int i = 0; i < numTrials; i++) {
         int coin1 = random.nextInt(2);
         int coin2 = random.nextInt(2);
         if (coin1 == 1 && coin2 == 1) {
            twoHeadNum++;
         }
         else if (coin1 == 0 && coin2 == 0) {
            twoTailNum++;
         }
         else {
            headTailNum++;
         }
      }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return twoHeadNum + twoTailNum + headTailNum;
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeadNum;
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTailNum;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTailNum;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      twoHeadNum = 0;
      twoTailNum = 0;
      headTailNum = 0;
   }

}
