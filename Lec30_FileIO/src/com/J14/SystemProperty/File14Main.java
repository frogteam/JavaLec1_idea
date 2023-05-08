package com.J14.SystemProperty;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class File14Main {

	public static void main(String[] args) {
		System.out.println("시스템 정보 확인");
		
		System.out.println();
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println(System.getProperty("os.version"));
		
		System.out.println();
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("java.version"));
		
		System.out.println();
		// current working directory
		System.out.println(System.getProperty("user.dir"));
		
		// user home directory("내 문서"가 있는 폴더)
		System.out.println(System.getProperty("user.home"));
		
		System.out.println();
		System.out.println(System.getProperty("file.separator"));
		
		// OS 기본 인코딩 값!  중요!
        System.out.println("Default Charset=" + Charset.defaultCharset());
        //System.setProperty("file.encoding", "Latin-1");  // 효과없단다...
        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println("Default Charset in Use=" + getDefaultCharSet());

        
        System.out.println("\n프로그램 종료");
        
	} // end main()
	
	// 출처:
	// https://stackoverflow.com/questions/1749064/how-to-find-the-default-charset-encoding-in-java
    private static String getDefaultCharSet() {
        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        String enc = writer.getEncoding();
        return enc;
    }

} // end class














