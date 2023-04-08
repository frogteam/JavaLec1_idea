package practice204.calculator1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// ActionListener 도 implemtne 함
// actionPerformed() 구현 필수
public class Calc extends JFrame implements ActionListener {
	// 이 줄은 별 의미 없음.
	// JFrame을 상속받았을 때 나오는 경고를 없애기 위함
	public static final long serialVersionUID = 0L;

	// 멤버 변수 선언
	public JTextField text;
	public boolean mode = false;  // 이미 계산된 결과가 있는지 여부
	public double operand1 = 0;
	public double operand2 = 0;
	public String operator = "";

	public Calc() {
		super("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeLayout();
	} // end 생성자

	public void makeLayout() {
		JPanel panel = new JPanel();   // panel 컨테이너 생성
		text = new JTextField("0", 17);  // TextField 생성,  초기표시값 "0"
		text.setHorizontalAlignment(JTextField.RIGHT);  // 우측 정렬 입력되게 설정 (숫자 계산기니까)

		panel.add(text);    
		add(panel, "North");  // 프레임의 BorderLayout 의 north 에 panel 붙이기

		// 버튼 크기를 같게 하기 위해서..
		Dimension d = new Dimension(45, 30);  // Dimenstion 객체 : width, height 담는 용도의 객체

		// 연산 버튼 생성
		JButton operator[] = new JButton[6];
		operator[0] = new JButton("+");
		operator[1] = new JButton("-");
		operator[2] = new JButton("*");
		operator[3] = new JButton("/");
		operator[4] = new JButton("=");
		operator[5] = new JButton("C");

		for (int i = 0; i < 6; i++) {
			operator[i].setPreferredSize(d); // 버튼 크기 설정
			operator[i].addActionListener(this);  // 버튼이 클릭되면  아래의 actionPerformed() 수행
		} // end for

		// 숫자 버튼 생성
		JButton[] button = new JButton[10];
		for (int i = 0; i < 10; i++) {
			button[i] = new JButton(i + "");
			button[i].setPreferredSize(d);
			button[i].addActionListener(this);
		} // end for

		// 버튼을 넣을 서브 패널 생성
		JPanel[] p = new JPanel[4];   // 4줄에 대한 패널 생성
		for (int i = 0; i < 4; i++) {
			p[i] = new JPanel();
			p[i].setLayout(new FlowLayout());
			p[i].setAlignmentX(JPanel.LEFT_ALIGNMENT);
		} // end for

		p[0].add(button[7]);
		p[0].add(button[8]);
		p[0].add(button[9]);
		p[0].add(operator[0]);

		p[1].add(button[4]);
		p[1].add(button[5]);
		p[1].add(button[6]);
		p[1].add(operator[1]);

		p[2].add(button[1]);
		p[2].add(button[2]);
		p[2].add(button[3]);
		p[2].add(operator[2]);

		p[3].add(button[0]);
		p[3].add(operator[3]);
		p[3].add(operator[4]);
		p[3].add(operator[5]);

		// 패널 pad 생성하고 BoxLayout (세로) 지정
		JPanel pad = new JPanel();
		pad.setLayout(new BoxLayout(pad, BoxLayout.Y_AXIS));

		// 패널 pad 에  먼저 만든 4개의 패널 추가  (4줄로 배치된다 BoxLayout)
		for (int i = 0; i < 4; i++) {
			pad.add(p[i]);
		} // end for

		// 완성된 패널을 프레임 컨테이너에 추가
		add(pad, BorderLayout.CENTER);   // 프레임(BorderLayout) 의 CENTER 에 배치

		pack();   // 프레임 사이즈를 위에 담은 내용에 맞추어 자동 조정
					// 굳이 setSize() 하려고 고생할 필요 없다.
		setVisible(true);
	} // makeLayout()

	public static void main(String[] args) {
		new Calc();
	} // end main()

	public String cal() {
		// 계산 결과를 문자열 형태로 리턴
		String result = "";
		if (operator.equals("+")) {
			operand1 += operand2;
			result = operand1 + "";
		} else if (operator == "-") {
			operand1 -= operand2;
			result = operand1 + "";
		} else if (operator == "*") {
			operand1 *= operand2;
			result = operand1 + "";
		} else if (operator == "/") {
			if (operand2 != 0) {  // 0으로 나눈경우는 "NaN" 표시
				operand1 /= operand2;
				result = operand1 + "";
			} else {
				result = "NaN";
			}
		} // end if

		// 결과가 .0 으로 끝나면 잘라 버리기.
		if (result.endsWith(".0")) {
			result = result.substring(0, result.length() - 2);
		} // end if

		return result;
	}  // cal()

	public void cal(String op) {
		// 입력받은 숫자가 없으면 아무 일도 하지 않음
		if (text.getText().equals("") || text.getText() == null)
			return;

		if (operator.equals("")) {
			// 계산을 처음 할 때
			operand1 = Double.parseDouble(text.getText());
			operator = op;
			text.setText("");
		} else {
			// 연속 계산을 위한 부분
			operand2 = Double.parseDouble(text.getText());
			text.setText(cal());
			operator = op;
			mode = true;
		}
	} // end cal(String)

	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
		
		if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
			// 연산자 처리
			cal(cmd);
			
		} else if (cmd.equals("=")) {
			// 연산자가 지정이 안되어 있으면 아무 일도 안한다.
			if (operator.equals(""))
				return;

			// 계산 결과 처리
			operand2 = Double.parseDouble(text.getText());
			text.setText(cal());

			// 다음 계산을 위한 초기화
			operand1 = 0;
			operand2 = 0;
			operator = "";
			mode = true;
			
		} else if (cmd.equals("C")) {
			// 클리어
			operand1 = 0;
			operand2 = 0;
			operator = "";
			text.setText("0");
			
		} else {
			// 숫자 처리
			if (mode == true) {   // 기존에 계산된 결과가 있다면,  덮어쓰기하면 된다.
				mode = false;
				text.setText(cmd);  // 덮어쓰기.
				
			} else {             // 기존에 계산된 결과가 없다면
				if (text.getText().equals("0")) {   // 그리고, 혹이 "0" 이 있었으면
					text.setText(cmd);   // 덮어쓰기 시작
				} else {
					text.setText(text.getText() + cmd);  // "0" 이 아니면  텍스트에 추가
				}
			}
		} // end if ~ else
	} // end actionPerformed()
	
} // end class