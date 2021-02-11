// Name: Yufei Lu
// USC NetID: yufeilu
// CS 455 PA1
// Spring 2021

/**
 * Tester class for CoinTossSimulator
 */
public class CoinTossSimulatorTester {

   /**
    * create three simulator objects and test them.
    * @param args not used
    */
   public static void main(String[] args) {
      CoinTossSimulator simulator1 = new CoinTossSimulator();
      CoinTossSimulator simulator2 = new CoinTossSimulator();
      CoinTossSimulator simulator3 = new CoinTossSimulator();

      testAll(simulator1);
      testAll(simulator2);
      testOnce(simulator3);
   }

   /**
    * the main outputs of the results of the tests
    * @param exp expect number of trials
    * @param simulator the coin toss simulator
    */
   private static void testResult(int exp, CoinTossSimulator simulator) {
      int act = simulator.getNumTrials();
      boolean correct = exp == act;
      System.out.println("Number of trials [exp:" + exp + "]: " + act);
      System.out.println("Two-head tosses: " + simulator.getTwoHeads());
      System.out.println("Two-tail tosses: " + simulator.getTwoTails());
      System.out.println("One-head one-tail tosses: " + simulator.getHeadTails());
      System.out.println("Tosses add up correctly? " + correct);
      System.out.println();
   }

   /**
    * tests for methods in CoinTossSimulator class
    * including .run(num), .reset(), .getTwoHeads(), .getTwoTails(), .getHeadTail()
    * @param simulator coin toss simulator
    */
   private static void testAll(CoinTossSimulator simulator) {
      System.out.println("After constructor:");
      testResult(0, simulator);

      int sum = 0;
      for (int i = 0; i < 4; i++) {
         int runNum = (int) Math.pow(10, i);
         sum += runNum;
         simulator.run(runNum);
         System.out.println("After run " + runNum + ":");
         testResult(sum, simulator);
      }

      simulator.reset();
      System.out.println("After reset:");
      testResult(0, simulator);

      simulator.run(1000);
      System.out.println("After run:");
      testResult(1000, simulator);

      simulator.run(10000);
      System.out.println("After run:");
      testResult(11000, simulator);
   }

   /**
    * running for one trial only after creating the object
    * @param simulator coin toss simulator
    */
   private static void testOnce(CoinTossSimulator simulator) {
      System.out.println("After constructor:");
      testResult(0, simulator);

      simulator.run(1);
      System.out.println("After run:");
      testResult(1, simulator);
   }
    
}
