package phonebook05.map_file;

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
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;


// Controller부분을 담당할 클래스
public class PhonebookManager implements DbQuery, Closeable {

	// 저장할 파일에 대한 변수
	private static final String PB_DATA_DIR = "data";
	private static final String PB_DATA_FILE = "phonebook.dat2";
	private File pbDir;
	private File pbFile;

	// 멤버 변수
//	private LinkedList<PhonebookModel> pbList = new LinkedList<PhonebookModel>();
	private HashMap<Integer, PhonebookModel> pbMap = new HashMap<Integer, PhonebookModel>();
	
	private static int count = 0;
	
	// singleton 디자인 패턴 적용
	private static PhonebookManager instance = null;
	private PhonebookManager() {
		// 프로그램 시작시
		// - 폰북이 저장될 디렉토리가 없으면 새로 생성, 데이터 파일 없으면 생성
		// - 데이터 파일 있으면 읽어 들어와서 데이터 파일 저장 -> List
		// - 프로그램 종료시 List -> 데이터 파일 저장
		// - 필요한 메소드 등이 필요하면 추가로 작성하세요. 단 private 로!
		
		initFile();
		
		// count 값 업데이트
		if(pbMap.size() > 0) {
			count = new TreeSet<Integer>(pbMap.keySet()).descendingIterator().next();
			System.out.println("읽어들인 최대 count 값은 : " + count);
		}
		
		// 다음과 같이도 할수 있다.
//		if(pbMap != null && pbMap.size() > 0) {
//			count = Collections.max(pbMap.keySet()); // 새 전화번호부에 발급할 id 준비
//		}
		
	} // private 생성자
	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()
	
	
	private void initFile() {
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
			try {
				pbFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("데이터 파일 새로 생성");
		} else {
			System.out.println("파일 존재: " + pbFile.getAbsolutePath());
			// 기존에 저장된 파일이 있는 경우
			// 파일에 있는 내용을 읽어옴
			getDataFromFile();
		}
	} // end initFile()

	private void getDataFromFile() {
		
		try (InputStream in = new FileInputStream(pbFile);
				ObjectInputStream oin = new ObjectInputStream(in)) {
			
			//pbList = (LinkedList<PhonebookModel>) oin.readObject();
			pbMap = (HashMap<Integer, PhonebookModel>)oin.readObject();
			
			
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
			
			oout.writeObject(pbMap);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	} // end saveToFile()
	
	// 전화번호부 등록
	@Override
	public int insert(String name, String phoneNum, String email) {

		if(name == null || name.trim().length() == 0)
			throw new PhonebookException("insert() 이름입력 오류: ", DbQuery.ERR_EMPTY_STRING);
				
		int result = 0;
		
		PhonebookModel pb = new PhonebookModel(name, phoneNum, email);
		count++;
		pb.setId(count);
		pb.setRegDate();          // regDate 는 현재날짜로
		
		pbMap.put(count, pb);  // ★
		result = 1;
		
		return result;
	} // end insert()

	// 전화번호부 열람
	@Override
	public Object searchAll() {
		// HashMap -> 변환 -> TreeMap(키정렬) -> TreeMap의 value -> array		
		//return pbMap.values().toArray();
		return new TreeMap<Integer, PhonebookModel>(pbMap).values().toArray(new PhonebookModel[pbMap.size()]);
	} // end searchAll()

	// 전화번호부 갱신
	@Override
	public int update(int id, String name, String phoneNum, String email) {	
		
		if(!isValidId(id))
			throw new PhonebookException("update() 아이디오류: "  + id, DbQuery.ERR_INVALID_ID);

		if(name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: ", DbQuery.ERR_EMPTY_STRING);
		
		int result = 0;
		
		PhonebookModel pb = pbMap.get(id);
		pb.setName(name);
		pb.setPhoneNum(phoneNum);
		pb.setEmail(email);
		result = 1;
		
		return result;
		
	} // end update()
	
	// 전화번호부 삭제
	@Override
	public int delete(int id) {

		// id 유효한지 체크
		if(!isValidId(id))
			throw new PhonebookException("delete() 아이디오류: "  + id, DbQuery.ERR_INVALID_ID);

		int result = 0;
		
		// 해당 id 의 index를 찾아서 삭제
		pbMap.remove(id); // ★ Map을 사용하면 초 간단
		
		return result;
	} // end delete()
	

	
	
//	@Override
//	public int getMaxId() {
//		int maxId = 0;  // pbList[0] 부터가 아니라,  0 부터 시작 (어짜피 id 는 1 부터 시작한다)
//		
//		for(int i = 0; i < pbList.size(); i++) {
//			if(maxId < pbList.get(i).getId())
//				maxId = pbList.get(i).getId();
//		}
//		
//		return maxId;
//	} // end getMaxId()
	
	@Override
	public boolean isValidId(int id) {
		// Map을 사용하면 간편해진다
		//pbMap.containsKey(id) 를 사용해도 됨.
		
		if(pbMap.get(id) != null)
			return true;
		else
			return false;
	} // end isValidId()
	
	@Override
	public void close() throws IOException {
		// CONTROLLER 에서 자원 반납할 것들 있으면 여기서 작성

		saveDataToFile();
	}
	
	
	
} // end class PhonebookManger


class PhonebookException extends RuntimeException{
	
	private int errCode = DbQuery.ERR_GENERIC;
	
	public PhonebookException() {
		super("PhoneBook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + DbQuery.ERR_STR[errCode] + 
							" " + super.getMessage();
		return msg;
	}

}












