package oracle.db07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PbMainWin {

	private PhonebookControl pbMgr;
	
	private JFrame frame;
	private JTable tblPhonebook;
	private DefaultTableModel tableModel;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;

	private int rowSelected;
	private int colSelected;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PbMainWin window = new PbMainWin();
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
	public PbMainWin() {
		pbMgr = PhonebookControl.getInstance();
		initialize();
		initTable();
	}
	
	private void initTable() {
		ArrayList<PhonebookModel> list = pbMgr.select();
		for (PhonebookModel p : list) {
			String name = p.getName();
			String phone = p.getPhone();
			String email = p.getEmail();
			
			String[] rowData = {name, phone, email};
			tableModel.addRow(rowData);
		} // end for ()
		System.out.println(list.size() + "개 데이터 SELECT");
		
	} // end initTable()

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("전화번호부 ver0.8");
		lblTitle.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 410, 42);
		frame.getContentPane().add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 64, 410, 244);
		frame.getContentPane().add(scrollPane);

		String[] colNames = {"이름", "전화번호", "이메일"};
		Object[][] data = {};
		tableModel = new DefaultTableModel(data, colNames);
		tableModel.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				int row = e.getFirstRow();
				int col = e.getColumn();
				System.out.println("ROW: " + row
						+ ", COL: " + col + " 수정됨");
				// JTable에 추가, 삭제, 변경이 발생했을 때
				// tableChanged가 호출된다.
				// 추가/삭제 -> row = 추가/삭제된 행번호, col = -1
				// 변경 -> 변경된 row, col 번호를 알 수 있다.
				
				if (col >= 0) {
					updatePbData(row, col);
				}
			}
		});
		
		tblPhonebook = new JTable(tableModel);
		tblPhonebook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowSelected = tblPhonebook.getSelectedRow();
				colSelected = tblPhonebook.getSelectedColumn();
				System.out.println("ROW: " + rowSelected
						+ ", COL: " + colSelected + " 선택됨");
			}
		});
		tblPhonebook.setFont(new Font("굴림", Font.PLAIN, 18));
		scrollPane.setViewportView(tblPhonebook);
		
		JLabel lblName = new JLabel("이름");
		lblName.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 328, 128, 42);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhone = new JLabel("전화번호");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblPhone.setBounds(12, 380, 128, 42);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblEmail.setBounds(12, 432, 128, 42);
		frame.getContentPane().add(lblEmail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.BOLD, 20));
		txtName.setBounds(132, 328, 290, 42);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("굴림", Font.BOLD, 20));
		txtPhone.setColumns(10);
		txtPhone.setBounds(132, 380, 290, 42);
		frame.getContentPane().add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("굴림", Font.BOLD, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(132, 432, 290, 42);
		frame.getContentPane().add(txtEmail);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertPbData();
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 20));
		btnInsert.setBounds(10, 488, 199, 50);
		frame.getContentPane().add(btnInsert);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePbData();
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 20));
		btnDelete.setBounds(223, 488, 199, 50);
		frame.getContentPane().add(btnDelete);
	
	} // end initialize()
	
	private void insertPbData() {
		String name = txtName.getText();
		String phone = txtPhone.getText();
		String email = txtEmail.getText();
		
		// Exception 처리 필요
		int rslt = pbMgr.insert(name, phone, email);
		System.out.println("INSERT 결과: " + rslt);
		if (rslt > 0) {
			System.out.println("DB INSET 성공");
			String[] rowData = {name, phone, email};
			tableModel.addRow(rowData);
			
		} // end if
		
	} // end insertPbData()
	
	private void deletePbData() {
		String name = tblPhonebook.getValueAt(rowSelected, 0).toString();
		System.out.println("삭제할 이름: " + name);
		int rslt = pbMgr.delete(name);
		
		if (rslt > 0) {
			System.out.println("DB DELETE 성공");
			tableModel.removeRow(rowSelected);
		} // end if ()
		
	} // end deletePbData()
	
	private void updatePbData(int row, int col) {
		String name = tblPhonebook.getValueAt(row, 0).toString();
		String phone = tblPhonebook.getValueAt(row, 1).toString();
		String email = tblPhonebook.getValueAt(row, 2).toString();
		
		int rslt = pbMgr.update(name, phone, email);
		if (rslt > 0) {
			System.out.println("DB UPDATE 성공");
		}
		
	} // end updatePbData()
	
} // end class PbMainWin












