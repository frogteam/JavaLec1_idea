package swing601.containerchange;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/* 컨테이너 전환 하기
 * 
 */
public class MainWindow extends JFrame {

	// 3개의 패널 객체 준비
	private JPanel [] panel = new JPanel[] {
			new Panel1(),  new Panel2(),  new Panel3()
	};
	private int currentIndex = 0;
	
	// 메인윈도우 역할 하는 이 frame 객체를 싱글톤으로 설계한뒤  다른 패널 클래스에서도 접근 가능케 함
	private MainWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initMenu();
		setLayout(new BorderLayout());
		add(panel[currentIndex], BorderLayout.CENTER);   // 최초에는 panel1
	}
	private static MainWindow instance = null;
	public static MainWindow getInstance() {
		if(instance == null) {
			instance = new MainWindow();
		}
		return instance;
	}
	

	// 메뉴 클릭할때도 패널 전환되게 함.
	private class MenuAction implements ActionListener {

		private int panelIndex;

		private MenuAction(int panelIndex) {
			this.panelIndex = panelIndex;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			currentIndex = panelIndex;
			changePanel(panelIndex);
		}
	}

	private void initMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem menuItem1 = new JMenuItem("Panel1");
		JMenuItem menuItem2 = new JMenuItem("Panel2");
		JMenuItem menuItem3 = new JMenuItem("Panel3");
		menubar.add(menu);
		menu.add(menuItem1);
		menu.add(menuItem2);
		menu.add(menuItem3);
		setJMenuBar(menubar);
		menuItem1.addActionListener(new MenuAction(0));
		menuItem2.addActionListener(new MenuAction(1));
		menuItem3.addActionListener(new MenuAction(2));
	}

	// ★컨테이너 내용 바꾸기★ 
	private void changePanel(int panelIndex) {
		getContentPane().removeAll();   // 일단 frame 의 모든 컴포넌트 제거
		getContentPane().add(panel[panelIndex], BorderLayout.CENTER);  // 새로운 panel(변경한 panel) 을 추가 

		//getContentPane().doLayout();
		//update(getGraphics());
		
		// frame 화면 업데이트 해주기
		revalidate();
		repaint();
	}
	
	
	// 3개의 패널을 돌아가면서 바꾸기  (다음 패널로)
	public void nextPanel() {
		currentIndex = (currentIndex + 1) % panel.length;
		changePanel(currentIndex);
	}
	

	public static void main(String[] args) {
		MainWindow frame = MainWindow.getInstance();
		frame.setBounds(200, 200, 300, 200);
		frame.setVisible(true);
	}
}