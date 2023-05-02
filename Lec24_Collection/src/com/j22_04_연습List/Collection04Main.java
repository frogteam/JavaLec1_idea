package com.lec.java.j22_04_연습List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		// MemberModel을 저장할 수 있는 ArrayList 인스턴스 생성
		List<MemberModel> list = new ArrayList<MemberModel>(); // 다형성
		
		// 데이터 저장: add()
		MemberModel m1 = new MemberModel("root", "root1234");
		list.add(m1);
		
		MemberModel m2 = new MemberModel("admin", "admin123456");
		list.add(m2);
		
		list.add(new MemberModel("guest", "abcd"));
		
		System.out.println();
		// 검색: get()
		for (int i = 0; i < list.size(); i++) {
			list.get(i).displayInfo();
		} // end for
		
		System.out.println();
		// 삭제: remove()
		list.remove(1);
		System.out.println("삭제 후:");
		for (MemberModel member : list) {
			member.displayInfo();
		} // end enhanced for
		
		
		System.out.println();
		// 수정: set()
		MemberModel member = list.get(0); // 수정할 데이터 가지고 옴
		member.setPasswd("root123456"); // MemberModel 수정
//		MemberModel member = new MemberModel("root2", "root123456");
//		list.set(0, member); // list의 0번째 데이터 수정

		// TODO
		// id "root" 의 비밀번호(passwd) 를 "9999" 로 변경하세요
		// 단, id "root" 가 List<> 안의 몇번째 데이터인지 모른다고 가정.
		for(int i = 0 ;  i < list.size(); i++) {
			MemberModel m = list.get(i);
			if(m.getId().equals("root")) {
				m.setPasswd("9999");
				break;
			}
		}
		
		
		System.out.println("수정 후:");
		for (MemberModel m : list) {
			m.displayInfo();
		}
		
		// Iterator
		System.out.println();
		System.out.println("Iterator 사용");
		Iterator<MemberModel> itr = list.iterator();
		while (itr.hasNext()) {
//			MemberModel m = itr.next();
//			m.displayInfo();
			
			itr.next().displayInfo();
			
//			MemberModel m = itr.next();
//			System.out.println("id: " + m.getId());
//			System.out.println("passwd: " + m.getPasswd());
			
		} // end while
		
		//com.lec.java.collection07 학습후
		// forEach() 로 출력하기
		list.forEach(System.out::println);
		// 그냥은 안된다? 과연 어떻게 해야 할까?

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












