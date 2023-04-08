package swing601.containerchange;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel2 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel2() {
		setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel lblPanel = new JLabel("Panel 2");
		lblPanel.setBounds(12, 10, 57, 15);
		add(lblPanel);
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			// [다음] 버튼 누르면 다음 패널로 전환
			public void actionPerformed(ActionEvent e) {
				MainWindow.getInstance().nextPanel();
			}

		});
		btnNext.setBounds(12, 35, 97, 23);
		add(btnNext);

	}

}
