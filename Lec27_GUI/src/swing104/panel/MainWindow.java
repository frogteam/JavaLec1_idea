package swing104.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* JPanel : 컨테이너 역할을 하는 클래스
 	
 	다른 컨테이들처럼 컴포넌트들을 담을수 있다.
 	JPanel 내의 디폴트 레이아웃은 FlowLayout,  레이아웃 변경 가능
 	
 	프레임에 panel 들을 컴포넌트처럼 배치하고
 	각 panel 안에  또다시 panel 을 배치함으로 
 	복잡한 레이아웃 (중첩 레이아웃) 구성 가능.
 */
public class MainWindow {
	public static void main(String[] args) {
		new PanelFrame1();
		//new PanelFrame2();
	} // end main

} // end class

class PanelFrame1 extends JFrame {

	public PanelFrame1() {
		setTitle("panel 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// panel 생성
		JPanel p = new JPanel();
		p.setBounds(40, 80, 200, 200);  // 무엇에 대한 위치?  부모(프레임)에 대해서
		
		p.setBackground(Color.gray);
		
		// 컴포넌트들 생성
		JButton b1 = new JButton("Button 1");
		b1.setBounds(50, 100, 80, 30);  // 무엇에 대한 좌표?
		//b1.setSize(80, 30);
		b1.setBackground(Color.yellow);
		
		JButton b2 = new JButton("Button 2");
		b2.setBounds(100, 100, 80, 30);
		//b2.setSize(80, 30);
		b2.setBackground(Color.green);
		
		
		
		JTextField t1 = new JTextField("0", 10); // (최초 문자열, 입력 column 수)
		t1.setHorizontalAlignment(JTextField.RIGHT); // 입력이 우측 정렬되게 하기
		//t1.setLocation(70, 10);
		t1.setBounds(50, 10, 80, 30);

		// 컴포넌트들을 panel 에 추가
		p.setLayout(null);
		p.add(b1);
		p.add(b2);
		p.add(t1);

		// panel 을 프레임에 추가
		add(p);
		
		setLayout(null);    
		setSize(400,400);    
		setResizable(false); // 사이즈 조정 못하게 설정하기
        setVisible(true);

	} // end 생성자

} // end Frame

class PanelFrame2 extends JFrame {
	// 멤버 변수 선언
	public JTextField text;
	public boolean mode = false;
	public double operand1 = 0;
	public double operand2 = 0;
	public String operator = "";

	public PanelFrame2() {
		super("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		makeLayout(); // 레이아웃이 복잡해지면 별도의 메소드로 정의하자.

		pack(); // 최적 사이즈로 사이즈 자동 조정
		setResizable(false); // 사이즈 조정 못하게 설정하기

		setVisible(true);
	} // end 생성자

	public void makeLayout() {
		JPanel panel = new JPanel(); // JPanel 도 Container 역할
		text = new JTextField("0", 17); // (최초 문자열, 입력 column 수)
		text.setHorizontalAlignment(JTextField.RIGHT); // 입력이 우측 정렬되게 하기

		panel.add(text); // Panel 에 TextField 추가
		add(panel, "North"); // Frame 에 panel 추가, JFrame 의 디폴트 레이아웃은 BorderLayout !!

		// 버튼 크기를 같게 하기 위해서..
		Dimension d = new Dimension(45, 30); // width, height 정보를 담는 객체

		// 연산 버튼 생성
		JButton operator[] = new JButton[6];
		operator[0] = new JButton("+");
		operator[1] = new JButton("-");
		operator[2] = new JButton("*");
		operator[3] = new JButton("/");
		operator[4] = new JButton("=");
		operator[5] = new JButton("C");

		for (int i = 0; i < 6; i++) {
			operator[i].setPreferredSize(d); // 버튼 크기 설정
			// operator[i].addActionListener(this);
		}

		// 숫자 버튼 생성
		JButton[] button = new JButton[10];
		for (int i = 0; i < 10; i++) {
			button[i] = new JButton(i + "");
			button[i].setPreferredSize(d);
			// button[i].addActionListener(this);
		}

		// 버튼을 넣을 서브 패널 생성
		JPanel[] p = new JPanel[4];
		for (int i = 0; i < 4; i++) {
			p[i] = new JPanel();
			p[i].setLayout(new FlowLayout());
			p[i].setAlignmentX(JPanel.LEFT_ALIGNMENT);
		}

		p[0].add(button[7]);
		p[0].add(button[8]);
		p[0].add(button[9]);
		p[0].add(operator[0]);

		p[1].add(button[4]);
		p[1].add(button[5]);
		p[1].add(button[6]);
		p[1].add(operator[1]);

		p[2].add(button[1]);
		p[2].add(button[2]);
		p[2].add(button[3]);
		p[2].add(operator[2]);

		p[3].add(button[0]);
		p[3].add(operator[3]);
		p[3].add(operator[4]);
		p[3].add(operator[5]);

		// 패널 생성
		JPanel pad = new JPanel(); // JPanel 도 Container 역할
		pad.setLayout(new BoxLayout(pad, BoxLayout.Y_AXIS)); // Y_AXIS 세로 방향

		for (int i = 0; i < 4; i++)
			pad.add(p[i]);

		add(pad, BorderLayout.CENTER);

	} // end makeLayout()
} // end Frame
