package phonebook05.map_file;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/* 자료구조가 '배열' 에서 'ArrayList' 로 바뀌었다.
 * 그러나 인터페이스에 세팅한 '동작' 은 바뀔 필요가 없다.
 * 즉 데이터구조를 다루는 '컨트롤러'만 수정되면 된다. 
 */
public class PhonebookMain {

	private Scanner sc;
	private PhonebookManager pbCtrl;   // CONTROLLER 객체
	
	// 메뉴 보여주기
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("---------------");
		System.out.println(" [0] 종료");
		System.out.println(" [1] 입력");
		System.out.println(" [2] 열람");
		System.out.println(" [3] 수정");
		System.out.println(" [4] 삭제");
		System.out.println("---------------");
		System.out.println("선택:");
	}
	
	public static void main(String[] args) {
		
		PhonebookMain app = new PhonebookMain();
		app.init();  // 초기화
		app.run();   // 실행
		app.exit();  // 종료
	} // end main()
	
	// 응용프로그램(어플리케이션, 앱) 초기화 하는 메소드
	public void init() {
		sc = new Scanner(System.in);
		pbCtrl = PhonebookManager.getInstance();
	}
	
	// 응용프로그램 구동하는 메소드
	public void run() {
		System.out.println(pbCtrl.VERSION);
		
		while(true) {
			showMenu(); // 메뉴 표시
			
			int menu = 0;
			
			try {
				menu = sc.nextInt(); // 메뉴 선택 입력
				sc.nextLine();
				
				switch(menu) {
				case Menu.MENU_INSERT:
					insertPhoneBook();
					break;
				case Menu.MENU_SEARCH:
					selectAll();
					break;			
				case Menu.MENU_DELETE:
					deletePhonebook();
					break;
				case Menu.MENU_UPDATE:
					updatePhonebook();
					break;				
				case Menu.MENU_QUIT:
					pbCtrl.close();
					System.out.println("프로그램을 종료합니다");
					return; // 종료
				default:
					System.out.println("잘못 입력하셨습니다");
				} // end switch
				
				
			} catch (PhonebookException ex) {	// PhonebookException 처리
				System.out.println(ex.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("잘못 입력하셨습니다");
				sc.nextLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end try-catch
		} // end while
	} // end run()
	
	// 응용프로그램 종료후 실행하는 코드
	public void exit() {
		sc.close();
	}
	
	// 전화번호부 입력
	public void insertPhoneBook() {
		// VIEW 의 역할 : 사용자 입출력
		System.out.println("-- 입력 메뉴 --");
		System.out.println("이름입력:");
		String name = sc.nextLine();
		
		System.out.println("전화번호부 입력: ");
		String phoneNum = sc.nextLine();
		
		System.out.println("이메일 입력: ");
		String email = sc.nextLine();
		
		// CONTROLLER 에 연결  (인터페이스 로 연결된다)
		int result = pbCtrl.insert(name, phoneNum, email);
		System.out.println(result + " 개의 주소록 입력 성공");
	} // end insertPhoneBook()
	
	// 전화번호부 수정
	public void updatePhonebook() {
		// VIEW 의 역할 : 사용자 입출력
		System.out.println("--- 수정 메뉴 ---");
		
		System.out.println("수정할 아이디 입력:");
		int id = sc.nextInt();
		sc.nextLine();
		
		// id 입력한 시점에서 예외 발생
		if(!pbCtrl.isValidId(id))
			throw new PhonebookException("update 아이디오류: "  + id, DbQuery.ERR_INVALID_ID);
		
		System.out.println("이름 입력:");
		String name = sc.nextLine();
		
		System.out.println("전화번호 입력:");
		String phoneNum = sc.nextLine();
		
		System.out.println("이메일 입력:");
		String email = sc.nextLine();
		
		// CONTROLLER 에 연결  (인터페이스 로 연결된다)
		int result = pbCtrl.update(id, name, phoneNum, email);
		System.out.println(result + " 개의 주소록 수정 성공");
	} // end updatePhonebookData()
	
	// 전화번호부 삭제
	public void deletePhonebook(){
		// VIEW 의 역할 : 사용자 입출력
		System.out.println("--- 삭제 메뉴 ---");
		
		System.out.println("삭제할 아이디 입력:");
		int id = sc.nextInt();
		sc.nextLine();
		
		// id 유효한지 체크
		if(!pbCtrl.isValidId(id))
			throw new PhonebookException("delete 아이디오류: "  + id, DbQuery.ERR_INVALID_ID);


		// CONTROLLER 에 연결  (인터페이스 로 연결된다)
		int result = pbCtrl.delete(id);
		System.out.println(result + " 개의 주소록 삭제 성공");
	} // end deletePhonebookData()
	
	// 전화번호부 열람 (전체)
	public void selectAll() {
		PhonebookModel[] data = (PhonebookModel[])pbCtrl.searchAll();
		System.out.println("총" + data.length + "명의 데이터 출력");
		for(PhonebookModel m : data) {
			System.out.println(m);
		} // end for
	} // end showPhoneBook()

} // class
