package com.lec.java.dp03.strategy;


// Strategy 패턴
// 전체적인 로직에는 큰 차이가 없지만 일부분만 바뀌는 비스무레한 몇 가지 클래스가 있을때. 
// 일부분을 위해서 전체를 새로 작성할 필요는 없습니다.
// Starategy는 '바뀌는 부분'을 인터페이스로 분리하여 처리합니다. 
// 그 인터페이스의 구현체를 바꿈으로서 로직을 변경하는 것입니다. 
// Strategy에서는 인터페이스를 사용하는 클래스를 통해 사용하게 됩니다.

// Strategy 유용성
// Context 클래스가 한 개의 Strategy 인터페이스만을 가집니다. Seller 외에 여러가지 인터페이스를 가질 수도 있습니다. 
// 예를 들어 만드는 사람, 운반하는 사람, 파는 사람은 각각 다를 수 있습니다. 
// 예제에서는 코드를 줄이기 위해 파는 사람만 2가지 종류의 클래스를 만들었습니다. 
// 그러나, 만드는 사람 인터페이스와 운반하는 사람 인터페이스 등을 만들고 그 구현체 들을 만들면, 
// 상당히 다양한 로직이 나올 수 있습니다. 만드는 사람의 구현체가 3종류, 운반하는 사람의 구현체가 3종류, 
// 파는 사람의 구현체가 3종류라하면, 만들어서 운반해서 파는 로직은 총 3*3*3= 27가지가 나옵니다. 
// 이를 상속을 이용한 클래스를 제작하면, 27가지의 구현체가 필요합니다. 
// Strategy를 쓰면, 9개의 구현체만 필요하며, 또 인터페이스를 이용한 프로그램이 가능합니다.

public class StrategyMain {

	public static void main(String[] args) {
        Seller cupSeller = new CupSeller();
        Seller phoneSeller = new PhoneSeller();
        Mart mart1 = new Mart(cupSeller);
        mart1.order();
        Mart mart2 = new Mart(phoneSeller);
        mart2.order();
	} // end main
} // end class
