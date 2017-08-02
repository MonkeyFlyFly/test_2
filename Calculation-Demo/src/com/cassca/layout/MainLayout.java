package com.cassca.layout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		JLabel userLabel = new JLabel("Return Short Name:");
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
		JLabel passwordLabel = new JLabel("fields:(seperate with '|')");
		passwordLabel.setBounds(10, 50, 150, 25);
		panel.add(passwordLabel);

		/*
		 * �����������������ı��� �����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
		 */
		final JTextArea passwordText = new JTextArea();
//		passwordText.setBounds(160, 50, 165, 50);
		passwordText.setLineWrap(true);        //�����Զ����й���   
		passwordText.setWrapStyleWord(true);            // ������в����ֹ���</strong>  
		JScrollPane sp=new JScrollPane(passwordText);
		sp.setBounds(160, 50, 165, 50);
		panel.add(sp,null);
		
		// ������¼��ť
		JButton loginButton = new JButton("generate fields");
		loginButton.setBounds(10, 80, 140, 25);
		panel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String fields = passwordText.getText().toString().trim();
				List<String> list_fields = SpiltData.SpiltDatas(fields);
				
			}
		});
		
		
		
		JLabel passwordLabel2 = new JLabel("fields:(seperate with '|')");
		passwordLabel2.setBounds(10, 150, 150, 25);
		panel.add(passwordLabel2);

		JTextArea passwordText2 = new JTextArea();
//		passwordText2.setBounds(160, 150, 165, 50);
		passwordText.setLineWrap(true);        //�����Զ����й���   
		passwordText.setWrapStyleWord(true);            // ������в����ֹ���</strong>  
		JScrollPane sp2=new JScrollPane(passwordText2);
		sp2.setBounds(160, 150, 165, 50);
		panel.add(sp2,null);
		// ������¼��ť
		JButton loginButton2 = new JButton("generate Return");
		loginButton2.setBounds(10, 180, 140, 25);
		panel.add(loginButton2);
				
	
	}
	
	

}
