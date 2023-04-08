package swing309.testarea;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/* JTextArea, 텍스트영역 컴포넌트
	여러 줄을 입력할 수 있는 텍스트 입력 창
	JScrollPane 컴포넌트에 삽입하면 스크롤바 지원됨

	생성자
		JTextArea()  빈 생성자 
		JTextArea(int rows, int cols)  입력 창이 rows * cols 개의 문자 크기인 텍스트 영역 
		JTextArea(String)   문자열로 초기화된 텍스트 영역 
		JTextArea(String, rows, cols)  입력 창이 rows * cols 개의 문자 크기 + 문자열 초기화
*/

public class MainWindow extends JFrame {
	
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(7, 20);

	public MainWindow() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf);
		c.add(new JScrollPane(ta));  // JTextArea 를 담은 JScrollPane 을 생성해서 추가 

		// 리스너 등록
		// <Enter>키가 입력되면 tf 에 입력된 문자열을 ta 끝에 추가
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n");
				t.setText("");
			}
		});
		
		setSize(450,300);
		setVisible(true);
	} // end 생성자
	
	public static void main(String [] args) {
		new MainWindow();
	} // end main
	
} // end class
