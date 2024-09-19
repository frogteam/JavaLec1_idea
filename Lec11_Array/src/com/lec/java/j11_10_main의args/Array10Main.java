package com.lec.java.j11_10_main의args;

import java.util.Arrays;

/* main() 의 매개변수 String[] args
 */
public class Array10Main {

	// 윈도우 환경에서 path 설정이 되어 있으면 커맨드 창 에서 
	// bin>java com.lec.java.array12.Array12Main ~~ ~~  
	// 이클립스 환경에선 Run-Run configuration 에서 [Argument] 를 설정해주면 된다.

	/**
	 * IntelliJ 에선
	 * ①
	 * main() 좌측의 실행버튼 ▷ 을 눌러서 run configuration 을 추가한뒤
	 * Edit configurations... 에 들어가서 Program arguments 에 실행 옵션 추가
	 *
	 * ②
	 * 터미널 창에서
	 * > cd \out\production\Lec11_Array
	 * > java com.lec.java.j11_10_main의args.Array10Main aaa bbb ccc
	 *
	 */
	public static void main(String[] args) {
		System.out.println("main 메소드 매개변수: String[] args");
		
		System.out.println("args.length = " + args.length);
		System.out.println("args: " + Arrays.toString(args));

		for(String name : args) {
			System.out.println("안녕하세요, " + name);
		}


		
	} // end main

} // end class Array12Main

// ※ IntellJ 터미널에서 실행해보기
//





