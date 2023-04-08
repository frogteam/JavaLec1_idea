package 문자열2.형성평가08;
/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=116&sca=10f0

216 : 문자열2 - 형성평가8 

한 개의 단어를 입력받아서 거꾸로 뒤집어 출력하는 작업을 반복하다가 "END"라고 입력이 되면 종료하는 프로그램을 작성하시오. 
입력받는 단어의 길이는 20이하이다.
   
[입력예]  
Jungol
jjang
END

[출력예]
lognuJ
gnajj
 


 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {			
			String str = sc.next();
			if(str.equals("END")) break;
			
			for(int i = str.length() - 1; i >= 0; i--) {
				System.out.print(str.charAt(i));
			}
			System.out.println();
		} // end while
		
		sc.close();
	}

}
