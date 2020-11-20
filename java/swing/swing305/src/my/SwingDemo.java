
package my;

import javax.swing.JFrame;

/**
 * 按钮点击处理
 *
 * @author mini
 */
public class SwingDemo {

    private static void createGUI() {

        MyFrame frame = new MyFrame("显示时间");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 300);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });

    }
}
