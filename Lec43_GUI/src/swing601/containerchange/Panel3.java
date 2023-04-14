package swing601.containerchange;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel3 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel3() {
		setBackground(Color.GREEN);
		setLayout(null);
		
		JLabel lblPanel = new JLabel("panel 3");
		lblPanel.setBounds(12, 20, 57, 15);
		add(lblPanel);
		
		JButton btnNext = new JButton("다음");
		btnNext.addActionListener(new ActionListener() {
			// [다음] 버튼 누르면 다음 패널로 전환
			public void actionPerformed(ActionEvent e) {
				MainWindow.getInstance().nextPanel();
			}

		});
		btnNext.setBounds(12, 45, 97, 23);
		add(btnNext);

	}

}
