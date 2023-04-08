package old.lec.java.gui01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("main() 종료");
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
		frame.setBounds(100, 100, 516, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Hello, world!");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		frame.setVisible(true);
	}

}










