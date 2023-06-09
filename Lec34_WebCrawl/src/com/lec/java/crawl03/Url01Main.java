package com.lec.java.crawl03;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/* URL (Uniform Resource Locator) 객체
 *  java.net.URL 객체를 통해  인터넷 관련 리소스 접근.
 *  
 *  URL 객체의 메소드를 통해  URL을 분해해볼수 있다. 
 *  
 *  가령 : https://aaa.bbb.com:88/abc/def/zzz.ddd?name=uu&age=12 의 경우
 * 	getProtocol(): https
 *	getHost(): aaa.bbb.com
 *	getPath(): /abc/def/zzz.ddd
 *	getPort(): 88
 *	getFile(): /abc/def/zzz.ddd?name=uu&age=12
 *	getQuery(): name=uu&age=12
 *
 *  단, 파일 이름의 경우 따로 추출해야 하는 번거로움 있다.
 *  
 *  URI (Uniform Resource Identifier) 는 URL 의 상위 개념
 */
public class Url01Main {

	public static void main(String[] args) {
		System.out.println("URL 객체");

		String[] urls = new String[] { 
				"https://aaa.bbb.com:88/abc/def/zzz.ddd?name=uu&age=12",
				"http://www.example.com/some/path/to/a/file.xml?foo=bar#test",
				"hhh://asdf",
				"ftp://asdf",
		};

		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i]);
			URL url = null;
			try {
				url = new URL(urls[i]);
			} catch (MalformedURLException e) {
				System.out.println("\t잘못된 url 입니다 " + e.getMessage());
			}
			if(url != null) {
				System.out.println("\tgetProtocol(): " + url.getProtocol());
				System.out.println("\tgetHost(): " + url.getHost());
				System.out.println("\tgetPath(): " + url.getPath());
				System.out.println("\tgetPort(): " + url.getPort());
				System.out.println("\tgetFile(): " + url.getFile());
				System.out.println("\tgetQuery(): " + url.getQuery());
				
				// 파일명, 확장자		
				if(url.getPath().length() > 0) {					
					String filename = url.getPath().substring(url.getPath().lastIndexOf('/') + 1);
					String fileBaseName = filename.substring(0, filename.lastIndexOf('.'));
					String fileExt = filename.substring(filename.lastIndexOf('.') + 1);
					
					System.out.println("\t파일명: " + filename);
					System.out.println("\t파일base명: " + fileBaseName);
					System.out.println("\t파일확장자: " + fileExt);
				}
			}
		} // end for

		System.out.println("프로그램 종료");
	} // end main()

} // end class


// 참조 : https://stackoverflow.com/questions/605696/get-file-name-from-url
// Commons IO 라이브러리 사용 : http://commons.apache.org/proper/commons-io/
//System.out.println(FilenameUtils.getBaseName(url.getPath())); // -> file
//System.out.println(FilenameUtils.getExtension(url.getPath())); // -> xml
//System.out.println(FilenameUtils.getName(url.getPath())); // -> file.xml


