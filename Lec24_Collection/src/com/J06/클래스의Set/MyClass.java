package com.J06.클래스의Set;

// Set 에서 같은지 다른지, 식별 가능하려면
// hashCode 와 equals 가 오버라이딩 되어야 한다
// hashCode() 값이 같고 equals() 결과가 true 이어야만 같은 객체로 판정한다.
public class MyClass {
    int a;
    int b;

    public MyClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
        return a;
    }

    @Override
    public boolean equals(Object obj) {
        return a == ((MyClass) obj).a;
    }
}
