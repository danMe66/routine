package my;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingDemo {

	private static void createGUI() {

		JFrame frame = new JFrame("Swing Demo");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = frame.getContentPane();

		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("Hello,World"));

		contentPane.add(new JButton("测试"));

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
