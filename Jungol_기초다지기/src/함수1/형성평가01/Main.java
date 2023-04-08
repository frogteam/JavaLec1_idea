package 함수1.형성평가01;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=70&sca=10b0
 170 : 함수1 - 형성평가1 
 
‘@’문자를 10개 출력하는 함수를 작성 한 후 함수를 세 번 호출하여 아래와 같이 출력하는 프로그램을 작성하시오.
   
[출력] 
first
@@@@@@@@@@
second
@@@@@@@@@@
third
@@@@@@@@@@
 
 */
public class Main {
	public static void printAtSign(){
		for(int i = 0; i < 10; i++) {
			System.out.print("@");
		} // end for
		System.out.println();
	} // end printAtSign()
	
	public static void main(String[] args) {
		System.out.println("first");
		printAtSign();
		System.out.println("second");
		printAtSign();
		System.out.println("third");
		printAtSign();
	} // end main()
} // end class
