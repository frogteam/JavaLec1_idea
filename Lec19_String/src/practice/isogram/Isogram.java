package practice.isogram;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*	Isogram
	문자열을 입력받으면 isogram 여부를 판단하여 true/false 를 출력하다가, quit 가 입력되면 종료
	isogram 이란?  : 중복된 알파벳이 없는 단어
	
	isogram 예) Machine, isogram, Alphabet, quit
	Machine
	isogram
	Alphabet
	quit
*/

/*******************************
 * isogram : 중복글자 없는 단어
 * isogram 여부 판단하기 (true/false)
 */

public class Isogram {

    public static final String[] input = {
            "Dermatoglyphics", // -> true
            "programmer",      // -> false
            "Cocktail",         // -> false  대소문자 동일
            "isogram",         // -> true
    };


    // main 은 수정하지 마세요
    public static void main(String[] args) 
    {
        for(var word : input){
            System.out.println(is_isogram(word));
        }
    }

    static boolean is_isogram(String str) {

        // 방법1  Arrays.sort() 사용
//        str = str.toLowerCase();
//        int len = str.length();
//
//        char arr[] = str.toCharArray();
//
//        Arrays.sort(arr);
//        for (int i = 0; i < len - 1; i++) {
//            if (arr[i] == arr[i + 1])
//                return false;
//        }
//        return true;

        // 방법2 : substring() 과 indexOf(), charAt() 사용
        str = str.toLowerCase();
        for(int i = 0; i < str.length() - 1; i++) {
            // 같은 문자 발견되면 무조건 false
            if(str.substring(i + 1).indexOf(str.charAt(i)) != -1) return false;
        }
        return true;

        // 방법3: Set<> 사용
//        str = str.toLowerCase();
//        HashSet<Character> charSet = new HashSet<>();
//
//        for (char c : str.toCharArray()) {
//            // 이미 존재하면 중복이므로 false 반환
//            if (!charSet.add(c)) {
//                return false;
//            }
//        }
//
//        return true; // 중복이 없으면 true 반환
    }

} // end class

