package builder001.helloworld;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("안녕하세요 친구들");
		lbl.setFont(new Font("굴림", Font.PLAIN, 29));
		lbl.setBounds(105, 46, 288, 63);
		contentPane.add(lbl);
		
		JButton btn = new JButton("클릭해보세요");
		btn.setBounds(79, 132, 196, 63);
		
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(lbl.getText().equals("HelloWorld")) {
					lbl.setText("안녕하세요 친구들");
				} else {
					lbl.setText("HelloWorld");
				}
				
			}
		});
		
		
		contentPane.add(btn);
	}
}
