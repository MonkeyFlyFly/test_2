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
		// ���� JFrame ʵ��
		JFrame frame = new JFrame("return calcualtion");
		// Setting the width and height of frame
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * ������壬��������� HTML �� div ��ǩ ���ǿ��Դ��������岢�� JFrame ��ָ��λ��
		 * ��������ǿ�������ı��ֶΣ���ť�����������
		 */
		JPanel panel = new JPanel();
		
		/*
		 * �����û�����ķ����������������
		 */
		placeComponents(panel);
		// ������
		frame.add(panel);
		frame.setSize(500, 500);
		// ���ý���ɼ�
		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {

		/*
		 * ���ֲ���������߲��������� ������ò���Ϊ null
		 */
		
		panel.setLayout(null);

		// ���� JLabel
		JLabel userLabel = new JLabel("Return Name:");
		/*
		 * ������������������λ�á� setBounds(x, y, width, height) x �� y ָ�����Ͻǵ���λ�ã��� width
		 * �� height ָ���µĴ�С��
		 */
		userLabel.setBounds(10, 20, 150, 25);
		panel.add(userLabel);

		/*
		 * �����ı��������û�����
		 */
		JTextField userText = new JTextField(20);
		userText.setBounds(160, 20, 165, 25);
		panel.add(userText);

		// ����������ı���
		JLabel passwordLabel = new JLabel("Return short Name:");
		passwordLabel.setBounds(10, 50, 150, 25);
		panel.add(passwordLabel);
		
		
		
		JTextField passwordText = new JTextField(20);
//		passwordText.setBounds(160, 50, 165, 50);
//		passwordText.setLineWrap(true);        //�����Զ����й���   
//		passwordText.setWrapStyleWord(true);            // ������в����ֹ���</strong>  
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
		
		

		
		
		// ������¼��ť
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
