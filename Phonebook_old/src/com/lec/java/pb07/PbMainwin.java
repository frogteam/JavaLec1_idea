package com.lec.java.pb07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// View 역할을 할 메인 클래스
public class PbMainwin {

	private JFrame frame;
	private JTextField textIndex;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextArea textOutput;
	
	// Controller인 PhonebookManager 타입의 변수 선언
	private PhonebookManager pbMgr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PbMainwin window = new PbMainwin();
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
	public PbMainwin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// PhonebookManager 인스턴스 생성
		pbMgr = PhonebookManager.getInstance();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIndex = new JLabel("인덱스");
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		lblIndex.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblIndex.setBounds(12, 10, 132, 34);
		frame.getContentPane().add(lblIndex);
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblName.setBounds(12, 54, 132, 34);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblPhone.setBounds(12, 98, 132, 34);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblEmail.setBounds(12, 142, 132, 34);
		frame.getContentPane().add(lblEmail);
		
		textIndex = new JTextField();
		textIndex.setFont(new Font("굴림", Font.PLAIN, 20));
		textIndex.setBounds(156, 10, 307, 34);
		frame.getContentPane().add(textIndex);
		textIndex.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("굴림", Font.PLAIN, 20));
		textName.setColumns(10);
		textName.setBounds(156, 54, 307, 34);
		frame.getContentPane().add(textName);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("굴림", Font.PLAIN, 20));
		textPhone.setColumns(10);
		textPhone.setBounds(156, 98, 307, 34);
		frame.getContentPane().add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("굴림", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(156, 142, 307, 34);
		frame.getContentPane().add(textEmail);
		
		JButton btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				String phoneNum = textPhone.getText();
				String email = textEmail.getText();
				
				String info = "--- 입력 정보 ---" + "\n"
						+ "이름: " + name + "\n"
						+ "전화번호: " + phoneNum + "\n"
						+ "이메일: " + email;
				textOutput.setText(info);
				
				// 입력: Controller(pbMgr)를 통해서
				pbMgr.insert(name, phoneNum, email);
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 20));
		btnInsert.setBounds(12, 199, 132, 34);
		frame.getContentPane().add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 307, 550, 134);
		frame.getContentPane().add(scrollPane);
		
		textOutput = new JTextArea();
		textOutput.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textOutput);
		
		JButton btnSearchAll = new JButton("전체 검색");
		btnSearchAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 전체 검색: Controller(pbMgr)의 searchAll() 메소드 사용
				String info = pbMgr.searchAll();
				textOutput.setText("전체검색 결과\n");
				textOutput.append(info);
			}
		});
		btnSearchAll.setFont(new Font("굴림", Font.BOLD, 20));
		btnSearchAll.setBounds(156, 199, 132, 34);
		frame.getContentPane().add(btnSearchAll);
		
		JButton btnSearch = new JButton("인덱스 검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Controller(pbMagr)에 있는 search() 메소드 사용
				int index = Integer.parseInt(textIndex.getText());
				String info = pbMgr.search(index);
				
				textOutput.setText("인덱스 검색 결과\n");
				textOutput.append(info);
			}
		});
		btnSearch.setFont(new Font("굴림", Font.BOLD, 20));
		btnSearch.setBounds(300, 199, 163, 34);
		frame.getContentPane().add(btnSearch);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 수정: Controller(pbMgr)의 update() 메소드 사용
				int index = Integer.parseInt(textIndex.getText());
				String name = textName.getText();
				String phoneNum = textPhone.getText();
				String email = textEmail.getText();
				
				String info = 
						pbMgr.update(index, name, phoneNum, email);
				textOutput.setText("수정 결과\n");
				textOutput.append(info);
			}
		});
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 20));
		btnUpdate.setBounds(12, 248, 132, 34);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 삭제: Controller(pbMgr)의 delete() 메소드 사용
				int index = Integer.parseInt(textIndex.getText());
				pbMgr.delete(index);
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 20));
		btnDelete.setBounds(156, 243, 132, 34);
		frame.getContentPane().add(btnDelete);
		
		JButton btnSave = new JButton("파일저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pbMgr.saveDataToFile();
			}
		});
		btnSave.setFont(new Font("굴림", Font.BOLD, 20));
		btnSave.setBounds(300, 243, 132, 34);
		frame.getContentPane().add(btnSave);
	}
}








