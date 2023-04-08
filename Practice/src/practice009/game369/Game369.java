package practice009.game369;

import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 구글드라이브 
 https://docs.google.com/presentation/d/1dNez7VmcSd_vrmVt27BP1cBK5wa8kQMOjFgWaoQbpzE/edit#slide=id.p
 */
public class Game369 {

	public static void main(String[] args) {
		
		System.out.println("## 게임: 3.6.9 !! ##");
				
		int i, k;
		String str;
		int num;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 몇 까지 369 를 할까요? : ");
		num = sc.nextInt();
		sc.close();
		
		// 출력 자리수
		int digits = ("" + num).length() + 1;
		
		//============================================================
		// ## 방법1: 자릿수를 하나씩 깍아 내려오면서 3의 배수가 있는지 확인
		//============================================================
		
		System.out.println("## 방법1: 자릿수를 하나씩 깍아 내려오면서 3의 배수가 있는지 확인");
		i = 1;
		while(i <= num){  // 100			
			k = i;			
			while (k > 0){				
				if( (k % 10) != 0 && (k % 10) % 3 == 0){		// 1의 자리가 0이 아니면서 3의 배수이면
					System.out.printf("%" + digits + "s", "*");
					break;
				}				
				k /= 10;  // 한자리씩 깍아오기
			}
			if(k == 0)		// 모든 자리수 다 돌았는데도, 3,6,9 안나왔으면. 숫자출력
				System.out.printf("%" + digits + "d", i);			
			
			if(i % 10 == 0)	// 10개 출력하고 줄바꿈
				System.out.println("");
			
			i++;				// i 증가
		} // end while		
		
		
		System.out.println("");
		
		//============================================================
		// ## 방법2: 문자열로서 '3', '6', '9' 있는지 확인
		//============================================================
		System.out.println("## 방법2: 문자열로서 '3', '6', '9' 있는지 확인");
		i=1;
		while(i <= num){			
			str = i + "";		// 자바에서 String 변환하는 팁
			
			// str에서  3, 6, 9 문자 있는지 확인.
			if( str.indexOf("3") >= 0 || str.indexOf("6") >= 0 || str.indexOf("9") >= 0){				
				System.out.printf("%" + digits + "s", "*");
			}else{
				System.out.printf("%" + digits + "d", i);
			} // end if
			
			if(i % 10 == 0)	// 10개 출력하고 줄바꿈
				System.out.println("");
			
			i++;				// i 증가
		} // end while

	
		System.out.println("");
		
		
		//============================================================
		// ## 방법3: 1의자리, 10의 자리, 100의 자리에 3의배수 있는지 확인
		//============================================================
		
		System.out.println("## 방법3: 1의자리, 10의 자리, 100의 자리에 3의배수 있는지 확인");
		i=1;
		while(i <= num){			
			// str 안에 3, 6, 9 가 있는지 확인
			if( ( (i % 10) != 0 &&  ((i%10)%3) == 0  )|| ( ((i/10) % 10) != 0 &&  (((i/10)%10)%3) == 0  )){				
				System.out.printf("%" + digits + "s", "*");
			}else{
				System.out.printf("%" + digits + "d", i);
			} // end if
			
			if(i % 10 == 0)	 // 10개 출력하고 줄바꿈
				System.out.println("");
			
			i++;				// i 증가
		} // end while
		
	}  // end main

} // end class
