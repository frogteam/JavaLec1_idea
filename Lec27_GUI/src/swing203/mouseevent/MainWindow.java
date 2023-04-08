package swing203.mouseevent;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

/* 마우스 이벤트 연습
	마우스로 문자열 이동시키기 
	컨텐트팬의 아무 위치에 마우스 버튼을 누르면 
	마우스 포인트가 있는 위치로 "hello" 문자열을 옮기는 스윙 응용프로그램을 작성하라.
	
	MouseListener 를 구현한 클래스
		mousePressed() : 마우스 버튼이 눌렸을때
		mouseReleased() : 눌렸던 마우스 버튼이 떼어졌을때
		mouseClicked() = pressed + released : 클릭 
		mouseEntered() : 마우스가 컴포넌트 위에 올려졌을때
		mouseExited() : 마우스가 컴포넌트 바깥으로 나갔을때
 */
public class MainWindow extends JFrame{

	private JLabel lbl = new JLabel("Hello");
	
	public static void main(String[] args) {
		new MainWindow();
	} // end main
	
	public MainWindow() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		// 컨테이너에 마우스 이벤트 추가
		c.addMouseListener(new MyMouseListener());
		
		c.setLayout(null);
		
		// 레이블의 최초 위치
		lbl.setSize(50, 20);
		lbl.setLocation(30, 30);
		c.add(lbl);
		
		setSize(450, 250);
		setVisible(true);
	} // end 생성자
	
	// 마우스 리스너 클래스 정의 
	class MyMouseListener implements MouseListener{

		// 마우스 버튼이 눌렸을때
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("mousePressed :" + e.getX() + ":" + e.getY());
			//마우스 버튼이 눌러진 위치를 알아내어 la("hello" 문자열)를 그 위치로 옮긴다 
			int x = e.getX();
			int y = e.getY();
			lbl.setLocation(x, y);
		}

		// 눌렸던 마우스 버튼이 떼어졌을때
		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("mouseReleased :" + e.getX() + ":" + e.getY());
		}

		// mouseClicked = pressed + released
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouseClicked :" + e.getX() + ":" + e.getY());
		}
		
		// 마우스가 컴포넌트 위에 올려졌을때
		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("mouseEntered :" + e.getX() + ":" + e.getY());
		}

		// 마우스가 컴포넌트 바깥으로 나갔을때
		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("mouseExited :" + e.getX() + ":" + e.getY());
		}
		
	} // end MyMouseListener

} // end class
