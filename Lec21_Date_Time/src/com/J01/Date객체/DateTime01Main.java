package com.J01.Date객체;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* 자바에서 날짜/시간을 다루는 객체들
 * java.util.Date (JDK 1.0 부터..)
 * 		├ java.sql.Date
 * 		├ java.sql.Time
 * 		└ java.sql.Timestamp
 * 
 * java.util.Calendar (JDK 1.1 부터..)
 * java.time.* 패키지 (JDK 1.8 (Java8) 부터..)
 * 
 * 지금은 java.time 패키지만으로 충분하긴 하나.. 
 * 오랜시간 Date, Calendar 를 사용하여 만들었으므로 이 또한 알긴 알아야 한다
 * 
 */
public class DateTime01Main {

	public static void main(String[] args) throws Exception{
		System.out.println("Date객체로 날짜 다루기");
		// 현재 날짜 얻어오기,  생성자가 현재 날짜, 시간을 얻어온다.
		Date now = new Date();  
		String strNow1 = now.toString();  // dow mon dd hh:mm:ss zzz yyyy 포맷으로 변환
		System.out.println("1. Date 의 toString() 사용한 출력");
		System.out.println(strNow1);
		
		System.out.println();
		System.out.println("2. Date 의 get..()을 사용한 출력");
		// Date객체의 대부분의 메소드들은 현재 deprecated 됨.
		int year = now.getYear() + 1900;  // 연도는 1900 이후 상대적인 경과 년도 	
		int month = now.getMonth() + 1;  // 0 이 1월 ~ 11이 (12월)
		int day = now.getDay();
		int hour = now.getHours();
		int minute = now.getMinutes();
		int second = now.getSeconds();
		System.out.println(year + "년 " + month + "월 " + day + "일 " + hour + "시 " + minute + "분 " + second + "초");		
		
		System.out.println();
		System.out.println("3. SimpleDateFormat 사용한 출력");
		SimpleDateFormat fmt = 
				new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = fmt.format(now);
		System.out.println(strNow2);
		
		// yyyy-MM-dd hh:mm:ss 형식 출력
		// 포맷에 사용되는 문자열 종류 : 자바의 정석 교재 p544
		// H: 시간 (0~23),  h : 시간 (1~12)
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		// ※ 현재 Date() 객체는 생성자를 제외하고는 거의다 deprecated 되어 있다.
		
		
		System.out.println();
		System.out.println("현재 ms → Date → 문자열");
		long baseTime = System.currentTimeMillis();   // 1970-01-01 00:00:00 UTC 기준으로 경과된 ms. long 타입 리턴
		long curTime = baseTime + 2000;
		
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "YYYY:MM:dd-HH:mm:ss", Locale.KOREA );
		String mTime = mSimpleDateFormat.format ( new Date (baseTime) );
		String mTime2 = mSimpleDateFormat.format ( new Date (curTime - baseTime) );
		System.out.println ( mTime );
		System.out.println ( mTime2 );
		
		System.out.println(baseTime);
		System.out.println(curTime - baseTime);
		
		
		// 문자열을 Date 타입으로 파싱하기
		System.out.println();
		System.out.println("문자열 -> Date");
		String oldstring = "2018-08-16 14:21:52.3";
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.KOREA).parse(oldstring);
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 경과시간 체크하기
		System.out.println();
		System.out.println("경과시간");
		long start = System.currentTimeMillis();   // millisec  10E-3초
		for(int i = 0; i < 5; i ++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println(timeElapsed + " 경과");
		
		start = System.nanoTime();  // nanosec 10E-9초
		// ...
		finish = System.nanoTime();
		timeElapsed = finish - start;
		
		
		System.out.println();
		System.out.println("millisec -> time");
		long durationInMillis = 1000000;
		long millis = durationInMillis % 1000;
		long sec = (durationInMillis / 1000) % 60;
		long min = (durationInMillis / (1000 * 60)) % 60;
		long hr = (durationInMillis / (1000 * 60 * 60)) % 24;

		String time = String.format("%02d:%02d:%02d.%3d", hr, min, sec, millis);
		System.out.println(time);
		
		
		// 날짜 비교 compareTo()
		
	} // end main()

} // end class
