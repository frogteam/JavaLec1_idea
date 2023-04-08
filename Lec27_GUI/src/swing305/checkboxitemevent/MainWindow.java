package swing305.checkboxitemevent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* JCheckBox에서 Item 이벤트 처리

	Item 이벤트
		체크 박스나 라디오버튼의 선택 상태가 바뀔 발생하는 이벤트
			마우스나 키보드로 체크박스를 선택 상태를 바꾸는 경우
			프로그램에서 선택 상태를 바꾸는 경우 : setSelected(true/false)

	ItemListener 인터페이스
		itemStateChenged(ItemEvent e)  체크박스의 선택/채세 상태가 변할때 호출됨

	ItemEvent의 주요 메소드
		int getStateChange()  :  ItemEvent.SELECTED, 혹은 ItemEvent.DESELECTED 리턴
		Object getItem()  : 이벤트 발생시킨 객체 리턴, 체크박스의 경우 JCheckBox 리턴  
 */

public class MainWindow extends JFrame {

	// 3개의 체크박스 컴포넌트 준비
	private JCheckBox[] fruits = new JCheckBox[3]; // 3개 배열
	private String[] names = { "사과", "배", "체리" };
	private JLabel sumLabel;

	public MainWindow() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));

		MyItemListener listener = new MyItemListener();

		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]); // 각 JCheckBox 생성
			fruits[i].setBorderPainted(true); // 외곽선 있는 체크박스
			c.add(fruits[i]);
			fruits[i].addItemListener(listener); // 이벤트 리스너 등록
		} // end for

		sumLabel = new JLabel("현재 0 원 입니다.");
		c.add(sumLabel);
		setSize(250, 200);
		setVisible(true);
	} // end 생성자

	class MyItemListener implements ItemListener {
		private int sum = 0; // 가격의 합, 초기값 0

		public void itemStateChanged(ItemEvent e) {
			// 체크 선택되었으면, 해당 가격을 합산,
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == fruits[0])
					sum += 100;
				else if (e.getItem() == fruits[1])
					sum += 500;
				else
					sum += 20000;
			} else {  // 체크 비선택되었으면, 해당 가격을 감산
				if (e.getItem() == fruits[0])
					sum -= 100;
				else if (e.getItem() == fruits[1])
					sum -= 500;
				else
					sum -= 20000;
			}
			// 계산된 가격 표시
			sumLabel.setText("현재 " + sum + "원 입니다.");
		}
	} // end Listener

	public static void main(String[] args) {
		new MainWindow();
	} // end main()

} // end class
