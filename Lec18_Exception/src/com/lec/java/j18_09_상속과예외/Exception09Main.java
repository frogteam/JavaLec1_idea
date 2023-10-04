package com.lec.java.j18_09_상속과예외;

import java.io.IOException;

/**
 * 상속과 오버라이딩에서
 * 부모 메소드 쪽에 선언된 throws 구문을 자식이 명시 안해도 이미 설정한거다
 * 부모 쪽에 명시 안된 checked exception 을 자식이 명시할수 없다
 *   --> checked exception 은 부모쪽에 명시되어야 한다.
 * 부모 쪽에 명시 안된 unchecked exception 을 자식이 명시할수는 있다.
 */
public class Exception09Main {
}

class A{
    void foo() throws Exception {
        throw new Exception();
    }

    void goo() {}
    void hoo() {}

    void zoo() throws IOException {}
}

class Sub2 extends A {
    void foo(){
        System.out.println("B ");
    }

    void goo() throws RuntimeException {}  //  자식쪽에서 unchecked exception 가능
    //void hoo() throws Exception {}  // 에러
    
    // void zoo() throws Exception{}  // 에러
}