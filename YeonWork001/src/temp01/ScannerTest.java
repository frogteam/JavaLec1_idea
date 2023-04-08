package temp01;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// Console 에서 키보드 를 통해 입력받을때 Scanner 객체 생성
		Scanner sc = new Scanner(System.in);   
		
		//byte b = sc.nextByte();
//		short s = sc.nextShort();
//		int n = sc.nextInt();
//		long l = sc.nextLong();
//		double d = sc.nextDouble(); 
//		float f = sc.nextFloat();
		
		//sc.nextLine();	// 숫자를 입력 받은뒤에 문자열 입력시에는 반드시 nextLine()을 해줌으로 '\n' 을 consume 해야 한다
		
		//String str = sc.nextLine();  // 문자열 입력은 nextLine()
		char ch = sc.next().charAt(0);   // char 문자 하나 입력은 이렇게 
		
		//sc.close();  // 시스템 자원을 사용하는 객체는 사용후에 반드시 close() 를 해주자
		
		int n = 21;
		String name = "James";
		
		System.out.printf("hello");
		System.out.printf("world\n");
		
		System.out.printf("My name is %s\n", name);
		System.out.printf("My name is %s, age is [%4d] yrs\n", name, n);
		System.out.printf("My name is %s, age is [%4d] yrs\n", name, 123);
		System.out.printf("My name is %s, age is [%-4d] yrs\n", name, 123);
		
		
		double d = 3.141592;
		
		System.out.println(d);
		
		
		System.out.printf("%.1f", d);
		
		
		char  c = 'M';
		byte  b = 23;
		
		
		if(c == 'M'){
			
			if(b >= 18){
				System.out.println("MAN");
			}else{
				System.out.println("BOY");
			}
			
			
		}else if (c == 'F'){
			
			if(b >= 18){
				System.out.println("WOMAN");
			}else{
				System.out.println("GIRL");
			}
		}
		
		
	} // end main
} // end class
