package 구조체.형성평가05;

import java.util.Scanner;

/*
199 : 구조체 - 형성평가5 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=99&sca=10g0

[문제]
10 이하의 정수 n을 입력받은 후 n명의 이름(한글 4글자이하)과 세 과목의 점수를 입력받아 총점이 높은 순으로 정렬하여 출력하는 프로그램을 작성하시오.


[입력예]
3
심청 50 65 89
놀부 100 38 99
흥부 85 95 77

[출력예]
흥부 85 95 77 257
놀부 100 38 99 237
심청 50 65 89 204
*/
public class Main {

	static Student [] arrStudent = new Student[10];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		// 입력
		for(int i = 0; i < n; i++){			
			String name = sc.next();
			int subj1 = Integer.parseInt(sc.next());
			int subj2 = Integer.parseInt(sc.next());
			int subj3 = Integer.parseInt(sc.next());
			arrStudent[i] = new Student(name, subj1, subj2, subj3);
			arrStudent[i].calcTotal();
		} // end for
		
		// 정렬하기, 버블 정렬
		for(int j = n ; j > 1; j--){
			for(int i = 0; i < j - 1; i++){
				// i 번째와 i + 1 번째 비교			
				if( arrStudent[i].getTotal() < arrStudent[i + 1].getTotal()){
					Student tempStudent = arrStudent[i];
					arrStudent[i] = arrStudent[i + 1];
					arrStudent[i + 1] = tempStudent;
				} // end if
			} // end for
		} // end for
		
		// 출력하기		
		for(int i = 0; i < n; i++){
			System.out.println(arrStudent[i].getName() + " " + arrStudent[i].getSubj1() + " " + 
					arrStudent[i].getSubj2() + " " +  
					arrStudent[i].getSubj3() + " " +
					arrStudent[i].getTotal() );
		}
		
		sc.close();
	} // end main()
} // end class

class Student {
	private String name;
	private int subj1;
	private int subj2;
	private int subj3;
	private int total;
	public Student() {
		super();
	}
	public Student(String name, int subj1, int subj2, int subj3) {
		super();
		this.name = name;
		this.subj1 = subj1;
		this.subj2 = subj2;
		this.subj3 = subj3;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSubj1() {
		return subj1;
	}
	public void setSubj1(int subj1) {
		this.subj1 = subj1;
	}
	public int getSubj2() {
		return subj2;
	}
	public void setSubj2(int subj2) {
		this.subj2 = subj2;
	}
	public int getSubj3() {
		return subj3;
	}
	public void setSubj3(int subj3) {
		this.subj3 = subj3;
	}
	
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int calcTotal(){
		total = subj1 + subj2 + subj3;
		return total;
	}
	
	
}

