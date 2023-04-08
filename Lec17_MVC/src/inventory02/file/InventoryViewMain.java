package inventory02.file;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// by 박정희
public class InventoryViewMain implements InventoryConstants{
	private Scanner sc;
	private InventoryController controller;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InventoryViewMain app = new InventoryViewMain();

		// 초기화
		app.init();
		
		// 실행
		app.run();

		// 종료
		app.exit();
	}

	private void init() {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		//컨트롤러 객체 초기화
		controller = InventoryController.getInstance();
	}

	private void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			viewMenu();
			try {
				int menu = sc.nextInt();
				sc.nextLine();
				
				switch(menu) {
				case MENU_QUIT:
					controller.close();
					System.out.println("프로그램을 종료합니다");
					return;
				case MENU_LIST:
					showAll();
					break;
				case MENU_INSERT:
					insertItem();
					break;
				case MENU_DELETE:
					deleteItem();
					break;
				case MENU_UPDATE:
					amendItem();
					break;
				default:
					System.out.println("선택하신 번호의 항목은 존재하지 않습니다. 재입력해주십시오.");
				}
			}catch(InputMismatchException ex) {
				System.out.println(ex.getMessage());
				sc.nextLine();
			}catch(InventoryException ex) {
				System.out.println(ex.getMessage());
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
		}
		
		
	}
	
	private void amendItem() {
		// TODO Auto-generated method stub
		System.out.println("선택한 항목의 상품의 내용을 변경합니다.\n상품 id를 입력해주세요");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("선택한 항목은 다음과 같습니다.");
		System.out.println(controller.selectOneById(id));
		System.out.println("상품명을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("가격을 입력해주세요.");
		String price = sc.nextLine();
		System.out.println("개수를 입력해주세요.");
		String count = sc.nextLine();
		
		int status = controller.update(id, name, price, count);
		System.out.println("성공 여부: " + status);
		
	}

	private void deleteItem() {
		// TODO Auto-generated method stub
		System.out.println("아이템 항목을 삭제하겠습니다.\n삭제할 아이템 id를 입력해주세요");
		controller.delete(sc.nextInt());
		sc.nextLine();
	}

	private void insertItem() {
		// TODO Auto-generated method stub
		System.out.println("아이템 항목 입력을 시작합니다.");
		System.out.println("아이템 이름을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("아이템 가격을 정해주세요.");
		String price = sc.nextLine();
		System.out.println("몇 개 등록하시겠습니까?");
		String count = sc.nextLine();
		
		controller.insert(name, price, count);
	}

	private void showAll() {
		// TODO Auto-generated method stub
		List<InventoryModel> items = controller.selectAll();
		System.out.println("모든 아이템 항목을 출력합니다.\n"
				+ "id   name     price     count   time");
		for(InventoryModel i : items) {
			System.out.println(i);
		}
	}

	// 메뉴 UI 보이기
	private void viewMenu() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("상품정보 관리 프로그램");
		System.out.println("---------------");
		System.out.println(" [1] 입력");
		System.out.println(" [2] 열람");
		System.out.println(" [3] 수정");
		System.out.println(" [4] 삭제");
		System.out.println(" [0] 종료");
		System.out.println("---------------");
		System.out.println("선택:");
	}

	private void exit() {
		// TODO Auto-generated method stub
		sc.close();
	}

}
