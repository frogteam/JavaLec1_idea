package swing313.comboboxaction;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* JComboBox<E>와 Action 이벤트
	콤보박스의 아이템 선택시 Action 이벤트 발생
	
	현재 선택된 아이템 알아내기
		JComboBox<E>의 다음 메소드 활용
		
		int getSelectexIndex()  선택상태인 아이템의 인덱스 번호 리턴
		Object getSelectedItem()  선택상태인 아이템 객체의 레퍼런스 리턴
 */
public class MainWindow extends JFrame {
	private String [] fruits = {"apple", "banana", "kiwi", "mango"};
	private ImageIcon [] images = { new ImageIcon("images/apple.jpg"),
													new ImageIcon("images/banana.jpg"),
													new ImageIcon("images/kiwi.jpg"),
													new ImageIcon("images/mango.jpg")};
	private JLabel imgLabel = new JLabel(images[0]); 
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);

	public MainWindow() {
		setTitle("콤보박스 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		c.add(imgLabel);

		// 리스너 등록 : 아이템 선택하면 실행됨
		strCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int index = cb.getSelectedIndex();  // 선택상태인 아이템의 인덱스 번호 리턴
				imgLabel.setIcon(images[index]);   // 이미지 배열에서 골라 표시하기 
			}
		});
		
		setSize(300,250);
		setVisible(true);
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main
	
} // end class
