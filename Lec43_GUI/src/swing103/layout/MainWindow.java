package swing103.layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*	레이아웃 (layout)
 	
 	컨테이너마다 LayoutManager 가 존재.
 	: add 되는 컴포넌트의 '위치'와 '크기' 결정하고 '배치'함.
 	
 	컨테이너의 크기가 변하면 내부 컴포넌트들의 위치와 크기를 모두 재조정, 재배치
 	
 	LayoutManager (I)
	 	└─FlowLayout  :  왼쪽에서 오른쪽으로, 위에서 아래로 배치
	 	└─BorderLayout : 
	 	└─GridLayout
	 	└─CardLayout

 	
 	컨테이너의 디폴트 LayoutManager
 	AWT , Swing        │    디폴트 LayoutManager   
 	───────────────────┴───────────────────────────
 	Window, JWindow         BorderLayout
 	Frame, JFrame			BorderLayout
 	Dialog, JDialog			BorderLayout
 	Panel, JPanel			FlowLayout
 	Applet, JApplet			FlowLayout
 	
 	
 	컨테이너의 layout manager 설정 --> setLayout()
 	
 	
 */

public class MainWindow {
	public static void main(String[] args) {

		new FlowLayoutFrame();

		new BorderLayoutFrame();

		new GridLayoutFrame();

		new NullContainerFrame();
		
		new BoxLayoutFrame();
		
		new GridBagLayoutFrame();

	} // end main()
} // end class

// FlowLayout 예제
class FlowLayoutFrame extends JFrame {

	public FlowLayoutFrame() {
		setTitle("FlowLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Frame 의 컨테이너 객체 가져오기
		Container c = getContentPane();
		
		//컴포넌트 객체 생성해서 컨테이너에 추가
		c.add(new JButton("add"));  // 컴포넌트 객체 생성해서 바로 컨테이너에 추가
		
		JButton btn = new JButton("sub");  // 따로 만든뒤 컨테이너에 추가
		c.add(btn);
		
		c.add(new JTextField("mul", 8));  // JTextField 컴포넌트
		
		JLabel lbl = new JLabel("div");
		c.add(new JLabel("div"));
		
		c.add(new JButton("계산"));

		// 일단 여기까지만 해서 실행해보자

		// 레이아웃 작성
		// c.setLayout(new FlowLayout());
		// FloaLayout(align, hgap, vgap) // 정렬, 좌우컴포넌트 간격, 상하컴포넌트 간격 (단위는 픽셀)
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));

		// ※ 화면을 늘렸다 줄였다 해보자.
		// 컨테이너의 크기가 변하면 컴포넌트 재배피

		setSize(400, 200);

		setVisible(true);
	}

} // end Frame

// BorderLayout 
// 컨테이너 공간을 5 구역으로 분할, 배치
//       East, West, South, North, Center
// 배치 방법
//     add(Component comp, int index)
//          comp를 index의 공간에 배치
// 컨테이너의 크기가 변하면 재배치
class BorderLayoutFrame extends JFrame {

	public BorderLayoutFrame() {
		setTitle("BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();

		c.setLayout(new BorderLayout(30, 20)); // vGap:20픽셀, hGap:30픽셀
		c.add(new JButton("계산"), BorderLayout.CENTER);
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("sub"), BorderLayout.SOUTH);
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);

		// ※ 늘렸다 줄였다 해보자
		// 한두개씩만 골라서 해보자

		setLocation(50, 50); // 시작 위치를 지정 가능
		setSize(400, 200);
		setVisible(true);
	}

} // end Frame

// GridLayout
// 컨테이너 공간을 동일한 사각형 격자(그리드)로 분할하고 각 셀에 하나의 컴포넌트 배치
// 격자 구성은 생성자에 행수와 열수 지정
// 셀에 왼쪽에서 오른쪽으로, 다시 위에서 아래로 순서대로 배치
// 컨테이너 크기가변하면 재배치

class GridLayoutFrame extends JFrame {

	public GridLayoutFrame() {
		setTitle("GridLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout grid = new GridLayout(4, 2); // (rows, cols)
		grid.setVgap(5); // 상하 컴포넌트 수직간격 (픽셀)

		Container c = getContentPane();

		c.setLayout(grid);
		c.add(new JLabel("이름"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학번"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학과"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 과목"));
		c.add(new JTextField(""));

		Point p = new Point(100, 100); // 2차원 좌표 (x, y) 를 담는 객체
		setLocation(p); // setLocation 에 Point 객체로 지정 가능
		// setLocation(100, 100);

		Dimension d = new Dimension(400, 200); // 가로x세로 (width, height) 를 담는 객체
		setSize(d); // setSize 에 Dimension 객체 지정 가능
		// setSize(400, 200);
		setVisible(true);
	}
} // end Frame

/*
 * LayoutManager 가 없는 컨테이너] 응용프로그램에서 컴포넌트의 절대 크기와 절대 위치 결정 용도] 컴포넌트의 크기나 위치를 개발자
 * 임의로 결정하고자 하는 경우 게임 프로그램과 같이 시간이나 마우스/키보드의 입력에 따라 컴포넌트들의 위치와 크기가 수시로 변하는 경우 여러
 * 컴포넌트들이 서로 겹쳐 출력하고자 하는 경우
 * 
 * 컨테이너의 LayoutManager 제거 컨테이너.setLayout(null);
 * 
 * 
 * 컴포넌트 크기 설정 : component.setSize(int width, int height); 컴포넌트 위치 설정 :
 * component.setLocation(int x, int y); 컴포넌트 위치와 크기 동시 설정 :
 * component.setBounds(int x, int y, int width, int height);
 */

class NullContainerFrame extends JFrame {
	public NullContainerFrame() {

		setTitle("NullContainer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null); // 컨테이너의 LayoutManager 제거

		// label 컴포넌트 생성하고
		JLabel lbl = new JLabel("Hello, Press Buttons");
		lbl.setLocation(130, 50); // 위치 지정
		lbl.setSize(200, 20); // 크기 지정

		c.add(lbl); // 컨테이너에 컴포넌트 추가

		for (int i = 1; i <= 9; i++) {
			JButton btn = new JButton(Integer.toString(i)); // 버튼 생성
			btn.setLocation(i * 15, i * 15);
			btn.setSize(50, 20);
			c.add(btn);
		} // end for

		setLocation(150, 150);
		setSize(400, 200);
		setVisible(true);
	}

} // end Frame

// BoxLayout
// 컴포넌트들을 세로(vertical) 혹은 가로(horizontal) 하게 배치할때 사용
// 배치값 : X_AXIS,  Y_AXIS , LINE_AXIS,  PAGE_AXIS
class BoxLayoutFrame extends JFrame {

	JButton buttons[] = new JButton[5]; // 버튼 객체

	public BoxLayoutFrame() {
		setTitle("BoxLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		for (int i = 0; i < 5; i++) {
			buttons[i] = new JButton("버튼 " + (i + 1));
			c.add(buttons[i]);
		} // end for

		c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));  // Y_AXIS : 세로배치
		
		setLocation(200, 200);
		setSize(400, 200);
		setVisible(true);
	} // end 생성자

} // end Frame

// GridBagLayout
// 컴포넌트들을 가로로, 혹은 세로로, 혹은 baseline 기준으로 정렬배치할때 사용
class GridBagLayoutFrame extends JFrame{
	public GridBagLayoutFrame() {
		setTitle("GridBagLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		GridBagLayout grid = new GridBagLayout();  // GridBagLayout
		GridBagConstraints gbc = new GridBagConstraints();  
		
		
		c.setLayout(grid);
		
		//c.add(comp)
		
		
		
		
		setLocation(250, 250);
		setSize(400, 200);
		setVisible(true);	
	} // end 생성자
} // end 클래스





// [참조]
// 프레임 창 size & position 
// https://www.leepoint.net/GUI/containers/10windows/15framesize.html
