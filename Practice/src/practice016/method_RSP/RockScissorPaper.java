package practice016.method_RSP;

import java.util.Scanner;

/*
	 간단한 가위, 바위, 보 게임을 만듭니다.
	(실행화면은 다음 페이지에)
	
	showMenu / inputChoice / displayChoice
	/ computeResult  메소드들을 어떻게 
	구현해볼수 있을까요? 
	
	
	main() 메소드는 오른쪽과 같이 구성하고
	변경하지 않는 상태에서
	나머지 메소드들을 구현하여 완성해보세요
	
	필요하다면 클래스의 멤버변수등을 추가해도
	좋습니
 */
public class RockScissorPaper {

	public static final int SCISSORS = 1; // 가위
	public static final int ROCK = 2; // 바위
	public static final int PAPER = 3; // 보
	public static final String SCISSORS_STR = "가위";
	public static final String ROCK_STR = "바위";
	public static final String PAPER_STR = "보";
	
	static boolean isTie;
	// 클래스의 멤버 변수
	// 클래스의 선언된 모든 메소드에서 다 사용 가능함
	
    public static void main(String[] args) {
        System.out.println("가위 바위 보 게임");
        Scanner sc = new Scanner(System.in);
        
        while(true){
            showMenu(); // 메뉴보여주기
 
            int userChoice = inputChoice(sc); // 사용자 입력
            if(userChoice == 0){
                break;  // 0 이변 종료
            }
            
            // 컴퓨터 선택:   1 - 가위,  2- 바위,  3 - 보
            int computerChoice = (int) Math.floor(Math.random() * 3) + 1;  
            displayChoice(userChoice, computerChoice); // 양측의 선택 보여주기
            computeResult(userChoice, computerChoice); // 승부결과 보여주기
        }
        sc.close();
    } // end main()
    
    
	// method name: showMenu
	// return: void
	// arguments: none
	// 기능: 유저가 가위/바위/보 선택할 수 있는 메뉴 출력
	public static void showMenu() {
		System.out.println("-------------");
		System.out.println("[1] 가위");
		System.out.println("[2] 바위");
		System.out.println("[3] 보");
		System.out.println("[0] 종료");
		System.out.println("-------------");
		System.out.println("선택:");
	} // end showMenu()
	
	// method name: inputChoice
	// return: int (유저의 가위(0)/바위(1)/보(2) 선택 내용)
	// arguments: Scanner sc (입력장치)
	public static int inputChoice(Scanner sc) {
		int choice;
		
		while (true) {
			choice = sc.nextInt();
			
			if (choice <= 3) {
				break;
			} else {
				System.out.println("다시 입력하세요~");
			} // end else
			
		} // end while()
		
		return choice;
	} // end inputChoice()

	
	// method name: displayChoice
	// return: void
	// arguments:
	//   1) int user: 유저의 선택(가위(0)/바위(1)/보(2))
	//   2) int com: 컴퓨터의 선택(가위(0)/바위(1)/보(2))
	public static void displayChoice(int user, int com) {
		String userStr = getHandType(user);
		String comStr = getHandType(com);
		
		System.out.println("사용자 vs. 컴퓨터");
		System.out.println(userStr + " vs. " + comStr);
	} // end displayChoice()
	
	
	// method name: getHandType
	// return: String (가위/바위/보)
	// arguments: int choice(0, 1, 2)
	public static String getHandType(int choice) {
		String type;
		switch (choice) {
		case SCISSORS:
			type = SCISSORS_STR;
			break;
			
		case ROCK:
			type = ROCK_STR;
			break;
			
		case PAPER:
			type = PAPER_STR;
			break;
			
		default:
			type = "몰라요 ㅠ.ㅠ";
		} // end switch
		
		return type;
	} // end getHandType()
	
	
	// method name: computeResult
	// return: void
	// arguments:
	//   1) int user: 유저의 선택(가위(0)/바위(1)/보(2))
	//   2) int com: 컴퓨터의 선택(가위(0)/바위(1)/보(2))
	public static void computeResult(int user, int com) {
		if (user == com) {
			isTie = true;
			System.out.println("비겼습니다.");
		} else if (user == SCISSORS) {
			isTie = false;
			if (com == ROCK) {
				// 가위 vs 바위
				System.out.println("Com Win!");
			} else {
				// 가위 vs 보
				System.out.println("User Win!");
			}
			
		} else if (user == ROCK) {
			isTie = false;
			if (com == SCISSORS) {
				// 바위 vs 가위
				System.out.println("User Win!");
			} else {
				// 바위 vs 보
				System.out.println("Com Win!");
			}
			
		} else if (user == PAPER) {
			isTie = false;
			if (com == SCISSORS) {
				// 보 vs 가위
				System.out.println("Com Win!");
			} else {
				// 보 vs 바위
				System.out.println("User Win!");
			}
			
		} else {
			System.out.println("잘못입력하셨습니다.");
		}
			
	} // end computeResult()

} // end class
