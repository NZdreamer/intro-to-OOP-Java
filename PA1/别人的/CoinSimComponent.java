import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * @Author: Ruixiang Chen
 * @Date:2021/2/422:31
 * @Description TODO
 */
public class CoinSimComponent extends JComponent {

    /*
     * 文本框中整数
     * */
    private int bar1Num, bar2Num, bar3Num;

    /*
     * 文本框中百分数
     * */
    private double bar1Percent, bar2Percent, bar3Percent;


    /*
     * set/get 方法
     * */

    public int getBar1Num() {
        return bar1Num;
    }

    public void setBar1Num(int bar1Num) {
        this.bar1Num = bar1Num;
    }

    public int getBar2Num() {
        return bar2Num;
    }

    public void setBar2Num(int bar2Num) {
        this.bar2Num = bar2Num;
    }

    public int getBar3Num() {
        return bar3Num;
    }

    public void setBar3Num(int bar3Num) {
        this.bar3Num = bar3Num;
    }


    private boolean checkNumIsDef() {
        if ((getBar1Num() + getBar2Num() + getBar2Num()) > 0) {
            return true;
        }
        System.out.println("The bar num not def!");
        return false;
    }

    public int getBar1Percent() {
        bar1Percent = getBar1Num() / (double) (getBar1Num() + getBar2Num() + getBar3Num());
        return (int) (bar1Percent * 100);
    }

    public int getBar2Percent() {
        bar2Percent = getBar2Num() / (double) (getBar1Num() + getBar2Num() + getBar3Num());
        return (int) (bar2Percent * 100);
    }

    public int getBar3Percent() {
        bar3Percent = getBar3Num() / (double) (getBar1Num() + getBar2Num() + getBar3Num());
        return (int) (bar3Percent * 100);
    }


    /*
     * 绘图函数
     * */
    public void paintComponent(Graphics graphics) {
        Graphics2D g2D = (Graphics2D) graphics;

        /*
         * (500 - bottom*2)/100 = scale
         * */

        int bottom = 50;
        double scale = (getSize().getHeight() - bottom * 2) / 100;

        int x = getSize().width/4;

        int y = getSize().height;

        Bar bar1 = new Bar(y-bottom, x, 50, getBar1Percent(), scale, Color.red, "Two Heads:" + getBar1Num() + "(" + getBar1Percent() + "%)");

        Bar bar2 = new Bar(y-bottom, 2*x, 50, getBar2Percent(), scale, Color.GREEN, "A Head and a Tail:" + getBar2Num() + "(" + getBar2Percent() + "%)");

        Bar bar3 = new Bar(y-bottom, 3*x, 50, getBar3Percent(), scale, Color.BLUE, "Two Tails:" + getBar3Num() + "(" + getBar3Percent() + "%)");

        bar1.draw(g2D);

        bar2.draw(g2D);

        bar3.draw(g2D);

    }
}
