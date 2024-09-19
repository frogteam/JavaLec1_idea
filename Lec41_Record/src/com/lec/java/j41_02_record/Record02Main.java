package com.lec.java.j41_02_record;

/**
 * Record (레코드)
 *
 *  클래스가 '데이터 클래스'임을 명시적으로 선언
 *  레코드는 필드 타입과 이름만 필요한 immutable 데이터 클래스다.
 *  equals, hashCode, toString, private, final, public constructor 는 컴파일러가 자동 생성된다.
 *
 *
 *  레코드는 다른 클래스를 상속받을 수 없으며,
 *  private final fields 이외의 인스턴스 필드를 선언할 수 없습니다.
 *  선언되는 다른 모든 필드는 static 이어야 합니다.
 *
 *
 *  반복적인 데이터클래스는 레코드로 대체하여 사용하면 좋다.
 *
 *
 *
 */
public class Record02Main {

    // record 키워드를 사용한 record 생성
    public record Person(String name, String address){}

    // ↑ ※ IntelliJ 에서 class strcucture 로 확인해보자 (ALT+7)
    //   아이콘 모양도 다르고
    //   클래스는 public static final (? 으잉)
    //   필드는 final 이다.
    //   그런데 .. 딱히 생성자나..  equals, toString 등은 보이진 않는다.

    public static void main(String[] args) {
        System.out.println("Record 레코드");


        System.out.println("\n프로그램 종료");
    } // end main()

} // end class










































