package mistake;

public class CommonMistake {

	public static void main(String[] args) {
		
		int n = 34;
		
		if(n % 2 == 1);   // if, for, while, .. 조건문) 뒤에 ; 붙이지 마세요
			System.out.println("홀수입니다");
			
		final boolean GOOD = true;
		final boolean BAD = false;
		
		boolean john = BAD;

		if(john = GOOD)  // 비교연산자 ==   vs.  대입연산자 =
			System.out.println("착한애 입니다");
		else
			System.out.println("나쁜애 입니다");
			

		System.out.println("\n프로그램 종료");
	}

}
