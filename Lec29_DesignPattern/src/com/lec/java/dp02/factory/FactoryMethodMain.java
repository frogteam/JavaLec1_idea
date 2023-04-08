package com.lec.java.dp02.factory;


// Factory Method 패턴
// factory는 공장이죠. 객체를 찍어(?)내는 디자인 패턴.
// 일반적인 객체 선언은 보통 new 객체() 이런식으로 하지만,
// Factory Method 패턴에선  내부에서 그런 일을 해줍니다. 
// 즉 factory를 가져다가 쓰는 부분에서는 new 객체()와 같은 식으로 변수를 선언할 필요가 없습니다.
// 
// Factory Method 패턴의 유용성
// Animal a1 = AnimalFactory.create("소"); 와 같은 코드에서 
// a1이 Cow라는 것을 굳이 신경쓰지 않겠다는 겁니다. Test클래스 안에는 new 라는 구문 자체가 없습니다. 
// 정확히 어떤 클래스의 인스턴스인지 신경쓰지 않고 구현할 수 있는 장점이 있습니다. 객체 타입이 굉장히 유연해짐.
//
//
// Animal 인터페이스
//  |__ Cat
//  |__ Cow
//  |__ Dog
//

public class FactoryMethodMain {
	
	public static void main(String[] args) {
        Animal a1= AnimalFactory.create("소");
        a1.printDescription();
        Animal a2= AnimalFactory.create("고양이");
        a2.printDescription();
        Animal a3= AnimalFactory.create("개");
        a3.printDescription();
	}

}
