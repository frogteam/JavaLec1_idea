package swing311.listchange;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/* 리스트의 아이템 변경
	JList<E>(Vector listData)나 JList<E>(Object [] listData)로 
	리스트가 생성되고 나면 벡터나 배열을 수정해도 리스트 수정 안됨
	
	리스트를 수정하는 간단한 방법
		JList<E>의 setListData()를 호출
		리스트에 수정된 벡터나 배열을 새로 달아주는 방법

 */
public class MainWindow extends JFrame {
	
	private JTextField tf = new JTextField(10);
	private Vector<String> v = new Vector<String>();
	private JList<String> nameList = new JList<String>(v);
	
	public MainWindow() {
		setTitle("리스트 변경 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("이름 입력 후 <Enter> 키"));
		c.add(tf);

		// Vector 초기값 몇개 입력
		v.add("황기태");
		v.add("이재문");
		
		nameList.setVisibleRowCount(5); 
		nameList.setFixedCellWidth(100);
		c.add(new JScrollPane(nameList));

		setSize(300,300);
		setVisible(true);

		// JTextField에 ActionLister 등록. <Enter> 키 처리
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				v.add(t.getText());  // 입력된 텍스트는 Vector에 추가되고
				t.setText("");
				nameList.setListData(v);  // 업데이트된 Vector를 리스트에 set(갱신) 
			}
		});
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
