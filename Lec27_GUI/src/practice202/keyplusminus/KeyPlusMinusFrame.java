package practice202.keyplusminus;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * 
 */

public class KeyPlusMinusFrame extends JFrame {
	public KeyPlusMinusFrame() {
		super("+,- 키로 폰트 크기 조절");
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Love Java");
		label.setFont(new Font("TimesRoman", Font.PLAIN, 10)); // 10 픽셀 크기

		label.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '+') {
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					la.setFont(new Font("TimesRoman", Font.PLAIN, size + 5));
				} else if (e.getKeyChar() == '-') {
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					if (size <= 5)
						return;
					la.setFont(new Font("TimesRoman", Font.PLAIN, size - 5));
				}
			}
		});
		add(label);
		setSize(300, 150);
		setVisible(true);
		label.requestFocus();
	}

	static public void main(String[] args) {
		new KeyPlusMinusFrame();
	}
}