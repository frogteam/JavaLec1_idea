package com.lec.java.hello;

/*
 * Java 첫 프로그램.
 * [학습목표]
 * - 기본 출력 : println(), print()
 * - 주석 (Comment)
 */
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello Java!");

        System.out.print("안녕하세요 ");  // print() 는
        System.out.println("자바");

        System.out.println();  // 매개변수 없이 사용하면 한 라인 띄우기만 함.
        System.out.println();

        // IntelliJ 에선
        // sout 입력하고 Tab 누르면 System.out.println() 자동작성됨.
        // Settings - Editor - Live Template 에서 목록 확인 가능
        System.out.println(1 + 2);
        System.out.println("1" + "2");
        System.out.println(true + "good");
        System.out.println('A' + 'B');
        System.out.println('1' + 2);
        System.out.println('1' + '2');
        System.out.println('J' + "ava");
        //System.out.println(true + null);

    }
}