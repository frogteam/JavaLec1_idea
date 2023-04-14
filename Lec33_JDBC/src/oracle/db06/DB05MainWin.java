package oracle.db06;

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
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DB05MainWin {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtPw;
	private JTextField txtEmail;
	private JTextArea txtOutput;
	
	private MemberControl memberMgr;
	
	private JTable tblMember;
	private DefaultTableModel tblModel;
	private int rowSelected = -1;
	private int colSelected = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB05MainWin window = new DB05MainWin();
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
	public DB05MainWin() {
		memberMgr = MemberControl.getInstance();
		initialize();
		initTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 733);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("멤버 관리 프로그램");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblTitle.setBounds(12, 10, 410, 47);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblId.setBounds(12, 65, 111, 34);
		frame.getContentPane().add(lblId);
		
		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblPw.setBounds(12, 109, 111, 34);
		frame.getContentPane().add(lblPw);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblEmail.setBounds(12, 153, 111, 34);
		frame.getContentPane().add(lblEmail);
		
		txtId = new JTextField();
		txtId.setFont(new Font("굴림", Font.PLAIN, 20));
		txtId.setBounds(118, 67, 253, 34);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setFont(new Font("굴림", Font.PLAIN, 20));
		txtPw.setColumns(10);
		txtPw.setBounds(118, 109, 253, 34);
		frame.getContentPane().add(txtPw);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("굴림", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(118, 149, 253, 34);
		frame.getContentPane().add(txtEmail);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectAllData();
			}
		});
		btnSelect.setFont(new Font("굴림", Font.BOLD, 20));
		btnSelect.setBounds(12, 209, 128, 34);
		frame.getContentPane().add(btnSelect);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertMemberData();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 20));
		btnInsert.setBounds(12, 259, 128, 34);
		frame.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMemberData();
			}
		});
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 20));
		btnUpdate.setBounds(152, 259, 128, 34);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMemberData();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 20));
		btnDelete.setBounds(292, 259, 128, 34);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 303, 410, 105);
		frame.getContentPane().add(scrollPane);
		
		txtOutput = new JTextArea();
		txtOutput.setFont(new Font("Monospaced", Font.BOLD, 20));
		scrollPane.setViewportView(txtOutput);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 418, 410, 267);
		frame.getContentPane().add(scrollPane_1);
		
		String[] colLabels = {"아이디", "비밀번호", "이메일"};
		Object[][] data = {};
		tblModel = new DefaultTableModel(data, colLabels);
		tblModel.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				txtOutput.setText("테이블 수정됨");
				// update() 호출
			}
		});
		
		tblMember = new JTable(tblModel);
		tblMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowSelected = tblMember.getSelectedRow();
				colSelected = tblMember.getSelectedColumn();
				txtOutput.setText(rowSelected + ", " 
							+ colSelected + " 선택됨");
				
				txtId.setText(tblMember.getValueAt(rowSelected, 0).toString());
				txtPw.setText(tblMember.getValueAt(rowSelected, 1).toString());
				txtEmail.setText(tblMember.getValueAt(rowSelected, 2).toString());
			}
		});
		tblMember.setFont(new Font("굴림", Font.BOLD, 18));
		scrollPane_1.setViewportView(tblMember);
	} // end initialize()
	
	void initTable() {
		ArrayList<MemberModel> list = memberMgr.select();
		for (MemberModel m : list) {
			String[] rowData = {m.getId(), m.getPw(), m.getEmail()};
			tblModel.addRow(rowData);
		} // end for()
		
	} // end initTable()
	
	
	void selectAllData() {
		ArrayList<MemberModel> list = memberMgr.select();
		
		txtOutput.setText("SELECT 결과\n");
		for(MemberModel m : list) {
			String id = m.getId();
			String pw = m.getPw();
			String email = m.getEmail();
			
			txtOutput.append(id + " | " + pw + " | " + email + "\n"); 
		} // end for
		txtOutput.append(list.size() + "개 행 선택됨");
		
	} // end selectAllData()
	
	void insertMemberData() {
		String id = txtId.getText();
		String pw = txtPw.getText();
		String email = txtEmail.getText();
		
		if (!id.equals("") && !pw.equals("") && !email.equals("")) {
			// 빈 문자열이 하나도 없을 때
			int row = memberMgr.insert(id, pw, email);
			txtOutput.setText(row + "개 행(row) INSERT 성공");
			if (row > 0) {
				String[] rowData = {id, pw, email};
				tblModel.addRow(rowData);
			}
		} else {
			txtOutput.setText("빈 칸을 입력하세요");
		}
		
	} // end insertMemberData()
	
	void updateMemberData() {
		String id = txtId.getText();
		String pw = txtPw.getText();
		String email = txtEmail.getText();
		
		int row = memberMgr.update(id, pw, email);
		txtOutput.setText(row + "개 행(row) UPDATE 성공");
		
		/*
		if (!pw.equals("") && !email.equals("")) {
			memberMgr.update(id, pw, email);
		} else if(!pw.equals("") && email.equals("")) {
			memberMgr.update(id, pw, );
		} else if (pw.equals("") && !email.equals("")) {
			memberMgr.update(id, email, );
		} else {
			error();
		}
		*/
		
	} // end updateMemberData()
	
	void deleteMemberData() {
		String id = txtId.getText();
		int row = memberMgr.delete(id);
		txtOutput.setText(row + "개 행(row) DELETE 성공");
		
		if (row > 0) {
			tblModel.removeRow(rowSelected);
		}
		
	} // end deleteMemberData()
} // end class DB05MainWin














