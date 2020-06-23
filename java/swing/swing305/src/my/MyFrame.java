package my;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	JLabel jLabel = new JLabel("00:00:00");
	JButton jButton = new JButton("显示时间");

	public MyFrame(String title) {
		super(title);
		// 添加控件
		// 内容面板
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		// 向内容面板添加控件
		container.add(jLabel);
		container.add(jButton);

//		// 创建监听器对象
//		ActionListener myButtenListener = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				showtime();
//				System.out.println("按钮被点击");
//			}
//		};
//		// 调用监听器
//		jButton.addActionListener(myButtenListener);

//		jButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				showtime();
//				System.out.println("按钮被点击");
//			}
//		});

		// lambda表达式
		jButton.addActionListener((e) -> {
			System.out.println("按钮被点击");
			showtime();
		});
	}

	public void showtime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		String time = simpleDateFormat.format(new Date());
		jLabel.setText(time);
	}
}
