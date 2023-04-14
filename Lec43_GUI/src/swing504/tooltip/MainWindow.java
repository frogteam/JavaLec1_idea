package swing504.tooltip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/* 툴팁 JToolTip
 	스윙 컴포넌트를 설명하는 팁 문구
		팁 문구는 문자열만 가능
	컴포넌트 위에 마우스를 올리면 잠깐 나타났다가 사라짐

	툴팁 생성
		1. JToolTip 클래스 이용(복잡하므로 권하지 않음)
		2. JComponent.setToolTipText(String msg) 이용 : 권장

 */
public class MainWindow extends JFrame {
	
	Container c;
	
	public MainWindow() {
		setTitle("툴팁  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		
		createToolBar();  // 툴바 생성
		
		setSize(450,200);
		setVisible(true);
	} // end 생성자

	void createToolBar() {
		JToolBar bar = new JToolBar("Kitae Menu");
		bar.setBackground(Color.LIGHT_GRAY);
		JButton newBtn = new JButton("New");
		newBtn.setToolTipText("파일을 생성합니다.");  // 툴팁
		bar.add(newBtn);

		JButton openBtn = new JButton(new ImageIcon("images/open.jpg"));
		openBtn.setToolTipText("파일을 엽니다.");   // 툴팁
		bar.add(openBtn);
		bar.addSeparator();

		JButton saveBtn = new JButton(new ImageIcon("images/save.jpg"));
		saveBtn.setToolTipText("파일을 저장합니다.");   // 툴팁
		bar.add(saveBtn);

		bar.add(new JLabel("search"));

		JTextField tf = new JTextField("text field");
		tf.setToolTipText("찾고자하는 문자열을 입력하세요");  // 툴팁
		bar.add(tf);
		c.add(bar, BorderLayout.NORTH);
	} // end createToolBar()

	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
