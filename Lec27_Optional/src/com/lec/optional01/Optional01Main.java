package com.lec.optional01;

import common.Address;
import common.User;

// 선행 : 함수형 인터페이스. Consumer, Predicate 등

/* 자바의 가장 큰 고질적인 문제 => null 체크
 * 	NPE (NullPointerException) 을 피하려면 꼭 null 여부 체크 필요
 * 
 */

// https://multifrontgarden.tistory.com/131?category=471239
public class Optional01Main {

	public static void main(String[] args) {
		System.out.println("null check");

		User user1 = new User();
		userInfo1(user1);

		User[] arr = new User[3];
		User user2 = arr[0];
		userInfo2(user1);  // null
		// userInfo2(user2); // NPE
		userInfo3(user2);

		System.out.println("\n프로그램 종료");
	} // end main()

	public static void userInfo1(User user) {
		System.out.println(user);
	}

	public static void userInfo2(User user) {
		System.out.println(user.getAddress());
	}

	public static void userInfo3(User user) {
		// 자바는 NPE 방어하기 위한 방어코드가 필수다!
		if (user != null) {
			System.out.println(user.getAddress());
		}
	}

	public static void userStreet(User user) {
		//  null 체크 때문에 지저분해진 코드
		if (user != null) {
			Address address = user.getAddress();
			if (address != null) {
				String street = address.getStreet();
				if (street != null) {
					System.out.println(street.toUpperCase());
				}
			}
		}

		System.out.println("street 없슴");
	}

} // end class