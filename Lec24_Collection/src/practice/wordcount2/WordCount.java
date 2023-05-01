package practice.wordcount2;
/*
 	단어의 개수 세기
 	★HashMap 사용★
 	
 	word_count(String inputFile, String outputFile)
	 	입력파일 (텍스트, UTF-8)
	 	출력파일 : 다음과 같은 entry 로 저장되면 됨.
	 		ex) Alice: 221
	 		
	 대소문자 별도로 카운트 해도 됨.(Alice 나 alice 나 다른 단어로 카운트)
	 
	 파일에서 한 라인씩 읽어서 "\\s+" 로 split 하면 됨
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

// http://jeong-pro.tistory.com/69
// https://www.mkyong.com/java/how-to-read-utf-8-encoded-data-from-a-file-java/

public class WordCount {

	public static void main(String[] args) {
		WordCount wc = new WordCount();
		wc.word_count("./data/alice30.txt", "./data/out.txt");
	} // end main()

	public void word_count(String inputPath, String outputPath) {

		File fileInput, fileOutput;
		BufferedReader in = null; 
		BufferedWriter out = null;
		String strLine;
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
		try {
			fileInput = new File(inputPath);
			in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileInput), "UTF8"));

			while ((strLine = in.readLine()) != null) {
				
				String [] words = strLine.split("\\s+");   // 공백을 제거하고 단어를 구분해냄
				
				//System.out.println(strLine);
				
				for(String word : words) {
					//System.out.println(word);
					if(word.trim().length() > 0) {						
						Integer e = hmap.get(word);
						
						if(e == null)
							hmap.put(word, 1);
						else
							hmap.put(word, e + 1);
					}
				}
				
			} // end while
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // end try
		} // end try
		

		
		// 결과를 파일로 저장
		try {
			fileOutput = new File(outputPath);
			out = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(fileOutput), "UTF8"));

			// 결과 화면에 출력해보기
			for(Map.Entry m : hmap.entrySet()) {
				//System.out.println(m.getKey() + ":" + m.getValue() + "개");
				out.write(m.getKey() + ":" + m.getValue() + "\n");
			}// end for	
			
			System.out.println("파일작성 완료");
				
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // end try
		} // end try
		
	} // end word_count()
} // end class
