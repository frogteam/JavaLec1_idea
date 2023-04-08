package com.lec.java.pb07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

// Controller부분을 담당할 클래스
public class PhonebookManager implements DbQuery {

	// 멤버 변수
	// 전화번호를 저장할 ArrayList
	private ArrayList<PhonebookModel> pbList =
			new ArrayList<PhonebookModel>();
	
	// 저장할 파일에 대한 변수
	public static final String PB_DATA_DIR = "data";
	public static final String PB_DATA_FILE = "phonebook.dat";
	private File pbDir;
	private File pbFile;
	
	
	// singleton 디자인 패턴 적용
	// 1. 생성자 대신 public static 메소드를 제공해서
	// 인스턴스를 생성 또는 생성되어 있는 인스턴스를 리턴(반환)해 주도록 함
	// 2. 해당 클래스의 인스턴스는 오직 하나만 생성될 수 있다.
	private static PhonebookManager instance = null;
	private PhonebookManager() {
		pbDir = new File(PB_DATA_DIR);
		if (!pbDir.exists()) {
			// 폰북이 저장될 디렉토리가 없으면 새로 생성
			if (pbDir.mkdir()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
			
		} else {
			System.out.println("폴더 존재: " + pbDir.getAbsolutePath());
		}
		
		pbFile = new File(pbDir, PB_DATA_FILE);
		if (!pbFile.exists()) {
			System.out.println("데이터 파일 새로 생성");
		} else {
			System.out.println("파일 존재: " + pbFile.getAbsolutePath());
			// 기존에 저장된 파일이 있는 경우
			// 파일에 있는 내용을 메모리(ArrayList)로 올림
			getDataFromFile();
		}
	} // private 생성자
	
	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		
		return instance;
	} // end getInstance()
	
	private void getDataFromFile() {
		
		try (InputStream in = new FileInputStream(pbFile);
				ObjectInputStream oin = new ObjectInputStream(in)) {
			
			pbList = (ArrayList<PhonebookModel>) oin.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} // end getDataFromFile()
	
	public void saveDataToFile() {
		try (OutputStream out = new FileOutputStream(pbFile);
				ObjectOutputStream oout = new ObjectOutputStream(out);) {
			
			oout.writeObject(pbList);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	} // end saveToFile()
	
	@Override
	public void insert(String name, String phoneNum, String email) {
		System.out.println("insert 호출");
		
		// ArrayList에 데이터 추가: add()
		pbList.add(new PhonebookModel(name, phoneNum, email));
//		PhonebookModel pb = new PhonebookModel(name, phoneNum, email);
//		pbList.add(pb);
		
	} // end insert()

	@Override
	public String searchAll() {
		System.out.println("searchAll 호출");
		
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < pbList.size(); i++) {
			buff.append(pbList.get(i).displayInfo());
		} // end for
		
		return buff.toString();
		
	} // end searchAll()

	@Override
	public String search(int index) {
		System.out.println("search 호출");
		
		String info = null;
		if (index < pbList.size()) {
			PhonebookModel pb = pbList.get(index);
			System.out.println("인덱스: " + index + " / " + pbList.size());
			info = pb.displayInfo();
		} else {
			info = "해당 인덱스의 데이터 없음!";
		}
		
		return info;
		
	} // end search()
	
	@Override
	public String update(int index, String name, String phoneNum, String email) {
		System.out.println("update 호출");
		
		String info = null;
		if (index < pbList.size()) {
			pbList.get(index).setName(name);
			pbList.get(index).setPhoneNum(phoneNum);
			pbList.get(index).setEmail(email);
			
			info = pbList.get(index).displayInfo();

		} else {
			info = "수정할 데이터가 없습니다.";
		}
		
		return info;
	} // end update()

	@Override
	public void delete(int index) {
		System.out.println("delete 호출");
		
		if (index < pbList.size()) {
			pbList.remove(index);
			
		} else {
			System.out.println("삭제할 데이터가 없습니다!");
		} // end else
		
	} // end delete()
	
} // end class PhonebookManger














