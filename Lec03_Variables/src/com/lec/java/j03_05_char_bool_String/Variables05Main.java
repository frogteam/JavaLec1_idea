package com.lec.java.j03_05_char_bool_String;

public class Variables05Main {

	public static void main(String[] args) {
		System.out.println("변수 05 - char, boolean, String");
		
		// char: 문자 하나를 저장하기 위한 자료 타입(2바이트)
		// char 는 문자의 코드값(정수)가 담긴다 (2byte)
		
		char ch1 = 'A';
		// 문자열(String)은 큰따옴표("")로 묶어 줌.   (String literal)
		// 문자 하나(char)는 작은따옴표('')로 묶어 줌.   (char literal)
		//char ch2 = "A"; // 컴파일 에러: 자바는 "A"를 문자열로 인식하기 때문
		System.out.println("ch1: " + ch1);
		
		char ch2 = '한';
		char ch3 = '글';
		System.out.println("ch2: " + ch2);
		System.out.println("ch3: " + ch3);
		
		char ch4 = 0xAE01;
		System.out.println("ch4: " + ch4);
		char ch5 = 1234;
		System.out.println("ch5: " + ch5);  // Ӓ
		
		// println() 은 char 타입을 문자로 출력한다
		// 그러나 다른 정수형으로 변환되면 해당 코드값을 정수로 출력
		char ch6 = '!';
		System.out.println("ch6: " + ch6);   // !
		char ch7 = 33;
		System.out.println("ch7: " + ch7);	// !
		
		System.out.println("ch7+1: " + (ch7 + 1));  // 34     ch + 1 의 결과는 int 로
		System.out.println("++ch7: " + (++ch7));  // "        증감연산은 타입변화 없슴
		
		
		// 1. "bible"
		// 2. "cable"
		// 3. "able"		
		// 오름차순 정렬하면?
		// 3 > 1 > 2
		
		// 1. "aaAA"
		// 2. "AaAa"
		// 3. "aAaA"
		// 4. "AAaa"
		// 4 > 2 > 3 > 1
		
		// 알파벳은 대문자 코드값보다 소문자 코드값이 크가
		char ch8 = 'A';
		char ch9 = 'a';
		System.out.println("'A': " + (int)ch8);		// 65
		System.out.println("'a': " + (int)ch9);		// 97
		
		
		
		// boolean(논리형): 참(true), 거짓(false)
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("b1: " + b1);
		System.out.println("b2: " + b2);
		System.out.println(10 < 20);
		System.out.println(10 > 20);
		boolean b3 = 10 < 20;
		System.out.println("b3: " + b3);
		
		
		// String 타입
		// String 은 primitive 타입은 아닙니다
		String name = "Hong";   // String literal 은 " ~ " 
		String nick = "thnuder";
		System.out.println("이름은:" + name + "\n별명은:" + nick);

		// ---------------------------------------------
		// TextBlock : Java15 이상
		//   - TextBlock 안에서는 굳이 " 을 escaping 하지 않아도 된다.
		System.out.println("\nTextBlock (Java15이상)");

/* 만약 아래 내용을 String 으로 만드려면?
<html>

	<body>
		<span>example text</span>
	</body>
</html>
 */
		// 기존의 String 이라면 이와 같이 \n \t 등을 꾸덕꾸덕 붙여야 한다.
		String txt1 = "<html>\n" +
				"\t\n" +
				"\t<body>\n" +
				"\t\t<span>example text</span>\n" +
				"\t</body>\n" +
				"</html>";
		System.out.println(txt1);

		//            ↓ 반드시 첫
		String txt2 = """
				Exmple Text""";
		System.out.println(txt2);

		// 아래와 같이 하면 자바는 최소 indent 를 계산하여 문자열 생성
		String txt3 = """
				<html>
				    
				    <body>
				        <span>example text</span>
				    </body>
				</html>""";
		System.out.println(txt3);

		// - TextBlock 안에서는 굳이 " 을 escaping 하지 않아도 된다.
		// 유일하게 escaping 해야 하는 것은 \""" , \\뿐
		System.out.println("""
            "fun" with
            whitespace
            and other escapes \"""
            """);



		System.out.println("\n프로그램 종료");
	} // end main

} // end class Variables05Main







