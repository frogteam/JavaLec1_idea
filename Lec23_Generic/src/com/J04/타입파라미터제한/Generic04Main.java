package com.J04.타입파라미터제한;

// 참조: https://futurecreator.github.io/2018/08/12/java-generics/
/*
 타입파라미터 제한
      와일드 카드 <?>
		upper-bounded <? extends Number>   Number 타입및 이의 하위 타입들
		lower-bounded <? super Number>    Number 타입및 이의 상위 타입들
		generic 사용 <? extends T>        T 타입및 이의 하위 타입들
*/

import java.util.ArrayList;

// 참조
//      https://devlog-wjdrbs96.tistory.com/201
//  공변성 covariance
//      https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%A0%9C%EB%84%A4%EB%A6%AD-%EC%99%80%EC%9D%BC%EB%93%9C-%EC%B9%B4%EB%93%9C-extends-super-T-%EC%99%84%EB%B2%BD-%EC%9D%B4%ED%95%B4
//     https://driip.me/d875a384-3fb9-471b-a53b-b3ca52f8238e

/*
    타입 계층 관계가 존재하는 타입 시스템에는
    Covariance(공변선)와 Contravariance(반공변성)라는 개념(+ Invariance, Bivariance)이 존재한다.
 */

public class Generic04Main {
    public static void main(String[] args) {
        System.out.println("\n타입 파라미터 제한");

        // test1(new A());
        test1(new B());
        test1(new C());
        test1(new D());

        System.out.println();
        test2(new Box<A>());
        test2(new Box<B>());
        test2(new Box<C>());
        test2(new Box<D>());

        // test3, test4 가 generic method 는 아니지만, 매개변수인 generic class  에 타입 파라미터 제한을 줄수 있다
        System.out.println();
        //test3(new Box<A>());
        test3(new Box<B>());  // new Box<>()  해도 동작.
        test3(new Box<C>());
        test3(new Box<D>());

        System.out.println();
        test4(new Box<A>());
        test4(new Box<B>());
        test4(new Box<C>());
        //test4(new Box<D>());


        // -----------------------------
        // 제네릭은 공변성(covariance) 이 없다
        // 공변성?
        A a = new A();
        B b = new B();
        a = b;  // 가능 (공변성?)

        // 배열의 경우
        // 배열은 공변성이 있다!
        Object[] Covariance = new Integer[10];  // 가능
        // 배열은 반공변성이 있다!
        Integer[] Contravariance = (Integer[]) Covariance;

        // Generic 클래스의 경우
        Box<A> boxA = new Box<>();
        Box<B> boxB = new Box<>();
        // boxA = boxB;  // 불가.  Generic 클래스는 공변성이 없다.

//        ArrayList<Object> Covariance = new ArrayList<Integer>();  // 불가
        System.out.println("\n프로그램 종료");
    } // end main()

    public static <T extends B> void test1(T param){
        System.out.println(param.getClass());
    }

    public static void test2(Box<?> box){}
    public static void test3(Box<? extends B> box){}
    public static void test4(Box<? super C> box){}

    // ↓보류
    public static <T> void test5(Box<? extends T> box){

    }
} //end class


class A {}
class B extends A{}
class C extends B{}
class D extends C{}

class Box<T>{
//    T value;
//    Box(){}
//    Box(T value){
//        this.value = value;
//    }
}
