package com.J04.타입파라미터제한;

// 참조: https://futurecreator.github.io/2018/08/12/java-generics/
//      와일드 카드 <?>
//		upper-bounded <? extends Number>
//		lower-bounded <? super Integer>
//		generic 사용 <? extends T>

import java.util.ArrayList;

// 참조
//      https://devlog-wjdrbs96.tistory.com/201
//  공변성 covariance
//      https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%A0%9C%EB%84%A4%EB%A6%AD-%EC%99%80%EC%9D%BC%EB%93%9C-%EC%B9%B4%EB%93%9C-extends-super-T-%EC%99%84%EB%B2%BD-%EC%9D%B4%ED%95%B4
public class Generic04Main {
    public static void main(String[] args) {
        // test1(new A());
        test1(new B());
        test1(new C());
        test1(new D());

        test2(new Box<A>(new A()));
        test2(new Box<B>(new B()));
        test2(new Box<C>(new C()));
        test2(new Box<D>(new D()));

        //test3(new Box<A>(new A()));  // 에러
        test3(new Box<B>(new B()));
        test3(new Box<C>(new C()));
        test3(new Box<D>(new D()));

        test4(new Box<A>(new A()));
        test4(new Box<B>(new B()));
        test4(new Box<C>(new C()));
        // test2(new Box<D>(new D()));  // 에러

        // ↓보류
        test5(new Box<A>(new A()));
        test5(new Box<B>(new B()));
        test5(new Box<C>(new C()));
        test5(new Box<D>(new D()));

        // -----------------------------
        // 제네릭은 공변성(covariance) 이 없다
        // 공변성?
        A a = new A();
        B b = new B();
        a = b;  // 가능 (공변성?)


        // 공변성
        Object[] Covariance = new Integer[10];  // 가능
        // 반공변성
        Integer[] Contravariance = (Integer[]) Covariance;

        Box<A> boxA = new Box<>();
        Box<B> boxB = new Box<>();
        // boxA = boxB;  // 불가

        //ArrayList<Object> Covariance = new ArrayList<Integer>();
    }

    public static <T extends B> void test1(T param){
        System.out.println(param.getClass());
    }

    public static void test2(Box<?> box){
        System.out.println("test2 box.value : " + box.value.getClass());
    }

    public static void test3(Box<? extends B> box){
        System.out.println("test3 box.value : " + box.value.getClass());
    }

    public static void test4(Box<? super C> box){
        System.out.println("test4 box.value : " + box.value.getClass());
    }

    // ↓보류
    public static <T> void test5(Box<? extends T> box){

    }
}


class A {}
class B extends A{}
class C extends B{}
class D extends C{}

class Box<T>{
    T value;
    Box(){}
    Box(T value){
        this.value = value;
    }
}
