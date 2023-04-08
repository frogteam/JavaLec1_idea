// Import any package as required
package ds.proj3.huffman;

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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

// 윈도우 환경에서 두 파일의 비교명령은 로 FC (File Compare) 로 하면 된다
// >FC [pathname1] [pathname2]

// http://lti.cs.vt.edu/LTI_ruby/Books/CS172/html/Huffman.html

public class HuffmanSubmit implements Huffman {

	// Feel free to add more methods and variables as required.
	// 메소드나 변수등은 추가해도 좋음.

	public void encode(String inputFile, String outputFile, String freqFile) {

		BinaryIn  in  = new BinaryIn(inputFile);
        BinaryOut out = new BinaryOut(outputFile);
        ArrayList<Byte> inContents = new ArrayList<Byte>();

		/* 
		// TEST : 정상적으로 파일 읽어 들이고 출력까지 되는지 확인해봅시다
		// 윈도우의 경우 확인은 커맨드에서 >fc ur.jpg ur.enc   
        // read one 8-bit char at a time
        while (!in.isEmpty()) {
            boolean b = in.readBoolean();
            out.write(b);
        }        
        */
		
        /* TEST
        // 1byte 씩 읽어서 출력해보기
		// 최종적으로 ur.jpg 파일의 경우 14068 bytes 가 출력되는지 보자

        byte b;
        int readCount = 0;
        try {        	
        	while(true) {
	        	b = (byte)in.readChar();  // 이런 casting 가능
	        	System.out.println(b);
	        	readCount++;
        	}
        }catch(NoSuchElementException e) {
        	
        }
        System.out.println("TOTAL:" + readCount + " bytes");
        */

        
        // 1. 발생 빈도수 체크★★
        // HashMap 사용
        // 바이트별?  (과제에 주어진 파일이 텍스트파일, 바이너리 파일이다.  게다가 텍스트 파일도  uft-8 인코딩
        HashMap<Byte, Integer> hmap = new HashMap<Byte, Integer>();
        try {        	
        	while(true) {
	        	Byte b = (byte)in.readChar();  // 1byte씩 읽어온다. 이런 casting 가능
	        	
	        	inContents.add(b);   // 일단 내용을 담아놔야, 나중에 저장 가능.
	        	
	        	Integer e = hmap.get(b);
	        	
	        	if(e == null)
	        		hmap.put(b, 1);
	        	else
	        		hmap.put(b, e + 1);
        	}
        }catch(NoSuchElementException e) {
        	
        }
        
		// 빈도수 테스트: 결과 출력
        // 최종적으로 ur.jpg 파일의 경우 14068 bytes 가 출력되는지 보자
//        int count = 0;
//		for(Map.Entry m : hmap.entrySet()) {
//			System.out.println(m.getKey() + " : " + m.getValue() + "개");
//			count += (Integer)m.getValue();
//		}
//		System.out.println("TOTAL:" + count + " bytes");
        
        
        // 2. Sorting 하기 ★★
        // freq 오른차순 으로 sorting 하기
        // PriorityQueue 사용
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(hmap.size(), new Asc());
		for(Map.Entry m : hmap.entrySet()) {
			pq.offer(new HuffmanNode((Byte)m.getKey(), (Integer)m.getValue()));
		}
		
		// TEST: 빈도수 오름차순 순서대로 되었는지 확인해보자 
//		HuffmanNode node;
//		while( (node = pq.poll()) != null) {
//			System.out.println("freq:" + node.getFreq() + " data:" + node.getData());
//		}
		
		
		// 3 freq 결과 파일 만들기 ★★
		// 
		File freqfileOutput;
		BufferedWriter freqOut = null;
		String strLine;
		
		// 결과를 파일로 저장
		try {
			freqfileOutput = new File(freqFile);
			freqOut = new BufferedWriter(
						new OutputStreamWriter(
							new FileOutputStream(freqfileOutput), "UTF8"));

			for(Map.Entry m : hmap.entrySet()) {
				// 이진 문자열 포맷으로 저장
				String binString = String.format("%8s", Integer.toBinaryString((Byte)m.getKey() & 0xFF)).replace(' ', '0');
				freqOut.write(binString + ":" + m.getValue() + "\n");
			}// end for				
			System.out.println("freq 파일작성 완료");
				
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (freqOut != null)
					freqOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // end try
		} // end try
		
		
		
		// 4. Huffman Tree 만들기 ★★
		// PriorityQueue 동작 활용
		// merge 는 총 pg.size() - 1 번 발생
//		System.out.println("BEFORE size: " + pq.size());		
		while(pq.size() > 1) {
			// 첫 2개 추출 
			HuffmanNode node1 = pq.poll();
			HuffmanNode node2 = pq.poll();
			HuffmanNode mergedNode = new HuffmanNode(node1.getFreq() + node2.getFreq());
			mergedNode.setLeft(node1).setRight(node2);
			pq.offer(mergedNode);	
//			System.out.println(i + "] pq size: " + pq.size());
		}
		
		// TEST: 
		// 정상적으로 Huffman Tree 가 만들어졌다면.
		// pq.size() 는 1 이어야 하고
		// pq.peek() 한 값의 frequeucy 값은 총 발생수
		// 최종적으로 ur.jpg 파일의 경우 14068  가 출력되는지 보자
//		System.out.println(pq.size());
//		System.out.println(pq.peek().getFreq());
		

		// TEST
		// HuffmanCode 를 문자열로 출력해보기
		// 최종적으로 ur.jpg 파일의 경우 256 줄이 나와야 한다
//		HuffmanNode.printCode(pq.peek(), "");
		
		
		
		// 5. Assigning Huffman Code
		// HashMap<Byte, String> 사용
		HashMap<Byte, String> hmHuffman = new HashMap<Byte, String>();
		HuffmanNode.getHuffman(hmHuffman, pq.peek(), "");
		
		// TEST
		// 최종적으로 ur.jpg 파일의 경우 size() 값이 256 이 나와야 한다
		//System.out.println("총:" + hmHuffman.size() + "개");
		
		
		
		// 6. build outputFile
		//System.out.println(inContents.size() + " bytes");
		for(Byte b : inContents) {
			//System.out.println(b + ":" + hmHuffman.get(b.byteValue()));
			String huffmanCode = hmHuffman.get(b.byteValue());
			
			for (char ch : huffmanCode.toCharArray()){
				if(ch == '0') {
					out.write(false);
				}else if(ch == '1') {
					out.write(true);
				}else {
					System.out.println("Invalid Huffman Code : " + ch + " from Code :" + b );
				}
			} // end for
		} // end for
        
        out.flush();
        System.out.println("encode() 완료");
	} // end encode()

	public void decode(String inputFile, String outputFile, String freqFile) {
		// 1 
		// freq 파일 읽기
		// PriorityQueue 구축
		File freqFileInput;
		BufferedReader freqIn = null;
		String strLine;
		
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<HuffmanNode>(10, new Asc());
		
		try {
			freqFileInput = new File(freqFile);
			freqIn = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(freqFileInput), "UTF8"));

			while((strLine = freqIn.readLine()) != null) {
				// 각 line 은 ":" 으론 구분
				String [] lines = strLine.split(":");
				
				// binary string --> Byte
				//Byte data = Byte.parseByte(lines[0], 2);   // NumberFormat Exception 발생.. 7bit '1111111' 밖에 안됨.
				Byte data = (byte)Short.parseShort(lines[0], 2);
				Integer freq = Integer.parseInt(lines[1]);
				
				//System.out.println(data + " : " + freq);  // 테스트
				
				pq.offer(new HuffmanNode(data, freq));
				
			} // end while
			
			
			// TEST
			// 최종적으로 ur.jpg 파일의 경우 256이 나와야 한다
			// System.out.println(pq.size());
			
				
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (freqIn != null)
					freqIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			} // end try
		} // end try

		// 2
		// huffman tree 생성
		// root node 유지
		// PriorityQueue 동작 활용
		// merge 는 총 pg.size() - 1 번 발생
//		System.out.println("BEFORE size: " + pq.size());		

		while(pq.size() > 1) {
			// 첫 2개 추출 
			HuffmanNode node1 = pq.poll();
			HuffmanNode node2 = pq.poll();
			HuffmanNode mergedNode = new HuffmanNode(node1.getFreq() + node2.getFreq());
			mergedNode.setLeft(node1).setRight(node2);
			pq.offer(mergedNode);	
//			System.out.println(i + "] pq size: " + pq.size());
		}
		HuffmanNode root = pq.peek();   // root node
		
		// TEST: 
		// 정상적으로 Huffman Tree 가 만들어졌다면.
		// pq.size() 는 1 이어야 하고
		// pq.peek() 한 값의 frequeucy 값은 총 발생수
		// 최종적으로 ur.jpg 파일의 경우 14068  가 출력되는지 보자
		//System.out.println(pq.size());
		//System.out.println(pq.peek().getFreq());
		

		// TEST
		// HuffmanCode 를 문자열로 출력해보기
		// 최종적으로 ur.jpg 파일의 경우 256 줄이 나와야 한다
		//HuffmanNode.printCode(pq.peek(), "");

		
		
		
		// 3
		// inputFile 로부터 한비트씩 읽으며 
		// Huffman Tree 에서  데이터(Byte) 추출 (leafNode)
		// ecode data (Byte) 추출하기
		// 추출된 (Byte) 를 outFile 에 저장
		
		BinaryIn  in  = new BinaryIn(inputFile);
        BinaryOut out = new BinaryOut(outputFile);
        ArrayList<Byte> inContents = new ArrayList<Byte>();

        try {
//        	int bitCount = 1; // TEST
        	int byteCount = 1;

        	// Huffman Tree 에서 데이터 
        	HuffmanNode node = root;

        	while(true) {
	        	boolean b = in.readBoolean();  // 1 bit 씩 읽기
	        	
	        	// TEST	 
	        	// ur.enc 의 경우  14018 byte -->  count 값이 112144 가 나와야 한다
//	        	System.out.println(bitCount + ": " + ((b)?"1":"0"));
//	        	bitCount++;
	        	
	        	
	        	
	        	// decode data (Byte) 추출하기
	        	// false 이면 left,  true 이면 right;
	        	node = (b)?node.getRight() : node.getLeft();
	        	if(node.isLeaf()) {
	        		// 파일에 데이터 쓰기
	        		
	        		// TEST
	        		// ur.enc 의 경우  decode 된 byteCount 값이 14068 이 나와야 한다
//	        		System.out.println(byteCount + ": " + node.getData() + " : " + node.getFreq());
//	        		byteCount++;
	        		
	        		out.write(node.getData());
	        		
	        		node = root;   // 다음번에 다시 root 에서 시작. 
	        	}
	        	
        	} // end while
        }catch(NoSuchElementException e) {
        	
        }
		
		out.flush();
		
		System.out.println("decode() 완료");
	} // end decode()

	public static void main(String[] args) {
		Huffman huffman = new HuffmanSubmit();
		huffman.encode("ur.jpg", "ur.enc", "freq.txt");
		huffman.decode("ur.enc", "ur_dec.jpg", "freq.txt");

//		C:\Dropbox\workspace_java\Lec50_DataStructure>fc ur.jpg ur_dec.jpg
//		파일을 비교합니다: ur.jpg - UR_DEC.JPG
//		FC: 다른 점이 없습니다.
		
//		huffman.encode("alice30.txt", "alice30.enc", "freq_alice.txt");
//		huffman.decode("alice30.enc", "alice30_dec.txt", "freq_alice.txt");
		// decode 된 파일과 1byte 차이가 난다.. 왜?
		
		
		// After decoding, both ur.jpg and ur_dec.jpg should be the same.
		// On linux and mac, you can use `diff' command to check if they are the same.
	} // end main()
	
	class Asc implements Comparator<HuffmanNode> {
		@Override
		public int compare(HuffmanNode o1, HuffmanNode o2) {
			if(o1.getFreq() > o2.getFreq()) return 1;
			if(o1.getFreq() < o2.getFreq()) return -1;
			return 0;
		}
	}

} // end class
