package old.lec.java.gui04;

import java.awt.EventQueue;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextArea textOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("이름");
		label.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(23, 25, 90, 50);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("전화번호");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(23, 87, 90, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이메일");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(23, 162, 90, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.PLAIN, 20));
		textName.setBounds(138, 25, 360, 50);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("굴림", Font.PLAIN, 20));
		textPhone.setBounds(138, 87, 360, 50);
		frame.getContentPane().add(textPhone);
		textPhone.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("굴림", Font.PLAIN, 20));
		textEmail.setBounds(138, 162, 360, 50);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JButton btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "이름: " + textName.getText() + "\n"
						+ "전화번호: " + textPhone.getText() + "\n"
						+ "이메일: " + textEmail.getText();
				textOutput.setText(str);
//				textOutput.setText("이름: " + textName.getText() + "\n");
//				textOutput.append("전화번호: " + textPhone.getText() + "\n");
//				textOutput.append("이메일: " + textEmail.getText() + "\n");
			}
		});
		
		btnInsert.setFont(new Font("굴림", Font.BOLD, 20));
		btnInsert.setBounds(23, 254, 155, 44);
		frame.getContentPane().add(btnInsert);
		
		textOutput = new JTextArea();
		textOutput.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		textOutput.setBounds(23, 319, 475, 178);
		frame.getContentPane().add(textOutput);
	}
}
