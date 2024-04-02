package practice.capitalize;

import java.util.Scanner;

/* LetterCapitalize
 * 	주어진 문자열에서, 공백으로 구분된 각 단어의 앞 문자를 대문자로 만들어 출력하기
 *
 * 	[입력예]
 * 		hello my WORLD
 *  [출력예]
 * 		Hello My World
 */

public class LetterCapitalize {

    public static String[] input = {
        "i am a PROGRAMMER",     // -> I Am A Programmer
        "THAT ELEPHANT IS BIG",  // -> That Elephant Is Big
    };

    public static void main(String[] args) {

        for(var x : input){
            System.out.println(letterCapitalize(x));
        }

//        Scanner sc = new Scanner(System.in);
//        String str;
//        String[] words;
//        while (true) {
//            str = sc.nextLine().trim();
//            if (str.equalsIgnoreCase("quit")) break;
//            str = str.toLowerCase();  // 일단 소문자로 변환
//            words = str.split("\\s+");  // 공백기준으로 단어 구분
//
//            String result = "";
//            for (String word : words) {
//                String firstLetter = word.substring(0, 1).toUpperCase(); // 맨앞글자를 대문자로
//                String rest = word.substring(1);  // 나머지 문자열
//                result += firstLetter + rest + " ";
//            }
//            System.out.println(result.trim());
//        } // end while
//        sc.close();
    } // end main()

    public static String letterCapitalize(String str){

        str = str.toLowerCase();  // 일단 소문자로 변환
        String [] words = str.split("\\s+");  // 공백기준으로 단어 구분

        String result = "";
        for (String word : words) {
            String firstLetter = word.substring(0, 1).toUpperCase(); // 맨앞글자를 대문자로
            String rest = word.substring(1);  // 나머지 문자열
            result += firstLetter + rest + " ";
        }
        return result.trim();
    }

} // end class













