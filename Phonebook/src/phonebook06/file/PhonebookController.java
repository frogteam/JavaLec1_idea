package phonebook06.file;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Controller부분을 담당할 클래스
public class PhonebookController implements Controller, C, Closeable {

	// 멤버 변수
	private List<PhonebookModel> pbList = new ArrayList<PhonebookModel>();

	// 저장할 파일에 대한 변수
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "phonebook.dat";
	private File pbDir;
	private File pbFile;
	
	// singleton 디자인 패턴 적용
	private static PhonebookController instance = null;
	private PhonebookController() {
		// 프로그램 시작시
		// - 폰북이 저장될 디렉토리가 없으면 새로 생성, 데이터 파일 없으면 생성
		// - 데이터 파일 있으면 읽어 들어와서 데이터 파일 저장 -> List
		// - 프로그램 종료시 List -> 데이터 파일 저장
		// - 필요한 메소드 등이 필요하면 추가로 작성하세요. 단 private 로!
		
		initFile();		
	}
	public static PhonebookController getInstance() {
		if (instance == null) {
			instance = new PhonebookController();
		}
		return instance;
	} // end getInstance()

	private void initFile() {
		// 1. 데이터 저장 폴더 생성 (없었다면!)
		pbDir = new File(DATA_DIR);
		if (!pbDir.exists()) {
			// 저장될 디렉토리가 없으면 새로 생성
			if (pbDir.mkdir()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
			
		} else {
			System.out.println("폴더 존재: " + pbDir.getAbsolutePath());
		}
		
		// 2. 데이터 저장 파일 생성 (없었다면)
		pbFile = new File(pbDir, DATA_FILE);
		if (!pbFile.exists()) {
			System.out.println("데이터 파일 새로 생성");
		} else {
			System.out.println("데이터 파일 존재: " + pbFile.getAbsolutePath());
			// 기존에 저장된 파일이 있는 경우
			// 파일에 있는 내용을 메모리(ArrayList)로 올림
			getDataFromFile();			
		}
	} // end initFile()	
	
	private void getDataFromFile() {
		
		try (InputStream in = new FileInputStream(pbFile);
				ObjectInputStream oin = new ObjectInputStream(in)) {
			
			pbList = (ArrayList<PhonebookModel>) oin.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	} // end getDataFromFile()
	
	private void saveDataToFile() {
		try (OutputStream out = new FileOutputStream(pbFile);
				ObjectOutputStream oout = new ObjectOutputStream(out);) {
			
			oout.writeObject(pbList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	} // end saveToFile()	
	// 전화번호부 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		int result = ERR_GENERIC; // 리턴할 결과값

		// 매개변수 검증 : 이름, 전화번호 필수
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("insert() 이름입력 오류: ", ERR_EMPTY_STRING);
		if (phoneNum == null || phoneNum.trim().length() == 0)
			throw new PhonebookException("insert() 전화번호입력 오류: ", ERR_EMPTY_STRING);

		PhonebookModel pb = new PhonebookModel(
				getMaxUid() + 1, // 기존 최대 uid 값보다 1 증가한 값으로 (unique 한 값 보장)
				name, phoneNum, memo,
				LocalDateTime.now()  // 현재 날짜
				);
		
		pbList.add(pb);  // List<> 에 추가
		
		result = 1;

		return result;
	} // end insert()

	// 전화번호부 열람
	@Override
	public List<PhonebookModel> selectAll() {
		return pbList;
	} // end selectAll()

	// 전화번호부 갱신
	@Override
	public int update(int uid, String name, String phoneNum, String memo) {
		int result = ERR_GENERIC; // 리턴할 결과값

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, ERR_INVALID_UID);
		
		// 매개변수 검증 : 이름, 전화번호 필수
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: ", ERR_EMPTY_STRING);
		if (phoneNum == null || phoneNum.trim().length() == 0)
			throw new PhonebookException("update() 전화번호입력 오류: ", ERR_EMPTY_STRING);

		int index = findIndexByUid(uid);   // uid 값을 가진 데이터의 인덱스 찾기
		if(index < 0)
			throw new PhonebookException("update() 존재하지 않는 uid : " + uid, ERR_INVALID_UID);

		PhonebookModel pb = pbList.get(index);
		pb.setName(name);
		pb.setPhoneNum(phoneNum);
		pb.setMemo(memo);
		result = 1;

		return result;
	} // end update()

	// 전화번호부 삭제
	@Override
	public int delete(int uid) {
		int result = ERR_GENERIC; // 리턴할 결과값
		
		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, ERR_INVALID_UID);

		int index = findIndexByUid(uid);  // uid 값을 가진 데이터의 배열 인덱스 찾기
		if(index < 0)
			throw new PhonebookException("update() 존재하지 않는 uid : " + uid, ERR_INVALID_UID);

		pbList.remove(index); // List<> 에서 삭제
		
		result = 1;
		
		return result;
	} // end delete()

	// 특정 uid 의 전화번호부 데이터 검색
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		int index = findIndexByUid(uid);
		if(0 <= index) return pbList.get(index); // uid 값 발견하면 리턴
		
		throw new PhonebookException("존재하지 않는 uid : " + uid, ERR_INVALID_UID);
	} // end selectByUid()

	@Override
	public void close() throws IOException {
		// Controller 종료시 수행할 작업들
		saveDataToFile();  // 데이터 파일 저장
	}

	// ※ 컨트롤러에서만 사용하는 메소드는 private 으로 만들자
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		if(pbList.size() == 0) return 0;  // 아무것도 없으면 0
		
		// List<> 의 경우 항상 가장 마지막 요소의 Uid 값이 최대.
		return pbList.get(pbList.size() - 1).getUid();
	} // end getMaxUid()

	// List 경우, 특정 uid 를 가진 데이터의 배열 index 값을 알아야 한다
	private int findIndexByUid(int uid) {
		
		for (int index = 0; index < pbList.size(); index++) {
			if (pbList.get(index).getUid() == uid) {
				return index;
			}
		} // end for
		
		return -1;  // 못찾으면 -1 
	} // findIndexByUid()

} // end Controller 


