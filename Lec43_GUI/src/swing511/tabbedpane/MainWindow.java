package swing511.tabbedpane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/* JTabbedPane
	여러 패널을 겹치게 하여 공간을 공유하도록 지원하는 팬

	생성자
		JTabbedPane()
		JTabbedPane(int tabPlacement)
			tabPlacement : 
				JTabbedPane.TOP, JTabbedPane.BOTTOM, 
				JTabbedPane.LEFT, JTabbedPane.RIGHT

	탭 만들어 탭팬에 붙이기
		void addTab(String title, Component comp)
			title : 탭의 이름, comp : 탭을 구성하는 컴포넌트
	
	탭팬에 붙은 탭의 개수
		int getTabCount() - 탭팬에 붙은 탭의 개수 리턴
	현재 선택된 탭
		int getSelectedIndex()
		Component getSelectedComponent()
	탭 삭제
		void remove(Component comp)
		void remove(int index)
		void removeTabAt(int index)
	탭 위치 변경
		void setTabPlacement(int tabPlacement)
 */

public class MainWindow extends JFrame {
	Container c;

	public MainWindow() {
		setTitle("탭팬 만들기  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		// 탭팬 생성
		JTabbedPane pane = createTabbedPane();
		c.add(pane, BorderLayout.CENTER);
		
		setSize(250,200);
		setVisible(true);
	} // end 생성자

	JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);  // 탭이 왼쪽으로
		pane.addTab("tab1", new JLabel(new ImageIcon("images/img1.jpg")));
		pane.addTab("tab2", new JLabel(new ImageIcon("images/img2.jpg")));
		pane.addTab("tab3", new MyPanel());
		return pane;
	} // end createTabbedPane()

	// Panel 생성
	class MyPanel extends JPanel {
		MyPanel() {
			this.setBackground(Color.YELLOW);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 50, 50);
			g.setColor(Color.BLUE);
			g.fillOval(10, 70, 50, 50);
			g.setColor(Color.BLACK);
			g.drawString("tab 3에 들어가는 JPanel 입니다.", 30, 50);
		}
	} // end class MyPanel

	public static void main(String[] args) {
		new MainWindow();
	} // end main()
} // end class
