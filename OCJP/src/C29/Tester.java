package C29;

import java.io.IOException;

class A{
    void foo() throws Exception {
        throw new Exception();
    }

    void goo() {}
    void hoo() {}
}

class Sub2 extends A {
    void foo(){
        System.out.println("B ");
    }

    void goo() throws RuntimeException {}
    //void hoo() throws Exception {}
}


public class Tester {
    public static void main(String[] args) {
        A a = new Sub2();
        //a.foo();
    }
}
