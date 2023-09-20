package com.lec.java.j19_01_String기본메소드;

import java.util.Arrays;
import java.util.List;

/* 문자열 (String) 관련 메소드들
 * 
 * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
 * - 문자열 메소드는 꼭 정독해보세요.
 * - 매개변수의 의미, 동작의 의미, 리턴값의 의미 꼭 숙지해주세요
 * - 인스턴스 메소드 인지, 클래스 메소드(static) 인지 구분 
 */
public class String01Main {

	public static void main(String[] args) {
		System.out.println("String 클래스의 메소드들");
		
		String str1 = "AbCdEfg";
		String str2 = "안녕하세요~";
		
		System.out.println();
		System.out.println("length()");  // 문자의 개수
		System.out.println("str1 길이: " + str1.length());
		System.out.println("str2 길이: " + str2.length());
		
		System.out.println();
		System.out.println("concat()");  // 문자열 연결 (concatenation)
		System.out.println(str1.concat(str2));
		System.out.println(str2.concat(str1));
		System.out.println(str1.concat(str2).concat(str1));
//		System.out.println(str1.concat(str2).length());
		String str3 = str1.concat(str2);
		System.out.println(str3.length());
		
		// ★주의★
		// 문자열(String) 은 변경불가(immutable) 이기 때문에
		// 메소드 수행했다고 하여 원본이 변경되지 않는다.
		str1.concat(str2);
		System.out.println(str1);   // <-- 변경 안되었다.
		str1 = str1.concat(str2);   // <-- 변경하려면 이와 같이 덮어쓰기 해야 한다
		System.out.println(str1);   
		
		// ★주의★
		// empty 문자열과 null 은 다르다
		// null 인 경우 메소드 수행하면 NullPointerException 발생!
		str3 = "";   // empty 문자열,  문자열 객체가 존재하나 비어있는 문자열
		System.out.println(str3.length());  // 동작
		str3 = null;   // null, 문자열 객체가 존재하지 않음.
		//System.out.println(str3.length());  // NullPointerException
		
		System.out.println();
		System.out.println("charAt(index)"); // 문자열 안의 특정위치(index)의 문자 리턴, 인덱스 범위 벗어나면 StringIndexOutOfBoundsException
		System.out.println(str1.charAt(0));
		System.out.println(str1.charAt(1));
		//System.out.println(str1.charAt(20)); // StringIndexOutOfBoundsException

		System.out.println();
		System.out.println("indexOf(char), indexOf(String)"); // 문자열 안에서 특정 문자(char) 혹은 문자열(String)의 위치(index), 발견 못하면 -1 리턴
		System.out.println(str1.indexOf('C'));  // 2
		System.out.println(str1.indexOf('c'));  // -1
		System.out.println(str2.indexOf('요'));
		System.out.println(str2.indexOf("하세"));  
		
		System.out.println();
		System.out.println("toUpperCase(), toLowerCase");  // 대문자 변환, 소문자 변환
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
		
		System.out.println();
		System.out.println("startsWith(), endsWith()");  // 문자열이 주어진 prefix문자열로 시작하는지 여부 true/false 리턴
		String prefix = "http://";
		String url = "www.google.com";
		System.out.println(url.startsWith(prefix));
		if (!url.startsWith(prefix)) {
			String newUrl = prefix.concat(url);
			System.out.println(newUrl);
		}
		// endsWith(postfix) : 문자열이 주어진 postfix 로 끝나는 문자열인지 여부
		
		System.out.println();
		System.out.println("split(regex)"); // 문자열을 주어진 문자열로 쪼개어 String[] 리턴
		String str4 = "HH:MM:SS";
		String[] arr = str4.split(":");
		System.out.println(Arrays.toString(arr));
		
		// 년,월,일,시,분,초 분리하기
		str4 = "2021-07-26 14:34:52";
//		String date = str4.split(" ")[0];
//		String time = str4.split(" ")[1];
//		String year = date.split("-")[0];

		str4 = "Hello My WORLD";
		System.out.println(Arrays.toString(str4.split(" ")));
		str4 = "     Hello     My    WORLD     ";
		System.out.println(Arrays.toString(str4.split(" ")));


		// 공백기준으로 쪼갤때는 정규표현식의 \s+  사용하기 : 공백, 탭, 줄바꿈
		str4 = "    Hello\t  \n  \t MY \n\n WORLD";
		arr = str4.split("\\s+");
		System.out.println(Arrays.toString(arr));  // [, Hello, MY, WORLD]
		
		// 단!  "|" 을 할경우는 주의,   ※ split(정규표현식) 을 사용하는 메소드임
		String str5 = "HH|MM|SS";
		//strings = str5.split("|");   //  <-- 이렇게 하면 결과 이상해진다. (내부적으로 "|"는 정규표현식에서 boolean (OR)와 같은 동작함. 따라서 아래와 같이 escaping 해야 함)
		arr = str5.split("\\|");
		for (String x : arr) {
			System.out.println(x);
		}
		
		// String.join() 
		// 문자열들, 문자열 배열  --> 하나의 문자열로 합하기     split() 과 반대
		System.out.println();
		System.out.println("String.join(delimeter, elements ...)");
		String[] str7 = {"Alice", "Bob", "Carol"};
		System.out.println( String.join(" - ", str7) );

		// 다양한 방법으로 사용 가능
		System.out.println( String.join(" - ", "Alice", "Bob", "Carol") );
		System.out.println( String.join(" - ", new String[] {"Alice", "Bob", "Carol"}) );
		System.out.println( String.join(" - ", Arrays.asList("Alice", "Bob", "Carol")) );
		List<String> listStr = Arrays.asList("Alice", "Bob", "Carol");
		System.out.println( String.join(" - ", listStr) );
		
		
		System.out.println();
		System.out.println("substring(beginIndex, endIndex)");  // 문자열의 일부분 추출 beginIndex ~ endIndex직전 까지,  인덱스 범위 벗어마면 IndexOutOfBoundsException 
		String str8 = "Hello Java";
		System.out.println(str8.substring(2, 5));  // 2 부터 5 전까지
		System.out.println(str8.substring(6));     // 6부터 끝까지
		
		
		System.out.println();
		System.out.println("trim()");   // 좌우의 여백 제거
		String str9 = "   김동후   ";
		System.out.printf("[%s]\n", str9);
		System.out.printf("[%s]\n", str9.trim());

		// Java11 에 추가:
		// strip()   좌우 공백 제거
		// stripLeading()  좌측 공백 제거
		// stripTrailing() 우측 공백 제거
		System.out.printf("[%s]\n", str9.strip());
		System.out.printf("[%s]\n", str9.stripLeading());
		System.out.printf("[%s]\n", str9.stripTrailing());

		// repeat(n)  문자열 반복
		System.out.println("-".repeat(20));

		System.out.println();
		System.out.println("replace(target, replacement)");   // 문자열 치환  target → replacement  
		String str10 = "Hello Language My Language";
		System.out.println(str10.replace("My", "Our"));
		System.out.println(str10.replace("Language", "Java"));  // 매칭되는거 모두 치환
		
	
		System.out.println();
		System.out.println("replaceAll(regex, replacement), replaceFirst(regex, replacement)"); // 정규표현식 사용버젼  , replaceAll() 매칭되는것 전부 치환, replaceFirst() 첫매칭만 치환
		System.out.println(str10.replaceAll("Language", "자바"));  // 매칭되는것 전부 치환		
		System.out.println(str10.replaceFirst("Language", "자바"));  // 첫매칭만 치환
				
		System.out.println();
		System.out.println("equals(), equalsIgnoreCase()");  // 문자열 비교
		String str11 = "Java";
		String str12 = "java";
		System.out.println(str11.equals(str12));
		System.out.println(str11.toUpperCase().equals(str12.toUpperCase()));
		System.out.println(str11.equalsIgnoreCase(str12));  // 대소문자 구분없이 비교
		
		
		System.out.println();
		System.out.println("String.format()");
		String str13 = String.format("%03d %s %.2f", 12, "hello", 3.141592);
		String str14 = String.format("|%5s|%-5s|", "abc", "abc");
		System.out.println(str13);
		System.out.println(str14);

		// 연습 : id /pw 입력받고요
		//  로그인 성공 여부를 출력해주세요
		
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("id를 입력해주세요:");
//		String logId = sc.nextLine();
//		System.out.print("pw를 입력해주세요:");
//		String logPw = sc.nextLine();
//		
//		if(logId.toUpperCase().equals(id.toUpperCase()) &&
//				logPw.equals(pw)) {
//			System.out.println("로그인 성공");
//		}else {
//			System.out.println("로그인 실패");
//		}
//		
//		sc.close();

		// Java11 에 등장한 String 메소드
		// https://www.baeldung.com/java-11-string-api



		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









