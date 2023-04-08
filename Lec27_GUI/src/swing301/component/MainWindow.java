package swing301.component;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/* 기본적인 컴포넌트 :

	GUI를 구성하는 2 가지 방법
		1. 컴포넌트 기반 GUI 프로그래밍
			스윙 패키지에 주어진 GUI 컴포넌트 이용
			GUI 구성이 쉽다.
			자바 패키지에 제공하는 GUI 컴포넌트 한계
			일반적인 GUI 프로그램에 적합
		2. 그래픽 기반 GUI 프로그래밍
			선, 원, 도형, 이미지를 직접 그려는 그래픽 화면 구성
			개발자의 작업 부담 높음
			자바 패키지에 없는 독특한 GUI 구성 가능
			게임 등 자유로운 GUI

	기초적인 스윙 컴포넌트와 상속 관계 (*ppt)
	
	스윙 컴포넌트 의 공통 메소드들 (JComponent 의 메소드)  (*ppt)
 */
public class MainWindow extends JFrame {

	public MainWindow() {
		super("JComponent의 공통 메소드 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// JButton 컴포넌트 3개 준비
		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton(" Disabled Button ");
		JButton b3 = new JButton("getX(), getY()");
	
		// 컴포넌트의 메소드들 
		b1.setBackground(Color.YELLOW); // 배경색 설정
		b1.setForeground(Color.MAGENTA); // 글자색 설정
		b1.setFont(new Font("Arial", Font.ITALIC, 20)); // Arial, 20픽셀 폰트 설정
		b2.setEnabled(false); // 버튼 비활성화
	
		// b3 버튼을 클릭하면 b3 의 좌표가 프레임 타이틀에 표시 되게 리스너 등록
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				MainWindow frame = (MainWindow)b.getTopLevelAncestor();
				frame.setTitle(b.getX() + "," + b.getY()); // 타이틀에 버튼 좌표 출력
			}
		});
		
		c.add(b1); c.add(b2); c.add(b3); // 컨텐트팬에 버튼 부착
		
		setSize(450,300);
		setVisible(true);
	} // end 생성자
	
	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
