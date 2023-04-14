package swing202.timerevent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/* javax.swing.Timer 객체 
 * 일정 시간 간격으로 등록된 ActionListener 의 actionPerformed() 실행
 */
public class TimerEx {
	public static void main(String[] args) {
		new MainWindow();		
	} // end main
} // end class

class MainWindow extends JFrame{
	
	ActionListener timerListener;
	JLabel lbl = new JLabel();
	JButton btn = new JButton("클릭");
	
	// javax.swing.Timer 객체 
	Timer t1 = null;
	Timer t2 = null;
	
	public MainWindow() {
		setTitle("Timer 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
	
		lbl.setFont(new Font("Verdana", Font.BOLD, 30));
		c.add(lbl, BorderLayout.CENTER);
		c.add(btn, BorderLayout.SOUTH);
		
		//1초 간격으로 동작하는 Timer 설정 : 시간 표시
		timerListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date now = new Date();  // 현재 날짜, 시간 객체
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String strNow = fmt.format(now);
				lbl.setText(strNow);
			}
		};
		
		// import javax.swing.Timer
		t1 = new Timer(1000, timerListener); // 1초마다 반복
		t1.start();
		
		
		// 버튼 누르면 5초뒤 창이 켜지게 하자
		btn.addActionListener((e)->{
			if(t2 == null) {
				t2 = new Timer(5000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new SubWindow();
					}
					
				});
				t2.setRepeats(false);  // 반복 안함 설정
				t2.start();
				
				btn.setEnabled(false);
			} // end if
		});
		

		setSize(450, 250);
		setVisible(true);
	} // end 생성자
	
	class SubWindow extends JFrame{
		public SubWindow() {
			setTitle("타이머");
			Container c = getContentPane();
			
			c.add(new JLabel("짜잔"));
			
			setSize(450, 250);
			setLocation(500, 50); // 시작 위치
			setVisible(true);
			
			btn.setEnabled(true); // 버튼 활성화
			t2 = null;   // t2 타이머 null 로
		} // end 생성자
	} // end SubWindow
	
} // end MainWindow


