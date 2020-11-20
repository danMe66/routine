package my;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    JLabel jLabel = new JLabel("官网title");

    public MyFrame(String title) {
        super(title);
        // 添加控件
        // 内容面板
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        // 向内容面板添加控件
        container.add(jLabel);
        jLabel.setText("xxxxx");
        jLabel.setFont(new Font("微软雅黑", 0, 14));
        jLabel.setForeground(Color.blue);
        jLabel.setToolTipText("www.baidu.com");

    }
}
