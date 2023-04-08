package com.lec.java.properties01;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Properties01Main {
	// Properties 클래스 참조
	//	http://docs.oracle.com/javase/7/docs/api/java/util/Properties.html
	// 	http://www.tutorialspoint.com/java/java_properties_class.htm
	
	public static void main(String[] args) {
	      Properties kblCoach = new Properties();
	      Set kblTeams;
	      String str;
	      
	      // put(key, value) 를 통해 hashtable 에 입력
	      kblCoach.put("삼성 라이온즈", "류중일");
	      kblCoach.put("넥센 히어로즈", "염경엽");
	      kblCoach.put("두산 베어스", "김태형");
	      kblCoach.put("롯데 자이언츠", "이종운");
	      kblCoach.put("기아 타이거즈", "김기태");
	      kblCoach.put("NC 다이노스", "김경문");
	      kblCoach.setProperty("엘지 트윈스", "양상문");  // put() 메소드와 거의 동일한 동작.
	      kblCoach.setProperty("SK 와이번스", "김용희");
	      kblCoach.setProperty("한화 이글스", "김성근");
	      kblCoach.setProperty("KT WIZ", "조범현");
	      System.out.println();

	      // 방법1 : Enhanced-for 를 사용하여 Properties 객체 내용 출력하기
	      System.out.println("Enhanced For 문을 사용하여 Properties 객체 출력");
	      for(Object key : kblCoach.keySet()){
	    	  System.out.println(key + " : " + kblCoach.getProperty((String)key));
	      }
	      System.out.println();

	      // 방법2 : iterator 사용
	      System.out.println("iterator를 사용하여 Properties 객체 출력");
	      kblTeams = kblCoach.keySet(); // get set-view of keys
	      Iterator itr = kblTeams.iterator();
	      while(itr.hasNext()) {
	         str = (String) itr.next();
	         System.out.println(str + " : " + kblCoach.getProperty(str));
	      }
	      System.out.println();

	      
	      // look for state not in list -- specify default
	      str = kblCoach.getProperty("삼미 슈퍼스타스", "Not Found");
	      System.out.println("삼미 슈퍼스타스 는 "
	          + str + ".");	} // end main
} // end class
