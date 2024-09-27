package com.J03.클래스의List;

import dataset.DataSet;
import dataset.Score;
import dataset.Student;

import java.util.Arrays;
import java.util.List;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("List 연습");

		// Student를 저장할 수 있는 ArrayList 인스턴스 생성
		List<Student> students = DataSet.students;

		for(var e : students) System.out.println(e);  // 일단 출력

		//------------------------------------------------------------
		// 김동혁 학생의 정보 수정 (김동혁 학생이 List의 몇번째 저장되었는지 모른다고 하면?)
		// id 값 -> "D002"
		// 국어, 영어, 수학 -> 99, 88, 76
		// 출력예시]
		//  수정전: Student{id='D001', name='김동혁', grade=3, major='Design', score=[국: 80,영:100,수: 90]}
		//  수정후: Student{id='D002', name='김동혁', grade=3, major='Design', score=[국: 99,영: 88,수: 76]}
		System.out.println("\n학생 정보 수정");
		{
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
		}

		for(var e : students) System.out.println(e);

		//------------------------------------------------------------
		// 1학년 과 3학년 출력하세요
		// 출력예시]
		//		Student{id='S001', name='김남승', grade=3, major='Software', score=[국:100,영: 90,수: 80]}
		//		Student{id='D002', name='김동혁', grade=3, major='Design', score=[국: 99,영: 88,수: 76]}
		//		Student{id='S006', name='Clint', grade=3, major='Software', score=[국: 99,영: 80,수: 21]}
		//		Student{id='T001', name='Peter', grade=1, major='Theater', score=[국: 59,영: 88,수: 21]}
		System.out.println("\n1학년, 3학년 학생 출력");
		{
			for(var stu : students){
				if(stu.getGrade() == 1 || stu.getGrade() == 3){
					System.out.println(stu);
				}
			}
		}

		//------------------------------------------------------------
		// 3학년 이상의 학생이 몇명인지 출력하세요
		//  출력예시]
		// 		6명
		System.out.println("\n3학년 이상 학생수");
		{
			int cnt = 0;
			for(var stu : students){
				if(stu.getGrade() >= 3) cnt++;
			}
			System.out.println(cnt + "명");
		}

		//------------------------------------------------------------
		// 각 전공별로 학생이 몇명인지 출력해보세요
		// 출력예시]
		// 	SoftWare: 6
		// 	Design: 2
		// 	Theater: 1
		// 	Advertisement: 1
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
					case "Design":
						designCnt++;
						break;
					case "Advertisement":
						adCnt++;
						break;
					case "Theater":
						theaterCnt++;
						break;
				}
			}

			System.out.println("Software: " + softCnt);
			System.out.println("Design: " + designCnt);
			System.out.println("Advertisement: " + adCnt);
			System.out.println("Theater: " + theaterCnt);

		}

		// 평균의 최댓값, 최솟값 을 출력해보세요
		//
		// [출력예시]
		// 	Max: 99.0
		// 	Min: 43.7
		System.out.println("\n평균 의 최댓값, 최솟값");
		{
			double max = 0, min = 100.0;
			for(var stu : students){
				Score score = stu.getScore();
				double avg = (score.getEnglish() + score.getMath() + score.getKorean()) / 3.0;
				if(max < avg) max = avg;
				if(min > avg) min = avg;
			}
			System.out.printf("Max: %.1f\n", max);
			System.out.printf("Min: %.1f\n", min);
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









