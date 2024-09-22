package com.lec.java.j41_02_record;

import java.util.HashSet;
import java.util.Set;

/**
 * Record (레코드)
 *
 *  레코드 클래스는 이 클래스가 '데이터 클래스'임을 명시적으로 선언
 *  레코드는 필드 타입과 이름만 필요한 immutable 데이터 클래스다.
 *  equals, hashCode, toString, private, final, public constructor 는 컴파일러가 '자동 생성' 해준다!
 *
 *  레코드 제약조건
 *    레코드는 다른 클래스를 상속받을 수 없으며,
 *    private final fields 이외의 인스턴스 필드를 선언할 수 없습니다.
 *    선언되는 다른 모든 필드는 static 이어야 합니다.
 *    레코드는 final 이며, abstract 일수 없다.
 *
 *
 *  레코드 용도
 *     반복적인 데이터클래스는 레코드로 대체하여 사용하면 좋다.
 *
 */
public class Record02Main {

    // 'record' 키워드를 사용한 record 클래스 생성해보기
    public record Person(String name, String address){}

    // ↑ ※ IntelliJ 에서 class strcucture 로 확인해보자 (ALT+7)
    //   아이콘 모양도 다르고
    //   클래스는 public static final (? 으잉)
    //   필드는 final 이다.
    //   그런데 .. 딱히 생성자나..  equals, toString 등은 보이진 않는다.

    public static void main(String[] args) {
        System.out.println("Record 레코드");


        // ------------------------------------------------------------------
        //  ① record를 생성하면 각 필드에 argument가 있는
        //    표준 생성자(canonical constructor)가 생성됩니다.
        //
        //  public Person(String name, String address) {
        //      this.name = name;
        //      this.address = address;
        //  }

        // ↓ 클래스와 같은 방식으로 레코드로부터 객체를 인스턴스 할수 있다.
        Person person = new Person("홍길동", "서울");

        // ------------------------------------------------------------------
        // ② Getter
        //   필드 이름과 동일한 이름의 getter 메소드
        System.out.println(person.name());
        System.out.println(person.address());

        // ------------------------------------------------------------------
        // ③ equals()
        //  equals 메서드가 생성됩니다.
        //   이 메서드는 제공된 객체의 타입이 동일하고 모든 필드 값이 일치하는 경우 true를 반환.
        Person p1 = new Person("홍길동", "서울");
        Person p2 = new Person("이동희", "관악구");

        System.out.println(person == p1); // false
        System.out.println(person.equals(p1)); // true
        System.out.println(person.equals(p2)); // false

        // ------------------------------------------------------------------
        // ④ toString()
        // 레코드의 이름과 각 필드의 이름 및 대괄호 안의 해당 값이 포함된 문자열을 반환하는 toString 메서드 제공
        System.out.println(person);
        System.out.println(p2);

        // ------------------------------------------------------------------
        // ⑤ hashCode()
        // 두 개체의 필드 값이 모두 일치하는 경우, 두 Person 개체에 대해 동일한 값을 반환하는 hashCode 메서드를 생성

        {
            class Member {
                String name;
                String address;

                Member(String name, String address) {
                    this.name = name;
                    this.address = address;
                }
            } // end local inner class

            Member m1 = new Member("홍길동", "서울");
            Member m2 = new Member("홍길동", "서울");

            // 다음 2개는 다르다.
            System.out.println(m1.hashCode());
            System.out.println(m2.hashCode());

            System.out.println(Set.of(m1, m2).size());  // 2, 다른 객체니까

            // person 과 p1 의 hashCode 는 같고, equals() 도 같다.
            // 따라서 아래는 에러 발생한다.
            //System.out.println(Set.of(person, p1)); // java.lang.IllegalArgumentException: duplicate element: Person[name=홍길동, address=서울]
        } // end block

        {
            // 레코드를 상속불가
//            class A extends Person {}

            // 레코드는 타 클래스 상속 불가
//            record B extends Person {}
        }



        System.out.println("\n프로그램 종료");
    } // end main()

} // end class










































