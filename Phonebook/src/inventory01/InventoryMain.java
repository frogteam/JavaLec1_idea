package inventory01;


import java.util.Scanner;

// 2024.04  디컨 송유신
public class InventoryMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int input = printInputProgram(sc);
            if(input == 0) break;
            switch (input){
                case 1 -> createInputInventory(sc);
                case 2 -> openInventory();
                case 3 -> changeInputInventory(sc);
                case 4 -> deleteInputInventory(sc);
                default -> System.out.println("선택하신 번호의 항목은 존재하지 않습니다.\n재입력해주십시오.\n");
            }
        }

        sc.close();
    }

    public static int printInputProgram(Scanner sc){
        System.out.print("""
                상품정보 관리 프로그램 v1.0
                ---------------
                 [1] 입력
                 [2] 열람
                 [3] 수정
                 [4] 삭제
                 [0] 종료
                ---------------
                선택: """);
        return sc.nextInt();
    }

    public static String[] inputInventory(Scanner sc) {
        sc.nextLine(); // 남은 버퍼 삭제
        String[] resultString = new String[3];

        System.out.println("아이템 항목 입력을 시작합니다.");
        System.out.println("아이템 이름을 입력해주세요.");
        resultString[0] = sc.nextLine();

        System.out.println("아이템 가격을 정해주세요.");
        resultString[1] = sc.nextLine();

        System.out.println("몇 개 등록하시겠습니까?");
        resultString[2] = sc.nextLine();
        resultString[2] = resultString[2].equals("") ? "0" : resultString[2];

        try {
            checkVaildInventory(resultString[0], resultString[1], resultString[2]); // 유효한 값들인지 판단
        } catch (InputException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return resultString; // 유효한 값이다. 입력된 값들을 리턴해준다.
    }

    public static void createInputInventory(Scanner sc){
        String[] inputResult = inputInventory(sc); // 인벤토리에 들어갈 입력 값들을 받아온다.
        if(inputResult == null)
            return; // 만약 입력 값들이 잘못됐다면 메소드를 탈출한다

        // 받아온 값들을 InventoryController를 통해, 새 인벤토리를 생성한다.
        InventoryController.getInstance().createInventory(inputResult[0], Integer.parseInt(inputResult[1]), Integer.parseInt(inputResult[2]));
    }

    public static void openInventory(){
        System.out.println("모든 아이템 항목을 출력합니다.");
        System.out.println(InventoryController.getInstance()); // InventoryController의 toString을 호출한다.
    }

    public static void changeInputInventory(Scanner sc){
        System.out.println("선택한 항목의 상품의 내용을 변경합니다.");
        System.out.println("상품 id를 입력해주세요");
        Inventory findInventory = null;
        try { // InventoryController의 getInventory메소드를 통해, Inventory를 검색한다.
            findInventory = InventoryController.getInstance().getInventory(sc.nextInt());
        } catch (InputException e) { // 인벤토리 검색에 실패
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("선택한 항목은 다음과 같습니다.");
        System.out.println(findInventory); // Inventory의 toString을 호출한다.

        String[] inputResult = inputInventory(sc);
        if(inputResult != null){ // 입력에 에러가 없었다면, 인벤토리를 새 값들로 수정한다.
            findInventory.setName(inputResult[0]);
            findInventory.setPrice(Integer.parseInt(inputResult[1]));
            findInventory.setCount(Integer.parseInt(inputResult[2]));
            System.out.println("수정 성공!");
        }
    }

    public static void deleteInputInventory(Scanner sc){
        System.out.println("선택한 항목의 상품의 내용을 변경합니다.");
        System.out.println("상품 id를 입력해주세요");
        Inventory findInventory = null;
        try { // InventoryController의 getInventory메소드를 통해, Inventory를 검색한다
            findInventory = InventoryController.getInstance().getInventory(sc.nextInt());
        } catch (InputException e) { // 인벤토리 검색에 실패
            System.out.println(e.getMessage());
            return;
        }

        // 발견한 인벤토리를 InventoryController의 deleteInventory메소드를 통해 List에서 삭제한다.
        if(InventoryController.getInstance().deleteInventory(findInventory) == true)
            System.out.println("삭제 성공!");
    }

    public static void checkVaildInventory(String itemName, String itemPrice, String itemCount) throws InputException{
        if(itemName.equals("")) // 이름이 입력되지 않은 경우
            throw new InputException("Error! 문자열오류 insert() 이름이 입력되지 않았습니다.\n");
        if(itemPrice.equals("")) // 가격이 입력되지 않은 경우
            throw new InputException("Error! 가격 오류 insert() 가격에 아무 값도 입력되지 않았습니다.\n");

        try{
            Integer.parseInt(itemPrice); // 가격을 정수로 바꾸기 시도
        } catch(NumberFormatException ex){ // 시도에 실패하면, 정수를 입력하지 않은 것으로 간주
            throw new InputException("Error! 가격 오류 insert() 가격에 숫자가 아닌 값이 들어왔습니다." + itemPrice + "\n");
        }
        try{
            Integer.parseInt(itemCount); // 갯수를 정수로 바꾸기 시도
        } catch(NumberFormatException ex){ // 시도에 실패하면, 정수를 입력하지 않은 것으로 간주
            if(itemCount.equals("") == false)
                throw new InputException("Error! 갯수 오류 insert() 갯수에 숫자가 아닌 값이 들어왔습니다." + itemPrice + "\n");
        }
    }
} // end class
