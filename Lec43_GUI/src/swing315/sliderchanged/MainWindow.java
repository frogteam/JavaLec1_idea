package swing315.sliderchanged;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* JSlider와 Change 이벤트

	Change 이벤트
		JSlider의 값(value)이 바뀌면 발생 
			사용자가 슬라이더의 손잡이를 움직이는 경우
			JSlider의 setValue(int n)를 호출하여 값(value 필드)이 바뀌는 경우

	ChangeListener 리스너
		stateChanged(ChangeEvent)
 */
public class MainWindow extends JFrame {
	private JLabel colorLabel;
	private JSlider [] sl = new JSlider [3];
	
	public MainWindow() {
		setTitle("슬라이더와 ChangeEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		colorLabel = new JLabel(" SLIDER EXAMPLE ");
		
		// 슬라이더 생성
		for(int i=0; i<sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].addChangeListener(new MyChangeListener()); // 이벤트 리스너 장착!
			c.add(sl[i]);
		} // end for
		
		// 슬라이더에 표시되는 글자색 변경
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.GREEN);
		sl[2].setForeground(Color.BLUE);

		// 최초 초깃값으로 (r,g,b) 색상 설정
		int r = sl[0].getValue(); 
		int g = sl[1].getValue(); 
		int b = sl[2].getValue(); 

		// 레비을 색상 변경
		colorLabel.setOpaque(true); 
		colorLabel.setBackground(new Color(r,g,b));
		c.add(colorLabel);
		
		setSize(320,230);
		setVisible(true);
	}
	
	class MyChangeListener implements ChangeListener {
		// 슬라이더 값이 변경될때마다 호출
		public void stateChanged(ChangeEvent e) {
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			colorLabel.setBackground(new Color(r,g,b)); // 레이블 색상 변경
		}
	} // end Listener
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main()
	
} // end class
