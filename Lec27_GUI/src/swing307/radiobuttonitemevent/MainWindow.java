package swing307.radiobuttonitemevent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {
	
	private JRadioButton [] radio = new JRadioButton [3];
	private String [] text = {"사과", "배", "체리"};
	private ImageIcon [] image = {
							new ImageIcon("images/apple.jpg"),
							new ImageIcon("images/pear.jpg"),
							new ImageIcon("images/cherry.jpg")};
	private JLabel imageLabel = new JLabel();

	public MainWindow() {
		setTitle("라디오버튼 Item Event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		// 라디오 버튼을 담을 패널 생성
		JPanel radioPanel = new JPanel(); 
		radioPanel.setBackground(Color.GRAY);
		
		ButtonGroup g = new ButtonGroup();  // 그룹 생성

		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]); // 라디오 버튼 생성
			g.add(radio[i]); // 그룹에 추가
			radioPanel.add(radio[i]);  // 라디오버튼은 패널에 추가
			radio[i].addItemListener(new MyItemListener());  // 라디오버튼에 이벤트 리스너 장착
		}
		radio[2].setSelected(true);   // 최초 선택 --> 이벤트 발생시킴
		
		// 화면 전체 레이아웃은  
		c.add(radioPanel, BorderLayout.NORTH); 
		c.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		setSize(450,300);
		setVisible(true);
	} // end 생성자
	
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED)
				return; 
			// 무
			if(radio[0].isSelected())
				imageLabel.setIcon(image[0]);
			else if(radio[1].isSelected())
				imageLabel.setIcon(image[1]);
			else
				imageLabel.setIcon(image[2]);
		}
	} // end Listener
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main
	
} // end class
