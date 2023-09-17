package practice.capitalize;

import java.util.Scanner;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 *
 * 	[입력예]
 * 		hello my WORLD
 *  [출력예]
 * 		Hello My World
 */

public class LetterCapitalize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        String[] words;
        while (true) {
            str = sc.nextLine().trim();
            if (str.trim().equalsIgnoreCase("quit")) break;
            str = str.toLowerCase();  // 일단 소문자로 변환
            words = str.split("\\s+");  // 공백기준으로 단어 구분

            String result = "";
            for (String word : words) {
                String firstLetter = word.substring(0, 1).toUpperCase(); // 맨앞글자를 대문자로
                String rest = word.substring(1);  // 나머지 문자열
                result += firstLetter + rest + " ";
            }
            System.out.println(result.trim());
        } // end while
        sc.close();
    } // end main()
} // end class
