package old.lec.java.gui06;

import java.awt.EventQueue;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class MainWindow {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea textOutput;
	private JLabel lblToggle;

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
		frame.setBounds(100, 100, 450, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("성별");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		label.setBounds(10, 20, 102, 50);
		frame.getContentPane().add(label);
		
		JRadioButton rdbtnMale = new JRadioButton("남");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textOutput.setText("라디오버튼 \"남\" 선택");
			}
		});
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("굴림", Font.BOLD, 20));
		rdbtnMale.setBounds(133, 20, 81, 50);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("여");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textOutput.setText("라디오버튼 \"여\" 선택");
			}
		});
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("굴림", Font.BOLD, 20));
		rdbtnFemale.setBounds(218, 20, 68, 50);
		frame.getContentPane().add(rdbtnFemale);
		
		JLabel label2 = new JLabel("통신사");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("굴림", Font.BOLD, 20));
		label2.setBounds(10, 87, 102, 50);
		frame.getContentPane().add(label2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textOutput.setText("통신사: " + e.getItem().toString());
			}
		});
		comboBox.setFont(new Font("굴림", Font.BOLD, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"통신사", "SKT", "KT", "U+"}));
		comboBox.setBounds(133, 85, 153, 40);
		frame.getContentPane().add(comboBox);
		
		lblToggle = new JLabel("Toggle Button");
		lblToggle.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblToggle.setBounds(10, 150, 276, 50);
		frame.getContentPane().add(lblToggle);
		
		JToggleButton btnToggle = new JToggleButton("Toggle");
		btnToggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbstractButton btn  =
						(AbstractButton) e.getSource();
				boolean isSelected = btn.getModel().isSelected();
				textOutput.setText("토글 버튼 상태: " + isSelected);
				
				if (isSelected) {
					lblToggle.setText("ON");
				} else {
					lblToggle.setText("OFF");
				}
				
			}
		});
		btnToggle.setFont(new Font("굴림", Font.BOLD, 20));
		btnToggle.setBounds(298, 150, 124, 50);
		frame.getContentPane().add(btnToggle);
		
		
		JLabel lblNewLabel = new JLabel("스피너");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 206, 102, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				textOutput.setText("스피너 선택값: " + spinner.getValue().toString());
			}
		});
		spinner.setFont(new Font("굴림", Font.BOLD, 20));
		spinner.setBounds(133, 210, 153, 40);
		frame.getContentPane().add(spinner);
		
		textOutput = new JTextArea();
		textOutput.setLineWrap(true);
		textOutput.setEditable(false);
		textOutput.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textOutput.setBounds(10, 294, 412, 192);
		frame.getContentPane().add(textOutput);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmQuit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenu mnSubMenu = new JMenu("Sub Menu");
		mnEdit.add(mnSubMenu);
		
		JMenuItem mntmItem = new JMenuItem("Item 1");
		mnSubMenu.add(mntmItem);
		
		JMenuItem mntmItem_1 = new JMenuItem("Item2");
		mnSubMenu.add(mntmItem_1);
		
		JMenuItem mntmItem_2 = new JMenuItem("Item 3");
		mnSubMenu.add(mntmItem_2);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
	}
}









