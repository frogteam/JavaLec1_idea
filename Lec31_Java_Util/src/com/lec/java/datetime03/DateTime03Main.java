package com.lec.java.datetime03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* Calendar 객체를 사용한 시간 및 날짜 연산
 *  
 */
public class DateTime03Main {

	public static void main(String[] args) {
		System.out.println("날짜, 시간 연산");

		Calendar cal = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date date = null;
		
		//-------------------------------------------------------
		System.out.println("현재 시간에서 날짜 더하고 빼기");
		
        cal.setTime(new Date());  // '현재 시간'을 Calendar 에 세팅
        System.out.println("current: " + df.format(cal.getTime()));

        cal.add(Calendar.MONTH, 2);
        cal.add(Calendar.DATE, -3);
        System.out.println("after: " + df.format(cal.getTime()));

        System.out.println();
        System.out.println("특정 날짜에 시간날짜 더하고 빼기");
        df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = df2.parse("2020-03-16 09:01:03");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);  // 위 시간을 Calendar 에 세팅
        System.out.println("current: " + df2.format(cal.getTime()));

        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.MONTH, 2);
        cal.add(Calendar.DATE, 3);
        cal.add(Calendar.HOUR_OF_DAY , 1);  // 24시간제의 시간 
        cal.add(Calendar.MINUTE, 20);
        cal.add(Calendar.SECOND, 10);
        System.out.println("after: " + df2.format(cal.getTime()));
        
        //-------------------------------------------------------
        System.out.println();
        System.out.println("특정 날짜에 더하고 빼기");
        try {
        	// 특정날짜 Date 객체 생성
            date = df.parse("2019-07-04T12:30:30+0530");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        System.out.println("current: " + df.format(cal.getTime()));

        cal.add(Calendar.YEAR, 1);
        cal.add(Calendar.MONTH, 2);
        cal.add(Calendar.DATE, 3);
        cal.add(Calendar.HOUR_OF_DAY , 1);
        cal.add(Calendar.MINUTE, 20);
        cal.add(Calendar.SECOND, 10);
        System.out.println("after: " + df.format(cal.getTime()));
        
        //-------------------------------------------------------
        System.out.println();
        System.out.println("날짜 두개 더하기");
        // 두개의 Date를 더하려면 두개의 Calendar를 사용해야 합니다. 
        // Calendar.get으로 날짜를 가져올 수 있습니다. 
        // 위의 코드를 응용하여 아래와 같이 구현하면 됩니다. 
        // MONTH는 0이 1월을 의미하기 때문에(zero based) 연산을 할 때 1을 더해줘야 합니다
        try {
            cal.setTime(df.parse("2019-07-04"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date()); // 현재 날짜
        
        System.out.println("cal: " + df.format(cal.getTime()));
        System.out.println("cal2: " + df.format(cal2.getTime()));

        cal.add(Calendar.YEAR, cal2.get(Calendar.YEAR));
        cal.add(Calendar.MONTH, cal2.get(Calendar.MONTH) + 1); // Zero-based months
        cal.add(Calendar.DATE, cal2.get(Calendar.DATE));
        System.out.println("after cal: " + df.format(cal.getTime()));
        System.out.println("after cal2: " + df.format(cal2.getTime()));

        
        //-------------------------------------------------------
        // 강의 시작한지 얼마나 지났나?
        
        
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










