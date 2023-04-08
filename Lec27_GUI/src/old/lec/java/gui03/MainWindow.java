package old.lec.java.gui03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField textInput;
	private JLabel labelOutput;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textInput = new JTextField();
		textInput.setFont(new Font("굴림", Font.PLAIN, 20));
		textInput.setBounds(10, 10, 412, 50);
		frame.getContentPane().add(textInput);
		textInput.setColumns(10);
		
		labelOutput = new JLabel("");
		labelOutput.setFont(new Font("굴림", Font.PLAIN, 20));
		labelOutput.setBounds(10, 70, 412, 122);
		frame.getContentPane().add(labelOutput);
		
		JButton btnInput = new JButton("입력");
		btnInput.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				labelOutput.setText(textInput.getText());
			}
		});
		
		btnInput.setFont(new Font("굴림", Font.PLAIN, 20));
		btnInput.setBounds(10, 202, 412, 50);
		frame.getContentPane().add(btnInput);
	}
}








