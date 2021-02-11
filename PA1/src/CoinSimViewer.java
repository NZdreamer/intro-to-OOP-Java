// Name: Yufei Lu
// USC NetID: yufeilu
// CS 455 PA1
// Spring 2021

import java.util.Scanner;
import javax.swing.JFrame;

/**
 * CoinSimViewer class
 *
 * contains the main program,
 * scan the user input as the number of trials, discard the negative number inputs;
 * create the JFrame containing the CoinSimComponent;
 * run the coin tossing simulation
 *
 */
public class CoinSimViewer {

    /**
     * Scan the user input as the number of trials, discard the negative number inputs;
     * create the JFrame containing the CoinSimComponent;
     * run the coin tossing simulation
     *
     * To run the program, compile CoinSimViewer.java, CoinSimComponent.java,
     * CoinTossSimulator.java and Bar.java
     * @param args not used
     */
    public static void main(String[] args) {

        // prompts for the number of trials
        System.out.print("Please enter the number of trials: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        while (num <= 0) {
            System.out.println("ERROR: Number entered must be greater than 0.");
            System.out.print("Please enter the number of trials: ");
            num = in.nextInt();
        }

        //create the JFrame containing the CoinSimComponent
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create and run the coin toss simulator
        CoinTossSimulator simulator = new CoinTossSimulator();
        simulator.run(num);

        CoinSimComponent component = new CoinSimComponent(simulator);
        frame.add(component);
        
        frame.setVisible(true);
    }
}
