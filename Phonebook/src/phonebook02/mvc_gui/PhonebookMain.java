package phonebook02.mvc_gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import phonebook02.mvc.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class PhonebookMain extends JFrame {

	private PhonebookManager pbCtrl;   // CONTROLLER 객체
	
	private JPanel contentPane;
	private JTextField txtPhoneNum;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTable table;
	private JTextArea textAreaLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhonebookMain frame = new PhonebookMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	} // end main()

	/**
	 * Create the frame.
	 */
	public PhonebookMain() {
		
		pbCtrl = PhonebookManager.getInstance();   // 컨트롤러 생성
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 695);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(5, 5, 640, 113);
		panel1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel1);
		panel1.setLayout(new GridLayout(2, 3, 4, 5));
		
		JLabel lblName = new JLabel("이름");
		panel1.add(lblName);
		
		JLabel lblPhoneNum = new JLabel("전화번호");
		panel1.add(lblPhoneNum);
		
		JLabel lblEmail = new JLabel("이메일");
		panel1.add(lblEmail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 28));
		panel1.add(txtName);
		txtName.setColumns(10);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setFont(new Font("굴림", Font.PLAIN, 28));
		panel1.add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("굴림", Font.PLAIN, 28));
		panel1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(15, 125, 630, 64);
		contentPane.add(panel2);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText().trim();
				
				if(name.length() == 0) {
					textAreaLog.append("이름입력은 필수 입니다\n");
					return;
				}
				
				String phoneNum = txtPhoneNum.getText().trim(); 
				String email = txtEmail.getText().trim();
				
				int result = pbCtrl.insert(name, phoneNum, email);
				if(result == Controller.ERR_GENERIC) {
					textAreaLog.append("입력 실패\n");
				} else {			
					textAreaLog.append(result + " 개의 주소록 입력 성공\n");
					//updateTable();
					
					DefaultTableModel model =
							(DefaultTableModel) table.getModel();
					model.addRow(new String[] {name, phoneNum, email});
				}
			}
		});
		panel2.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 선택된 row 삭제
				DefaultTableModel model = 
						(DefaultTableModel) table.getModel();
				
				int index = table.getSelectedRow();
				if (index >= 0) {
					
					// CONTROLLER 에 연결  (인터페이스 로 연결된다)
					int result = pbCtrl.delete(index);
					if(result == Controller.ERR_GENERIC) {
						textAreaLog.append("삭제 실패\n");
					} else {
						
						model.removeRow(index);
						
						textAreaLog.append(result + " 개의 주소록 삭제 성공\n");
					}
				} else {
					textAreaLog.append("지울 행을 선택하지 않았습니다.\n");
				}
			}
		});
		panel2.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 216, 645, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("굴림", Font.PLAIN, 24));
		scrollPane.setViewportView(table);
		
		// 아래와 같이 하기 보단.
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				
//			},
//			new String[] {
//				"\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC774\uBA54\uC77C"
//			}
//		));
		
		// 이와 같이 하는 것을 추천
		Object [][] data = new Object[][] {};
		String[] columnNames = new String[] {
				"\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC774\uBA54\uC77C"
			};
		
		DefaultTableModel tblModel =
				new DefaultTableModel(data, columnNames);
		table.setModel(tblModel);
		// 그래야 TableModel 에 리스너 장착 가능
		tblModel.addTableModelListener(new TableModelListener() {

			// 테이블이 내용이 변화 되었을때에 호출되는 메소드
			@Override
			public void tableChanged(TableModelEvent e) {
				int col = e.getColumn();
				int firstRow = e.getFirstRow();
				int lastRow = e.getLastRow();
				int type = e.getType();
				DefaultTableModel m = (DefaultTableModel)e.getSource();
				
				// Type: DELETE(-1), UPDATE(0), INSERT(1)

//				String msg = "테이블 수정 사항:" + "\n"
//						+ "Column: " + col + "\n"
//						+ "First Row: " + firstRow + "\n"
//						+ "Last Row: " + lastRow + "\n"
//						+ "Type: " + type + "\n";
				//textAreaLog.append(msg);
				
				if(type != 0) return;   // 수정인 경우만 처리 할
				
				int index = firstRow;
				String name = (String)m.getValueAt(firstRow, 0);
				String phoneNum = (String)m.getValueAt(firstRow, 1);
				String email = (String)m.getValueAt(firstRow, 2);
				
				// CONTROLLER 에 연결  (인터페이스 로 연결된다)
				int result = pbCtrl.update(index, name, phoneNum, email);
				if(result == Controller.ERR_GENERIC) {
					textAreaLog.append("수정 실패\n");
				} else {			
					textAreaLog.append(result + " 개의 주소록 수정 성공\n");
				}				

			}
		});
		
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 415, 640, 158);
		contentPane.add(scrollPane_1);
		
		textAreaLog = new JTextArea();
		textAreaLog.setEditable(false);
		scrollPane_1.setViewportView(textAreaLog);
		table.getColumnModel().getColumn(0).setPreferredWidth(144);
		table.getColumnModel().getColumn(1).setPreferredWidth(134);
		table.getColumnModel().getColumn(2).setPreferredWidth(168);
	}
	public JTextArea getTextAreaLog() {
		return textAreaLog;
	}
	public JTable getTable() {
		return table;
	}
	
	// 테이블 업데이트
	public void updateTable() {
		PhonebookModel[] data = (PhonebookModel[])pbCtrl.searchAll();
		textAreaLog.append("총" + data.length + "명의 데이터 출력\n");
		String [][] arr = new String[data.length][3];

		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = data[i].getName();
			arr[i][1] = data[i].getPhoneNum();
			arr[i][2] = data[i].getEmail();
		} // end for
		
		DefaultTableModel model =
				(DefaultTableModel) table.getModel();
	
		model.setDataVector(arr, new String[]{"이름", "전화버호", "이메일"});
	}
	
	
} // end class
