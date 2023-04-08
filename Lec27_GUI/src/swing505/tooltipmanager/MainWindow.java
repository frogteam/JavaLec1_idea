package swing505.tooltipmanager;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ToolTipManager;

/*  ToolTipManager 툴팁 제어
 	툴팁 활성화 및 툴팁 지연 시간 제어 
 	
	툴팁 매니저 객체 생성
		ToolTipManager m = ToolTipManager.sharedInstance();
	
	툴팁 활성화/비활성화
		m.setEnabled(false); // 툴팁이 보이지 않게 함
	
	툴팁이 나타나는 최초 지연시간 제어
		m.setInitialDelay(1000)  // 마우스가 올라온 후 1000 ms 후에 툴팁 출력
	
	툴팁이 켜져 있는 지연 시간 제어
		m.setDismissDelay(1000) // 툴팁이 켜져 있는 지속 시간을 1000ms로 설정
 */
public class MainWindow extends JFrame {
	Container c;

	public MainWindow() {
		setTitle("툴팁  지연 시간 제어 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel cherryLabel = new JLabel(new ImageIcon("images/cherry.jpg"));
		cherryLabel.setToolTipText("체리 이미지 어때요");
		JLabel appleLabel = new JLabel(new ImageIcon("images/apple.jpg"));
		appleLabel.setToolTipText("사과 이미지 어때요");
		
		c.add(cherryLabel);
		c.add(appleLabel);

		//툴팁 매니저 객체 생성
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);  // 툴팁이 나타나는 최초 지연시간, 0 이면 즉시 등장
		m.setDismissDelay(5000);  // 툴팁이 켜져 있는 지속 시간을 5000ms(5초)로 설정

		setSize(400,200);
		setVisible(true);
	} // end 생성자

	public static void main(String [] args) {
		new MainWindow();
	} // end main
	
} // end class
