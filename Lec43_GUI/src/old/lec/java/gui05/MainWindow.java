package old.lec.java.gui05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField textNumInput1;
	private JTextField textNumInput2;
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
		frame.setBounds(100, 100, 450, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNum1 = new JLabel("Number 1");
		lblNum1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNum1.setBounds(10, 20, 101, 50);
		frame.getContentPane().add(lblNum1);
		
		JLabel lblNum2 = new JLabel("Number 2");
		lblNum2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNum2.setBounds(10, 90, 101, 50);
		frame.getContentPane().add(lblNum2);
		
		textNumInput1 = new JTextField();
		textNumInput1.setFont(new Font("굴림", Font.PLAIN, 20));
		textNumInput1.setBounds(117, 20, 305, 50);
		frame.getContentPane().add(textNumInput1);
		textNumInput1.setColumns(10);
		
		textNumInput2 = new JTextField();
		textNumInput2.setFont(new Font("굴림", Font.PLAIN, 20));
		textNumInput2.setBounds(117, 90, 305, 50);
		frame.getContentPane().add(textNumInput2);
		textNumInput2.setColumns(10);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("+ 버튼");
				double num1 = Double.parseDouble(textNumInput1.getText());
				double num2 = Double.parseDouble(textNumInput2.getText());
				double result = num1 + num2;
				String msg = num1 + " + " + num2 + " = " + result;
				textOutput.setText(msg);
			}
		});
		btnAdd.setFont(new Font("굴림", Font.BOLD, 20));
		btnAdd.setBounds(10, 179, 51, 50);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1 = Double.parseDouble(textNumInput1.getText());
				double num2 = Double.parseDouble(textNumInput2.getText());
				double result = num1 - num2;
				String msg = num1 + " - " + num2 + " = " + result;
				textOutput.setText(msg);
			}
		});
		btnSub.setFont(new Font("굴림", Font.BOLD, 20));
		btnSub.setBounds(73, 179, 51, 50);
		frame.getContentPane().add(btnSub);
		
		JButton btnMul = new JButton("x");
		btnMul.setFont(new Font("굴림", Font.BOLD, 20));
		btnMul.setBounds(136, 179, 51, 50);
		frame.getContentPane().add(btnMul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setFont(new Font("굴림", Font.BOLD, 20));
		btnDiv.setBounds(199, 179, 51, 50);
		frame.getContentPane().add(btnDiv);
		
		textOutput = new JTextArea();
		textOutput.setEditable(false);
		textOutput.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textOutput.setBounds(12, 249, 410, 155);
		frame.getContentPane().add(textOutput);
	}

}
