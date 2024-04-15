package com.J16.생성_삭제_이동;

import java.io.File;
import java.io.IOException;

public class File16Main {

	public static final String TEST_DIRECTORY = "test";
	public static final String TEMP_DIR = "temp";
	public static final String TEST_FILE = "dummy.txt";
	public static final String TEST_RENAME = "re_dummy.txt";
	
	public static void main(String[] args) {
		System.out.println("폴더/파일 생성, 이름변경, 삭제");
		
		System.out.println();
		
		String path = System.getProperty("user.dir") // working dir
				+ File.separator // Windows(\), UNIX ( / )
				+ TEST_DIRECTORY;
		System.out.println("절대경로: " + path);
		
		// 경로를 사용해서 File 인스턴스 생성
		// -> 물리적인 파일/디렉토리가 만들어 진 것은 아니다.
		File f = new File(path);
		
		System.out.println();
		// 폴더 생성: mkdir()
		if (!f.exists()) { // 폴더가 존재하는 지 체크
			// 폴더가 없다면
			if (f.mkdir()) {
				System.out.println("폴더 생성 성공!");
			} else {
				System.out.println("폴더 생성 실패!");
			}
			
		} else {
			System.out.println("폴더가 이미 존재합니다.");
		}
				
		// ★ 혹시 이전에 test/dummy.txt 와 test/re_dummy.txt 가 있으면 삭제 하고 실행해보자
		
		System.out.println();
		// 파일 생성 : createNewFile()
		File f2 = new File(f, TEST_FILE);   // File(디렉토리 File 객체, 파일명)
		// 명심: new File() 했다고 물리적인 파일이 생긴건 아닙니다!!
		System.out.println(f2.getAbsolutePath());
		
		if (!f2.exists()) { // 파일이 존재하는 지 체크
			// 파일이 존재하지 않으면 생성
			try {
				if (f2.createNewFile()) {  // 물리적으로 생성
					System.out.println("파일 생성 성공!");
				} else {
					System.out.println("파일 생성 실패!");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			// 파일이 존재한다면
			System.out.println("파일이 이미 존재합니다.");
		}
		
		System.out.println();
		// 파일 이름 변경: renameTo()
		// renameTo()를 이용해서 다른 폴더로 이동(move)를 할 수도 있다.
		// File temp = new File(TEMP_DIR);
		
		File f3 = new File(f, TEST_RENAME); // 변경될 이름
		// 명심: File객체를 생성했다고 해서, 물리적으로 뭔가 한건 절대로 아닙니다.
		System.out.println(f3.getAbsolutePath());

		// f2(dummy.txt) => f3(re_dummy.txt)
		if (f2.exists()) { // 파일이 존재하는 지 체크
			// 원본 파일이 존재할 때만 이름 변경(renameTo)
			
			if (f2.renameTo(f3)) {
				System.out.println("파일 이름 변경 성공!");
			} else {
				System.out.println("파일 이름 변경 실패!");  // 이미 re_dummy.txt 가 있으면 실패한다
			}
			
		} else {
			System.out.println("변경할 원본 파일이 없습니다.");
		}
		
		
		// ★  temp/aaa.txt 파일을 만들어 놓고 해보자
		
		System.out.println();
		// 파일 삭제: delete()
		File f4 = new File(f, TEST_RENAME);
		if (f4.exists()) {
			// 파일이 존재하면 지움
			if (f4.delete()) {
				System.out.println("파일 삭제 성공!");
			} else {
				System.out.println("파일 삭제 실패!");
			}
			
		} else {
			System.out.println("삭제할 파일이 없습니다.");
		}

		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














