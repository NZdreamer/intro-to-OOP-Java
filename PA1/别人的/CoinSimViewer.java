import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Scanner;

/**
 * @Author: Ruixiang Chen
 * @Date:2021/2/422:44
 * @Description TODO
 */
public class CoinSimViewer {
    public static void main(String[] args) {

        CoinTossSimulator coinTossSimulator = new CoinTossSimulator();
        JFrame frame = new JFrame();
        frame.setSize(818, 548);
        frame.setTitle("CoinSim");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.print("请输入实验次数:");
        Scanner scanner = new Scanner(System.in);
        int numTails = scanner.nextInt();
        coinTossSimulator.run(numTails);
        CoinSimComponent coinSimComponent = new CoinSimComponent();
        /*
         * 设定输入
         * */
        coinSimComponent.setBar1Num(coinTossSimulator.getTwoHeads());
        coinSimComponent.setBar2Num(coinTossSimulator.getHeadTails());
        coinSimComponent.setBar3Num(coinTossSimulator.getTwoTails());
        frame.add(coinSimComponent);
        frame.setVisible(true);
    }
}
