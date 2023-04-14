package swing206.keyevent2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/* Key Code 예제
 */
public class MainWindow extends JFrame {
	private JLabel lbl = new JLabel();
	private Container c;

	public MainWindow() {
		setTitle("Key Code 예제 : F1키:초록색, % 키 노란색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();

		// 키 리스너 등록
		c.addKeyListener(new MyKeyListener());
		
		
		// java.awt.Color 객체 : R,G,B값 색상정의 가능
		// java.awt.Font 객체 : 글꼴 객체
		Color color1 = new Color(120,255,255);
		Font font1 = new Font("Arial", Font.BOLD, 40);
		
		c.setBackground(color1);  // 하늘색 (R.G.B) 으로 시작
		lbl.setFont(font1);
		lbl.setForeground(new Color(146,24,89));
		
		
		c.add(lbl);

		setSize(450,250);
		setVisible(true);

		c.setFocusable(true);  // 키입력 받도록 포커스 주기
		c.requestFocus();
	} // end 생성자
	
	// KeyListener 의 Adapter 인 KeyAdapter 사용한 클래스 정의
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			// 글자에는 KeyCode 값에 대한 텍스트만 찍히게 함
			lbl.setText(KeyEvent.getKeyText(e.getKeyCode()));

			if(e.getKeyChar() == '%')  // 유니코드   ?? 그런데 왜 5가 찍히나
				c.setBackground(Color.YELLOW);
			else if(e.getKeyCode() == KeyEvent.VK_F1)  // 가상키코드 
				c.setBackground(Color.GREEN);
		}
	} // end MyKeyListener
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
