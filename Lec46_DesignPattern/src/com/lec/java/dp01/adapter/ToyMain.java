package com.lec.java.dp01.adapter;


// Adapter 패턴
//  한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환한다. 
//  어댑터를 이용하면 인터페이스의 호환성 문제 떄문에 같이 쓸 수 없는 클래스를 연결해 쓸 수 있다.


public class ToyMain {

	public static void main(String[] args) {
	       // 구 모델의 장난감
        OldtypeToy oldToy = new OldToy("old");
        // 신 모델의 장난감
        NewtypeToy newToy = new NewToy("new");
        // 구 모델의 장난감을 어댑터를 통해 신모델처럼 사용
        ToyAdapter adater = new ToyAdapter(oldToy);
         
        oldToy.use();
        newToy.use();
 
        // 신모델 충전
        newToy.onUSBCharge();
 
        // 구모델을 신모델 충전으로 사용하기 위해
        // 어뎁터에 추가했으므로, 어뎁터의 충전을 호출 함
        adater.onUSBCharge();
	}

}
