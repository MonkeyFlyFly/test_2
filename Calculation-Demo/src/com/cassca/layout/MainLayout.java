package com.cassca.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.LabelUI;

import com.cassca.constants.Calculation;
import com.cassca.utils.SpiltData;

public class MainLayout {
	public static JPanel panel;
	public static void main(String[] args) {
		// 创建 JFrame 实例
		JFrame frame = new JFrame("return calcualtion");
		// Setting the width and height of frame
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * 创建面板，这个类似于 HTML 的 div 标签 我们可以创建多个面板并在 JFrame 中指定位置
		 * 面板中我们可以添加文本字段，按钮及其他组件。
		 */
		JPanel panel = new JPanel();
		
		/*
		 * 调用用户定义的方法并添加组件到面板
		 */
		placeComponents(panel);
		// 添加面板
		frame.add(panel);
		frame.setSize(500, 500);
		// 设置界面可见
		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		/*
		 * 布局部分我们这边不多做介绍 这边设置布局为 null
		 */
		
		panel.setLayout(null);

		// 创建 JLabel
		JLabel userLabel = new JLabel("Return Name:");
		/*
		 * 这个方法定义了组件的位置。 setBounds(x, y, width, height) x 和 y 指定左上角的新位置，由 width
		 * 和 height 指定新的大小。
		 */
		userLabel.setBounds(10, 20, 150, 25);
		panel.add(userLabel);

		/*
		 * 创建文本域用于用户输入
		 */
		JTextField userText = new JTextField(20);
		userText.setBounds(160, 20, 165, 25);
		panel.add(userText);

		// 输入密码的文本域
		JLabel passwordLabel = new JLabel("Return short Name:");
		passwordLabel.setBounds(10, 50, 150, 25);
		panel.add(passwordLabel);
		
		
		
		JTextField passwordText = new JTextField(20);
//		passwordText.setBounds(160, 50, 165, 50);
//		passwordText.setLineWrap(true);        //激活自动换行功能   
//		passwordText.setWrapStyleWord(true);            // 激活断行不断字功能</strong>  
//		JScrollPane sp=new JScrollPane(passwordText);
		passwordText.setBounds(160, 50, 165, 25);
		panel.add(passwordText);
		
		
		JLabel jl_1 = new JLabel("please select template:");
		jl_1.setBounds(10, 120, 150, 20);
		panel.add(jl_1);
		
		File directory = new File("");
        String courseFile = null;
        try{
        	courseFile = directory.getCanonicalPath();
        }catch(IOException e){
        	e.printStackTrace();
        }
        File file = new File(courseFile+Calculation.IMG_PATH_NAME);
        File[] files = file.listFiles();
        int i = 1;
        for (File file2 : files) {
			System.out.println(file2.getPath());
			Icon icon = new ImageIcon(file2.getPath());
			JLabel img_i = new JLabel(icon);
			if (i==2) {
				img_i.setBounds(220, 200, 200, 200);
					
			}else{
				
				img_i.setBounds(10, 200, 200, 200);
			}
			panel.add(img_i);
			i++;
		}
		
		

		
		
		// 创建登录按钮
		JButton loginButton = new JButton("generate fields");
		loginButton.setBounds(10, 80, 140, 25);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	

}
