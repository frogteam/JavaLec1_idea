package swing507.modal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/* 모달 다이얼로그와 모달리스 다이얼로그
	모달(modal) 다이얼로그
		사용자 입력을 독점하는 다이얼로그
		닫기 전에는 다른 창에서 작업을 전혀 할 수 없는 다이얼로그
		생성 방법
			JDialog(Frame owner, String title, boolean modal) 생성자에서 modal을 true 값으로 지정
	모달리스 다이얼로그
		다른 창과 독립적으로 작동하는 다이얼로그
 */

// 다이얼로그 클래스
class MyModalDialog extends JDialog {
	JTextField tf = new JTextField(10);
	JButton okButton = new JButton("OK");

	public MyModalDialog(JFrame frame, String title) {
		super(frame, title, true); // 모달 다이얼로그로 설정!  
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200, 100);

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	} // end 생성자

	// 대화상자에서 입력한 값을 리턴
	String getInput() {
		if (tf.getText().length() == 0)
			return null;
		else
			return tf.getText();
	} // end getInput()
} // end MyModalDialog class

public class MainWindow extends JFrame {
	
	MyModalDialog dialog = new MyModalDialog(this, "Test Modal Dialog");

	public MainWindow() {
		super("DialogEx2 예제 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Modal Dialog");
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				// 모달 다이얼로그 이므로 setVisible() 메소드는
				// 다이얼로그가 닫힐 때까지 리턴하지 않는다.
				String text = dialog.getInput();
				if (text == null)
					return;
				JButton btn = (JButton) e.getSource();
				btn.setText(text);
			}
		});
		
		getContentPane().add(btn);
		setSize(250, 200);
		setVisible(true);
	} // end 생성자

	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
