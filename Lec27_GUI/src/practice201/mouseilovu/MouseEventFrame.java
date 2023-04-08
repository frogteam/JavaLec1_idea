package practice201.mouseilovu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *  마우스 올리면 글자가 바뀜
 */
public class MouseEventFrame extends JFrame {
	public MouseEventFrame() {
		super("마우스 올리기 내리기 연습");
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Love Java");
		label.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				JLabel la = (JLabel)e.getSource();
				la.setText("Love Java");
			}
			public void mouseExited(MouseEvent e) {
				JLabel la = (JLabel)e.getSource();
				la.setText("사랑해");
			}			
		});
		add(label);
		setSize(250,150);
		setVisible(true);
	}
	static public void main(String [] args) {
		new MouseEventFrame();
	}
}