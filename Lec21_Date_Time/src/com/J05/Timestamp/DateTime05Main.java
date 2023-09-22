package com.J05.Timestamp;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/*
 * java.sql.Timestamp;
 * 1970.01.01 00:00:00  GMT 기준 의 경과 시간을 ms (정수)로 계산해 담은 객체
 */

/**
 * 시간, 날짜 객체 다룰때
 *
 *         java.time.*
 *        ↙↗      ↘↖
 *   Timestamp  ↔  String
 *
 *   위 데이터간 변환 작업은 빈번히 발생한다.
 *   관련 변환 메소드들을 잘 활용하세요
 */

public class DateTime05Main {

	public static void main(String[] args) {
		System.out.println("java.sql.Timestamp");
		Timestamp t;
		
		
		System.out.println("Timestamp(0)");
		t = new Timestamp(0L);
		System.out.println(t);  //1970.01.01 00:00:00  GMT 기준 --> 한국 KST 1970-01-01 09:00:00.0
		System.out.println();
		
		System.out.println("Timestamp(현재ms)");
		System.out.println(System.currentTimeMillis());    // 현재 timestamp ms 값
		t = new Timestamp(System.currentTimeMillis());
		System.out.println(t);
		System.out.println();
		
		//----------------------------------------------
		// 문자열 -> Timestamp
		// 	방법1 : 정해진 형식 + Timestamp.valueOf()
		System.out.println("String -> Timestamp");
		String now = "2009-03-20 10:20:30.0"; // 형식을 지켜야 함
		System.out.printf("Timestamp(%s)\n", now);
		t = Timestamp.valueOf(now);
		System.out.println(t);
		System.out.println();
		
		// 	방법2 : String -> Date -> Timestamp 
	    Date parsedDate;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			parsedDate = dateFormat.parse(now);
			t = new Timestamp(parsedDate.getTime());
			System.out.println(t);
			System.out.println();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//----------------------------------------------
		// Timestamp -> 문자열
		// SimpleDateFormat + Timestamp:getTime()
		System.out.println("Timestamp -> String");
		String str = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(t.getTime());
		System.out.println(str);

		// Timestamp -> LocalDateTime
		LocalDateTime datetime = t.toLocalDateTime();
		System.out.println(datetime);

		// LocalDateTime -> Timestamp
		t = Timestamp.valueOf(datetime);
		System.out.println(t);
		
	}

}
