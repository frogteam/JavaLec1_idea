package phonebook06.file;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PhonebookMainView implements C{

	private Scanner sc;
	private PhonebookController pbCtrl;   // CONTROLLER 객체
	
	// 메뉴 보여주기 
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("---------------");
		System.out.println(" [1] 입력");
		System.out.println(" [2] 열람");
		System.out.println(" [3] 수정");
		System.out.println(" [4] 삭제");
		System.out.println(" [0] 종료");
		System.out.println("---------------");
		System.out.println("선택:");
	} // end showMenu()
	
	public static void main(String[] args) {
		
		PhonebookMainView app = new PhonebookMainView();
		app.init();  // 초기화
		app.run();   // 실행
		app.exit();  // 종료
	} // end main()
	
	// 응용프로그램(어플리케이션, 앱) 초기화 하는 메소드
	public void init() {
		sc = new Scanner(System.in);
		pbCtrl = PhonebookController.getInstance();
	} // end init()
	
	// 응용프로그램 구동하는 메소드
	public void run() {
		System.out.println(VERSION);
		
		while(true) {
			showMenu(); // 메뉴 표시
			
			try {				
				int menu = sc.nextInt();  // 메뉴 선택 입력
				sc.nextLine();

				switch(menu) {
				case MENU_INSERT:
					insertPhoneBook();
					break;
				case MENU_LIST:
					listPhonebook();
					break;			
				case MENU_DELETE:
					deletePhonebook();
					break;
				case MENU_UPDATE:
					updatePhonebook();
					break;				
				case MENU_QUIT:
					pbCtrl.close();
					System.out.println("프로그램을 종료합니다");
					return; // 종료
				default:
					System.out.println("잘못 입력하셨습니다");
				} // end switch
			} catch (PhonebookException ex) {	// PhonebookException 처리
				System.out.println(ex.getMessage());
			} catch (InputMismatchException e) {  // 숫자가 아닌 다른 값 입력시
				System.out.println("잘못 입력하셨습니다");
				sc.nextLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end while
	} // end run()
	
	// 응용프로그램 종료후 실행하는 코드
	public void exit() {
		sc.close();
	} // end exit()
	
	// 전화번호부 입력
	public void insertPhoneBook() {
		// VIEW 의 역할 : 사용자 입출력
		System.out.println("-- 입력 메뉴 --");
		System.out.println("이름입력:");
		String name = sc.nextLine();
		
		System.out.println("전화번호 입력: ");
		String phoneNum = sc.nextLine();
		
		System.out.println("메모 입력: ");
		String memo = sc.nextLine();
		
		// CONTROLLER 에 연결  (인터페이스 로 연결된다)
		int result = pbCtrl.insert(name, phoneNum, memo);
		System.out.println(result + " 개의 전화번호 입력 성공");
	} // end insertPhoneBook()
	
	// 전화번호부 수정
	public void updatePhonebook() {
		// VIEW 의 역할 : 사용자 입출력
		System.out.println("--- 수정 메뉴 ---");
		
		System.out.println("수정할 번호 입력:");
		int uid = sc.nextInt();
		sc.nextLine();
		
		// CONTROLLER 에 연결
		pbCtrl.selectByUid(uid);

		// VIEW
		System.out.println("이름 입력:");
		String name = sc.nextLine();
		
		System.out.println("전화번호 입력:");
		String phoneNum = sc.nextLine();
		
		System.out.println("메모 입력:");
		String memo = sc.nextLine();
		
		// CONTROLLER 에 연결  (인터페이스 로 연결된다)
		int result = pbCtrl.update(uid, name, phoneNum, memo);
		System.out.println(result + " 개의 전화번호 수정 성공");
	} // end updatePhonebookData()

	// 전화번호부 삭제
	public void deletePhonebook(){
		// VIEW 의 역할 : 사용자 입출력
		System.out.println("--- 삭제 메뉴 ---");
		
		System.out.println("삭제할 번호 입력:");
		int uid = sc.nextInt();
		sc.nextLine();
		
		// CONTROLLER 에 연결  (인터페이스 로 연결된다)
		pbCtrl.selectByUid(uid);

		int result = pbCtrl.delete(uid);
		System.out.println(result + " 개의 전화번호 삭제 성공");
	} // end deletePhonebookData()

	// 전화번호부 열람 (전체)
	public void listPhonebook() {
		// CONTROLLER 에 연결  (인터페이스 로 연결된다)
		List<PhonebookModel> list = pbCtrl.selectAll();
		
		// VIEW 의 역할 : 사용자 입출력
		System.out.println("총" + list.size() + "명의 전화번호 데이터 출력");
		for(PhonebookModel m : list) {
			System.out.println(m);
		} // end for
	} // end listPhonebook()

} // class
