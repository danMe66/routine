
package my;

import javax.swing.JFrame;

public class SwingDemo {

	private static void createGUI() {

		MyFrame frame = new MyFrame("Swing Demo");
		
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
