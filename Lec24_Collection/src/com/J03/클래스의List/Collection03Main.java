package com.J03.클래스의List;

import dataset.DataSet;
import dataset.Score;
import dataset.Student;

import java.util.Arrays;
import java.util.List;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		// Student를 저장할 수 있는 ArrayList 인스턴스 생성
		List<Student> students = DataSet.students;

		System.out.println(students);  // 일단 출력


		// 김동혁 학생의 정보 수정 (김동혁 학생이 List의 몇번째 저장되었는지 모른다고 하면?)
		// id 값 -> "D002"
		// 국어, 영어, 수학 -> 99, 88, 76

		for(int i = 0; i < students.size(); i++) {
			Student stu = students.get(i);
			if("김동혁".equals(stu.getName())) {
				System.out.println("수정전: " + stu);

				stu.setId("D002");
				stu.getScore().setKorean(99);
				stu.getScore().setEnglish(88);
				stu.getScore().setMath(76);

				System.out.println("수정후: " + stu);
				break;
			}
		}

		System.out.println(students);

		// TODO
		// 1학년과 3학년 출력하세요
		System.out.println("\n1학년, 3학년 학생 출력");
		{
			for(var stu : students){
				if(stu.getGrade() == 1 || stu.getGrade() == 3){
					System.out.println(stu);
				}
			}
		}

		// TODO
		// 3학년 이상의 학생이 몇명인지 출력하세요
		// 6명
		System.out.println("\n3학년 이상 학생수");
		{
			int cnt = 0;
			for(var stu : students){
				if(stu.getGrade() >= 3) cnt++;
			}
			System.out.println(cnt + "명");
		}

		// TODO
		// 각 전공별로 학생이 몇명인지 출력해보세요
		// 출력예시]
		// SoftWare: 6
		// Design: 2
		// Theater: 1
		// Advertisement: 1명

		System.out.println("\n전공별 학생수");
		{
			int softCnt = 0;
			int designCnt = 0;
			int theaterCnt = 0;
			int adCnt = 0;

			for(var stu : students){
				switch(stu.getMajor()){
					case "Software":
						softCnt++;
						break;
				}
			}

		}

		// TODO
		// 학점의 최댓값, 최솟값, 평균값 을 출력해보세요
		//
		// [출력예시]
		// Max: 4.4
		// Min: 1.8
		// Avg: 3.28

		// 삭제: remove()
		students.remove(1);
		System.out.println("삭제 후:");
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		} // end for


		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Collection05Main









