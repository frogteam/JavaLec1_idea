package swing208.mouseevent1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/* 마우스 이벤트와 리스너
 	
 	리스너에는 MouseListener 와 MouseMotionListener 두가지가 있다.
 	※ppt 참조※
 	
 	마우스가 눌러진 위치에서 떼어지는 경우 메소드 호출 순서
		mousePressed(), mouseReleased(), mouseClicked()

	마우스가 드래그될 때 호출되는 메소드 호출 순서
		mousePressed(), mouseDragged(), mouseDragged(),..., mouseDragged(), mouseReleased()
		
		
	마우스 리스너 등록
		MouseListener의 5 개의 이벤트를 처리하는 경우
			mouseEntered(), mouseExited(), mousePressed(), mouseReleased(), mouseClicked()
		마우스 리스너 등록
			addMouseListener(MouseListener);

		MouseMotionListener의 이벤트도 함께 처리하고자 하는 경우
			mouseDragged(), mouseMoved()
		마우스 모션 리스너 등록 필요
			addMouseMotionListener(MouseMotionListener);
			
	MouseEvent 객체로부터 얻을 수 있는 정보
		마우스 포인터의 위치
			int getX(), int getY(), 
			Point getPoint()
			
		입력된 마우스 버튼
			int getButton()

		마우스 클릭 횟수
			int getClickCount()  <-- 이 값이 2 이면 더블클릭이다
	
 */
public class MainWindow extends JFrame {
	
	private JLabel ldl = new JLabel("No Mouse Event");

	public MainWindow() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		// MouseListener 와 MoustMotionListener 등록
		MyMouseListener listener = new MyMouseListener();
		
		c.addMouseListener(listener);   // MouseListener 등록
		c.addMouseMotionListener(listener);  // MoustMotionListener 등록

		ldl.setSize(100, 30);
		ldl.setFont(new Font("Serif", Font.PLAIN, 30));
		c.add(ldl);

		setSize(400, 400);
		setVisible(true);
	}

	// 마우스 리스너 객체 생성
	// ※ 각 이벤트 상황에 대해 동작하기 위해 Adapter 사용하지 않음
	class MyMouseListener implements MouseListener, MouseMotionListener {
		
		// 아래 각 상황에 대해 
		
		// 마우스가 눌려진 순간
		public void mousePressed(MouseEvent e) {
			ldl.setText("mousePressed (" + e.getX() + ", " + e.getY() + ")");
		}

		// 눌러진 버튼이 떼어진 순간
		public void mouseReleased(MouseEvent e) {
			ldl.setText("MouseReleased(" + e.getX() + ", " + e.getY() + ")");
		}

		public void mouseClicked(MouseEvent e) {
			
			// 더블클릭 처리하면 좋을텐데  (다음 예제에서)
			
		}

		// 마우스가 패널 안에 들어서면 배경색 cyan 색으로
		public void mouseEntered(MouseEvent e) {
			Component c = (Component) e.getSource();
			c.setBackground(Color.CYAN);
		}

		// 마우스가 패널 바깥으로 나가면 배경색 노랑색으로 
		public void mouseExited(MouseEvent e) {
			Component c = (Component) e.getSource();
			c.setBackground(Color.YELLOW);
		}

		// 마우스가 패널위에서 드래그 하는 동안
		public void mouseDragged(MouseEvent e) {
			ldl.setText("MouseDragged (" + e.getX() + "," + e.getY() + ")");
		}

		// 마우스가 패널위에서 이동하는 동안
		public void mouseMoved(MouseEvent e) {
			ldl.setText("MouseMoved (" + e.getX() + "," + e.getY() + ")");
		}
	} // end Listener

	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
