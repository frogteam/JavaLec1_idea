package com.lec.java.exception04;

/*	예외 클래스의 상속 관계 (★필수 암기★)
	java.lang.Object
	|__ java.lang.Throwable
	  |
	  |__ java.lang.Exception  : 복구 가능
	  |    |
	  |    |__ java.lang.RuntimeException
	  |    |    |__ ArithmeticException, NullPointerException, ...
	  |    |
	  |    |__ IOException, ParseException ...
	  |
	  |__ java.lang.Error    : 복구 불가
	         ...   OutOfMemoryError, StackOverFlowError ...  
	
	 getMessage(), printStackTrace() 등의 메소드는 Throwable 클래스에 정의
	 자식 클래스들은 Throwable에 정의된 메소드들을 사용할 수 있음
	 
	catch문은 여러개를 사용할 수는 있지만, 
	 상위 예외 클래스를 하위 예외 클래스보다 먼저 사용할 수는 없다. (컴파일 에러) 
	 
	 ※ IntelliJ 단축키 : CTRL + H , class hierarchy (계층도) 보기
*/
public class Exception04Main {

	public static void main(String[] args) {
		System.out.println("try ~ catch ~ catch ");
		
		int num1 = 123, num2 = 0, result = 0;
		String str = null;
		int[] numbers = new int[10];
		
		try {
			result = num1 / num2;
			System.out.println("나눈 결과: " + result);
			
			int length = str.length();
			System.out.println("스트링 길이: " + length);
			
			numbers[10] = 11111;
			System.out.println("numbers: " + numbers[10]);
			
		} catch (ArithmeticException ex) { // CTRL + T : class hierarchy (계층도)  
			System.out.println("산술연산 예외: " + ex.getMessage());

			// catch 절 안에서 exception 이 발생하면??
			// 이또한 hadndlnig 되지 않으면 프로그램 종료됨
			// Integer.parseInt("abc");
			
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("배열 인덱스 예외: " + ex.getMessage());
			
		} catch (NullPointerException ex) {
			System.out.println("Null 포인터: " + ex.getMessage());
			
		} catch (Exception ex) {  // 나머지 처리 안된 예외들을 일괄 처리할때 Exception 으로 catch 한다
			System.out.println("Exception: " + ex.getMessage());
		
		} // end catch
		
		System.out.println();
		System.out.println("프로그램 종료");

		// infinite(0);  // StackOverFlowError  <-- Error
		
		//double [] arr = new double[Integer.MAX_VALUE]; // OutOfMemoryError
		
	} // end main()

	
	public static int infinite(int n) {
		return infinite(n + 1);
	}

} // end class Exception04Main












