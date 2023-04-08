package old.lec.java.gui08;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JPanel {

	private JFrame frame;
	private JFileChooser fileChooser;

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
		
		JButton btnNewWindonw = new JButton("New Window");
		btnNewWindonw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileChooser();
			}
		});
		btnNewWindonw.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		btnNewWindonw.setBounds(70, 106, 293, 50);
		frame.getContentPane().add(btnNewWindonw);
	}
	
	private void openFileChooser() {
		fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(MainWindow.this);
	}
	
}
