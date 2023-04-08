package 입력.자가진단05;
/*
513 : 입력 - 자가진단5

1야드(yd)는 91.44cm이고 1인치(in)는 2.54cm이다.
2.1야드와 10.5인치를 각각 cm로 변환하여 다음 형식에 맞추어 소수 첫째자리까지 출력하시오.​

[출력예]
 2.1yd = 192.0cm
10.5in =  26.7cm
 */
public class Main {

	public static void main(String[] args) {
		double yard = 2.1;
		double cm1 = 91.44;
		double inch = 10.5;
		double cm2 = 2.54;
		
		System.out.printf("%4.1fyd = %5.1fcm\n", yard, yard * cm1);
		System.out.printf("%4.1fin = %5.1fcm\n", inch, inch * cm2);
	}

}
