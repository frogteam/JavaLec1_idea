package practice203.click;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClickPracticeFrame extends JFrame {
	public ClickPracticeFrame() {
		super("클릭 연습 용 응용프로그램");
		setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("C");
		label.setLocation(100, 100);
		label.setSize(20, 20);
		label.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				JLabel la = (JLabel) e.getSource();
				Container c = la.getParent();
				int xBound = c.getWidth() - la.getWidth(); // 레이블의 폭 만큼 감소
				int yBound = c.getHeight() - la.getHeight(); // 레이블의 높이 만큼 감소
				int x = (int) (Math.random() * xBound);
				int y = (int) (Math.random() * yBound);
				la.setLocation(x, y);
			}
		});
		add(label);
		setSize(300, 300);
		setVisible(true);
	}

	static public void main(String[] args) {
		new ClickPracticeFrame();
	}
}