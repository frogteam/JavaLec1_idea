package phonebook01.class01;

import java.time.LocalDateTime;
import java.util.Scanner;

public class PhonebookMain {

	private Scanner sc;
	private PhonebookModel[] pbData = new PhonebookModel[5];
	
	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init();  // 초기화
		app.run();   // 실행
		app.exit();  // 종료
	} // end main()
	
	// 응용프로그램(어플리케이션, 앱) 초기화 하는 메소드
	public void init() {
		sc = new Scanner(System.in);
	} // end init()
	
	// 응용프로그램 구동하는 메소드
	public void run() {
		System.out.println("전화번호부 v1.0");
		
		while(true) {
			showMenu(); // 메뉴 표시
			
			int menu = sc.nextInt();  // 메뉴 선택 입력
			sc.nextLine();
			
			switch(menu) {
			case 1:
				System.out.println("전화번호부를 입력합니다");
				insertPhoneBook();
				break;
			case 2:
				System.out.println("전화번호부 출력(열람)");
				selectAll();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				return; // 종료
			default:
				System.out.println("잘못 입력하셨습니다");
				
			} // end switch
		} // end while
	} // end run()
	
	// 전화번호부 입력
	public void insertPhoneBook() {
		
		// 전화번호부가 다 찼는지 체크
		int i;
		for(i = 0; i < pbData.length; i++) {
			if( pbData[i] == null ) break; // 배열에서 null 인 원소를 찾아서
		} // end for
	
		if(i == pbData.length) {
			System.out.println("전화번호부가 다 찼습니다.");
			return;
		} // end if
		
		
		System.out.print("이름 입력: ");
		String name = sc.nextLine();
		
		System.out.print("전화번호 입력: ");
		String phoneNum = sc.nextLine();
		
		System.out.print("메모 입력: ");
		String memo = sc.nextLine();
		
		// PhonebookModel 인스턴스 생성
		PhonebookModel pb = new PhonebookModel(
				i, 
				name, phoneNum, memo, 
				LocalDateTime.now()   // 현재날짜
				);
		
		pbData[i] = pb;  // 전화번호부 -> 배열에 추가
		System.out.println( (i + 1) + "번째 전화번호부 추가 성공");
		
	} // insertPhoneBook()
	
	// 전화번호부 열람 (전체)
	public void selectAll() {
		int i;
		for(i = 0; i < pbData.length; i++) {
			PhonebookModel pb = pbData[i];
			
			if(pb == null) break;  // PhonebookModel 데이터 없으면 출력중지
			
			System.out.println(pb);;
		} // end for
		
		System.out.println( i + "개의 전화번호부 출력");
	} // showPhoneBook()
	
	// 메뉴 보여주기
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[0] 종료");
		System.out.println("------------------");
		System.out.print("선택: ");
	} // end showMenu()

	// 응용프로그램 종료후 실행하는 코드
	public void exit() {
		sc.close();
	} // exit()
	
} // class
