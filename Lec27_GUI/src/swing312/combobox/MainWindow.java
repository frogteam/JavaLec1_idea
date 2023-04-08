package swing312.combobox;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

/* JComboBox<E>, 콤보박스 컴포넌트 
	'텍스트 필드'와 [▼버튼]', 
	    그리고 '드롭다운 리스트'로 구성
	    
	콤보박스 아이템 선택시 Action 이벤트 발생
	    
	생성자
		JComboBox<E>() 빈 콤보박스
		JComboBox<E>(Vector)   벡터로부터 아이템을 공급받는 콤보박스
		JComboBox<E>(Object [])   배열로부터 아이템을 공급받는 콤보박스
 */
public class MainWindow extends JFrame {
	private String[] fruits = { "apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry",
			"blackberry" };
	private String[] names = { "kitae", "jaemoon", "hyosoo", "namyun" };

	public MainWindow() {
		setTitle("콤보박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// JComboBox 생성자에 배열을 넘겨주어 콤보박스 생성 
		JComboBox<String> strCombo = new JComboBox<String>(fruits);
		c.add(strCombo);

		// JComboBox 생성후 addItem() 으로 아이템 추가
		JComboBox<String> nameCombo = new JComboBox<String>();
		for (int i = 0; i < names.length; i++)
			nameCombo.addItem(names[i]);
		c.add(nameCombo);

		setSize(300, 300);
		setVisible(true);
	} // end 생성자

	public static void main(String[] args) {
		new MainWindow();
	} // end main()

} // end class
