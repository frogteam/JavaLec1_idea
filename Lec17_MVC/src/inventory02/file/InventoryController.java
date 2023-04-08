package inventory02.file;

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

public class InventoryController implements Controller, InventoryConstants, Closeable {
	// 아직 실제 DB는 없으므로 DB 역할을 해줄 List를 작성, 다른 곳에서 함부로 접근하면 안되므로 private
	private List<InventoryModel> db = new ArrayList<InventoryModel>();
	
	// 저장할 파일, 디렉토리에 대한 변수
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "inventory.dat";
	private File pbDir;
	private File pbFile;

	// Controller 객체는 클라이언트로 받는 요청들을 통제해야 하므로 하나만 만듬
	private static InventoryController controller = null;

	private InventoryController() {
		initFile();
	}

	public static InventoryController getInstance() {
		if (controller == null) {
			controller = new InventoryController();
		}
		return controller;
	}

	private void initFile() {
		// 데이터 저장 폴더 생성 (없었다면!)
		pbDir = new File(DATA_DIR);
		if(!pbDir.exists()) {
			if(pbDir.mkdir()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
		} else {
			System.out.println("폴더 존재: " + pbDir.getAbsolutePath());
		}
		
		// 데이터 저장 파일 생성 (없었다면)
		pbFile = new File(pbDir, DATA_FILE);
		if(!pbFile.exists()) {
			System.out.println("데이터 파일 새로 생성");
		} else {			
			System.out.println("데이터 파일 존재 : " + pbFile.getAbsolutePath());
			// 기존에 저장된 파일 데이터 읽어오기
			getDataFromFile();
		}		
	}
	
	private void getDataFromFile() {
		try(
				InputStream in = new FileInputStream(pbFile);
				ObjectInputStream oin = new ObjectInputStream(in);
				){
			db = (List<InventoryModel>)oin.readObject();  // 파일 -> List 읽어오기
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void saveDataToFile() {
		try(
				OutputStream out = new FileOutputStream(pbFile);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				){
			oout.writeObject(db);  // List -> 파일 저장
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// db에 클라이언트로 부터 입력받은 정보를 저장한다.
	@Override
	public int insert(String itemName, String price, String count) {
		// TODO Auto-generated method stub

		int ret = -1; // 비정상 결과
		String numRegx = "\\d+";
		int priceInt;
		int countInt;
		// 매개변수 검증: 이름 필수, 가격 필수, 개수 기본 0
		if (itemName == null || itemName.trim().length() == 0) {
			throw new InventoryException("insert() 이름이 입력되지 않았습니다 :", ERR_EMPTY_STRING);
		}

		if (!price.matches(numRegx)) {
			throw new InventoryException("insert() 가격에 정상적인 입력이 되지 않았습니다.: ", ERR_INVALID_PRICE);
		} else {
			priceInt = Integer.valueOf(price);   // Integer.parseInt();
		}

		if (!count.matches(numRegx)) {
			countInt = 0;
		} else {
			countInt = Integer.valueOf(count);
		}

		InventoryModel item = new InventoryModel();

		item.setId(getLastid() + 1);
		item.setItemName(itemName);
		item.setPrice(priceInt);
		item.setCount(countInt);
		item.setTime(LocalDateTime.now());

		db.add(item);
		ret = 1;

		return ret;
	}

	@Override
	public List<InventoryModel> selectAll() {
		// TODO Auto-generated method stub
		return db; 
	}
	
	//db id로 행선택후 삭제
	@Override
	public int delete(int id) {
		int ret = ERR_GENERIC;

		if (id < 1)
			throw new InventoryException("update() uid 오류", ERR_INVALID_UID);
		
		int index = getIndexOfid(id);

		if (index < 0) {
			throw new InventoryException("update() 존재하지 않는 uid : ", ERR_INVALID_UID);
		}
		db.remove(index);
		ret = 1;
		return ret;
	}

	@Override
	public InventoryModel selectOneById(int id) {

		InventoryModel m = null;
		for (int i = 0; i < db.size(); i++) {
			m = db.get(i);
			if (m.getId() == id) {
				return m;
			}
		}
		throw new InventoryException("selectOneById(int) 존재하지 않는 uid: " + id, ERR_INVALID_UID);
	}

	@Override
	public int update(int id, String itemName, String price, String count) {
		int ret = ERR_GENERIC; // 비정상 결과
		String numRegx = "\\d+";
		int priceInt;
		int countInt;
		int index;
		InventoryModel item;

		if (itemName == null || itemName.trim().length() == 0) {
			throw new InventoryException("insert() 이름이 입력되지 않았습니다 :", ERR_EMPTY_STRING);
		}

		if (!price.matches(numRegx)) {
			throw new InventoryException("insert() 가격에 정상적인 입력이 되지 않았습니다.: ", ERR_INVALID_PRICE);
		} else {
			priceInt = Integer.valueOf(price);
		}

		if (!count.matches(numRegx)) {
			countInt = 0;
		} else {
			countInt = Integer.valueOf(count);
		}

		if (id < 0)
			throw new InventoryException("update() 존재하지 않는 uid: " + id, ERR_INVALID_UID);

		index = getIndexOfid(id);
		item = selectOneById(id);

		item.setItemName(itemName);
		item.setPrice(priceInt);
		item.setCount(countInt);

		ret = 1;
		return ret;
	}

	// 컨트롤러에서만 사용하는 메소드는 private로 만든다.
	// 현제 데이터 중 가장 큰 uid 값을 찾아서 리턴
	private int getLastid() {
		if (db.size() == 0)
			return 0; // 아무것도 없으면 0
		// List<> 의 경우 항상 가장 마지막 요소의 uid가 최댓값

		return db.get(db.size() - 1).getId();
	}

	private int getIndexOfid(int id) {
		int ret = -1;
		if (id < 0)
			throw new InventoryException("update() 존재하지 않는 uid: " + id, ERR_INVALID_UID);
		
		for (InventoryModel i : db) {
			if (i.getId() == id) {
				ret = db.indexOf(i);
				break;
			}
		}
		return ret;
	}

	@Override
	public void close() throws IOException {
		saveDataToFile();
		
	}
}
