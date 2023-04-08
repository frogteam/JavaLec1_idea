package old.lec.java.gui02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MainWindow {

	public static final String Message1 = "Hello, world!";
	public static final String Message2 = "안녕하세요~~ 여러분!!";
	
	private JFrame frame;
	JLabel label;

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
		
		label = new JLabel("Hello, world!");
		label.setFont(new Font("굴림", Font.BOLD, 20));
		label.setBounds(12, 10, 410, 50);
		frame.getContentPane().add(label);
		
		JButton btnChange = new JButton("Change");
		
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (label.getText().equals(Message1)) {
					label.setText(Message2);
				} else {
					label.setText(Message1);
				}
			}
		});
		
		btnChange.setFont(new Font("Verdana", Font.PLAIN, 30));
		btnChange.setBounds(12, 115, 410, 66);
		frame.getContentPane().add(btnChange);
	} // end initialize()
	
} // end class MainWindow







