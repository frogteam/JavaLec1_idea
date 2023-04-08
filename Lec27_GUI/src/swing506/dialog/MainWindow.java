package swing506.dialog;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*  대화상자 JDialog

	다이얼로그란?
		사용자로부터 입력을 받기 위한 대화 상자
	JDialog
		스윙에서 다이얼로그를 만들기 위한 슈퍼 클래스
		최상위 컨테이너(top-level container)
			다른 컨테이너에 속할 필요 없이 화면에 출력 가능한 컨테이너
			
			
	※ 대화상자를 닫았다고 해서 '대화상자 객체' 가 소멸되는 것이 아닙니다.  (안보일뿐입니다)
	대화상자가 닫혀도 대화상자의 입력내용들은 대화상자 객체로부터 받아올수 있고,
	다시 보여지게 할수 있습니다.
*/

// JDialog를 상속받은 다이얼로그 클래스
class MyDialog extends JDialog {
	JTextField tf = new JTextField(10);
	JButton okButton = new JButton("OK");
	
	public MyDialog(JFrame frame, String title) {
		super(frame,title);
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200, 100);

		// OK 버튼 누르면 사라져보이게 하기
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);  // 클릭하면 사라져 보기에 하기
			}
		});
	} // end 생성자
	
} // end class MyDialog


public class MainWindow extends JFrame{
	
	
	MyDialog dialog = new MyDialog(this, "Test Dialog");  // 대화상자 객체 생성
	
	public MainWindow() {
		super("DialogEx 예제 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn  = new JButton("Show Dialog");

		// 버튼 클릭하면 대화상자 보이게 하기
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);  // 대화상자 보이기
			}
		});
		
		getContentPane().add(btn);
		setSize(350,200);
		setVisible(true);
	} // end 생성자

	public static void main(String[] args) {
		new MainWindow();
	} // end main()
	
} // end class
