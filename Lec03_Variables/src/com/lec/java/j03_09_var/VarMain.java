package com.lec.java.j03_09_var;

/*  Local-Variable Type Inference  (Java10 이상)
    지역변수 타입 추론 : var 키워드 로 변수 선언
    컴파일러가 '타입'을 추론함

    https://openjdk.org/jeps/286

    제약사항
        1. 지역변수에만 사용!
        2. 반드시 초기화 필요.
        3. null 초기화 불가
        4. 배열에는 사용 불가
        5. lambda  에 사용 가능 (Java11 부터)
 */

// 참조 : https://codechacha.com/ko/java-local-variable-type-inference/

public class VarMain {
    public static void main(String[] args) {
        var str1 = "Hello, World";  // str1 는 String 타입
        System.out.println(str1);

        var num1 = 100;    // num1 은 int 타입
        var num2 = 3.14;   // double 타입
        var num3 = 100.45f;  // float 타입
        var num4 = 1234L;    // long 타입

        // num1 = "hello";  // 불가
    } // end main
} // end class
