package swing502.menuaction;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

/* 메뉴에 Action 이벤트 달기

	ActionListener 이용
		각 'JMenuItem' 컴포넌트에 Action 이벤트 리스너 설정
		메뉴 아이템이 선택되었을 때 Action 이벤트 리스너 호출

 */

public class MainWindow extends JFrame {
	
	Container c;
	JLabel label = new JLabel("Hello");

	public MainWindow() {
		setTitle("Menu 만들기  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);  // 처음에는 세로정렬 중앙에
		c.add(label, BorderLayout.CENTER);
		createMenu();
		setSize(250, 200);
		setVisible(true);
	} // end 생성자

	void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem[] menuItem = new JMenuItem[4];
		String[] itemTitle = { "Color", "Font", "Top", "Bottom" };
		JMenu fileMenu = new JMenu("Text");
		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new MenuActionListener()); // 리스너 등록
			fileMenu.add(menuItem[i]);
		}
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	} // end createMenu()

	// 메뉴 ActionListener
	class MenuActionListener implements ActionListener {
		
		// 메뉴 선택할때마다 호출됨
		public void actionPerformed(ActionEvent e) {
			
			String cmd = e.getActionCommand(); // 선택한 메뉴의 텍스트 리턴
			
			if (cmd.equals("Color"))
				label.setForeground(Color.BLUE);  // 글자색 변경
			else if (cmd.equals("Font"))
				label.setFont(new Font("Ravie", Font.ITALIC, 30));  // 글꼴 변경
			else if (cmd.equals("Top"))
				label.setVerticalAlignment(SwingConstants.TOP);  // 세로정렬, 맨 위로
			else
				label.setVerticalAlignment(SwingConstants.BOTTOM);  // 세로정렬, 바닥으로
		}
		
	} // end Listener

	public static void main(String[] args) {
		new MainWindow();
	} // end main()

} // end class
