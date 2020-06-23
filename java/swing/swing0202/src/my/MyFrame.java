package my;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyFrame(String title) {
		super(title);
		// 添加控件
		// 内容面板
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		// 向内容面板添加控件
		container.add(new JLabel("Hello Word"));
		container.add(new JButton("测试"));
	}
}
