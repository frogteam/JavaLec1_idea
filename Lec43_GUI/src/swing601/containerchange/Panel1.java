package swing601.containerchange;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Panel1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel1() {
		setBackground(Color.YELLOW);
		setLayout(null);
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			
			// [다음] 버튼 누르면 다음 패널로 전환
			public void actionPerformed(ActionEvent e) {
				MainWindow.getInstance().nextPanel();
			}
		});
		btnNext.setBounds(28, 70, 133, 42);
		add(btnNext);
		
		JLabel lblPanel = new JLabel("Panel1");
		lblPanel.setBounds(12, 10, 57, 15);
		add(lblPanel);

	}
}
