// Name:
// USC NetID:
// CS 455 PA1
// Spring 2021

import java.util.Random;

/**
 * class CoinTossSimulator
 * <p>
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * <p>
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants,
 * and private methods to the class.  You will also be completing the
 * implementation of the methods given.
 * <p>
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 */
public class CoinTossSimulator {


    private int numTrials, twoHeads, twoTails, headTails;


    /**
     * Creates a coin toss simulator with no trials done yet.
     */
    public CoinTossSimulator() {
        this.numTrials = 0;
        this.twoHeads = 0;
        this.headTails = 0;
        this.twoTails = 0;
    }


    /**
     * Runs the simulation for numTrials more trials. Multiple calls to this method
     * without a reset() between them *add* these trials to the current simulation.
     *
     * @param numTrials number of trials to for simulation; must be >= 1
     */
    public void run(int numTrials) {

        this.numTrials += numTrials;

        Random random = new Random(5);
        boolean flag1, flag2;

        for (int i = 0; i < numTrials; i++) {
            random.nextBoolean();//仅为改变值
            flag1 = random.nextBoolean();
            flag2 = random.nextBoolean();
            if (flag1 && flag2) {
                this.twoHeads++;//两正
            } else if (flag1 || flag2) {
                this.headTails++;//正反
            } else {
                this.twoTails++;//两反
            }
        }
    }


    /**
     * Get number of trials performed since last reset.
     */
    public int getNumTrials() {
        return this.numTrials; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     * Get number of trials that came up two heads since last reset.
     */
    public int getTwoHeads() {
        return this.twoHeads; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     * Get number of trials that came up two tails since last reset.
     */
    public int getTwoTails() {
        return this.twoTails; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     * Get number of trials that came up one head and one tail since last reset.
     */
    public int getHeadTails() {
        return this.headTails; // DUMMY CODE TO GET IT TO COMPILE
    }


    /**
     * Resets the simulation, so that subsequent runs start from 0 trials done.
     */
    public void reset() {
        this.numTrials = 0;
        this.twoHeads = 0;
        this.headTails = 0;
        this.twoTails = 0;
    }

    @Override
    public String toString() {
        return "CoinTossSimulator{" +
                "numTrials=" + numTrials +
                ", twoHeads=" + twoHeads +
                ", twoTails=" + twoTails +
                ", headTails=" + headTails +
                '}';
    }
}
