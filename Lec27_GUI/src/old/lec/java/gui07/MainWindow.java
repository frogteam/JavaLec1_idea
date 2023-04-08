package old.lec.java.gui07;

import java.awt.EventQueue;

import javax.security.auth.callback.TextOutputCallback;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTable table;
	private JTextArea textOutput;

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
		frame.setBounds(100, 100, 784, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 746, 112);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		Object[][] data = {
				{"QWERTY", "010-1111-2222", "qwerty@test.com"},
				{"ASDF", "+82-10-1234-5678", "asdf@naver.com"},
				{"ZXCV", "02-1234-5555", "zxcv@daum.net"},
		};
		String[] columnNames = {
				"Name", "Phone no.", "Email"
		};
		DefaultTableModel tblModel =
				new DefaultTableModel(data, columnNames);
		tblModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				int col = e.getColumn();
				int firstRow = e.getFirstRow();
				int lastRow = e.getLastRow();
				int type = e.getType();
				// Type: DELETE(-1), UPDATE(0), INSERT(1)
				
				String msg = "테이블 수정 사항:" + "\n"
						+ "Column: " + col + "\n"
						+ "First Row: " + firstRow + "\n"
						+ "Last Row: " + lastRow + "\n"
						+ "Type: " + type + "\n";
				textOutput.setText(msg);
			}
		});
		
		table.setModel(tblModel);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				textOutput.setText(row + "행, " + col + "열 선택" + "\n");
				textOutput.append(table.getValueAt(row, col).toString() + "\n");
				
				for (int i = 0; i < table.getColumnCount(); i++) {
					textOutput.append(table.getValueAt(row, i).toString() + " | ");
				}
				
			}
		});
		
		
		table.setFont(new Font("굴림", Font.PLAIN, 20));
		scrollPane.setViewportView(table);
		
		JButton btnInsert = new JButton("입력");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] rowData = {
						"AAAAA", "010-9876-5432", "aaaaa@test.com"
				};
				
				DefaultTableModel model =
						(DefaultTableModel) table.getModel();
				model.addRow(rowData);
			}
		});
		btnInsert.setFont(new Font("굴림", Font.BOLD, 20));
		btnInsert.setBounds(10, 158, 151, 49);
		frame.getContentPane().add(btnInsert);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = 
						(DefaultTableModel) table.getModel();
				
				if (table.getSelectedRow() >= 0) {
					model.removeRow(table.getSelectedRow());
				} else {
					textOutput.setText("지울 행을 선택하지 않았습니다.");
				}
			}
		});
		btnDelete.setFont(new Font("굴림", Font.BOLD, 20));
		btnDelete.setBounds(173, 158, 135, 49);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 242, 746, 143);
		frame.getContentPane().add(scrollPane_1);
		
		textOutput = new JTextArea();
		textOutput.setEditable(false);
		textOutput.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		scrollPane_1.setViewportView(textOutput);
	}
}
