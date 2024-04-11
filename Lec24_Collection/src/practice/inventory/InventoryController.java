package practice.inventory;

import java.io.Closeable;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Controller부분을 담당할 클래스
// Controller부분을 담당할 클래스
public class InventoryController implements Controller, C, Closeable {

	// 멤버 변수
	private final List<Inventory> list = new ArrayList<Inventory>();

	// singleton 디자인 패턴 적용
	// 1. 생성자 대신 public static 메소드를 제공해서
	// 인스턴스를 생성 또는 생성되어 있는 인스턴스를 리턴(반환)해 주도록 함
	// 2. 해당 클래스의 인스턴스는 오직 하나만 생성될 수 있다.
	private static InventoryController instance = null;
	private InventoryController() {} // private 생성자
	public static InventoryController getInstance() {
		if (instance == null) {
			instance = new InventoryController();
		}
		return instance;
	} // end getInstance()

	// 등록
	@Override
	public int insert(String name, Integer price, Integer count) {

		int result = ERR_GENERIC; // 리턴할 결과값

		// 매개변수 검증
		if (name == null || name.trim().isEmpty())
			throw new InventoryException("insert() 이름입력 오류: ", ERR_EMPTY_STRING);
		if (price == null)
			throw new InventoryException("insert() 가격에 정상적인 입력이 되지 않았습니다: ", ERR_INVALID_PRICE);

		if(count == null) count = 1;

		Inventory data = new Inventory(
				getMaxId() + 1, // 기존 최대 uid 값보다 1 증가한 값으로 (unique 한 값 보장)
				name, price, count
		);

		list.add(data);  // List<> 에 추가

		result = 1;

		return result;
	} // end insert()

	// 열람
	@Override
	public List<Inventory> selectAll() {
		return list;
	} // end selectAll()

	// 전화번호부 갱신
	@Override
	public int update(Long id, String name, Integer price, Integer count) {
		int result = ERR_GENERIC; // 리턴할 결과값

		// 매개변수 검증
		if (id < 1)
			throw new InventoryException("update() id 오류: " + id, ERR_INVALID_ID);

		// 매개변수 검증 : 이름, 전화번호 필수
		if (name == null || name.trim().isEmpty())
			throw new InventoryException("update() 이름입력 오류: ", ERR_EMPTY_STRING);
		if (price == null)
			throw new InventoryException("update() 가격제 정상적인 입력이 되지 않았습니다: ", C.ERR_INVALID_PRICE);

		int index = findIndexById(id);   // id 값을 가진 데이터의 인덱스 찾기
		if(index < 0)
			throw new InventoryException("update() 존재하지 않는 id : " + id, ERR_INVALID_ID);

		Inventory pb = list.get(index);
		pb.setName(name);
		pb.setPrice(price);
		if(count != null) pb.setCount(count);
		result = 1;

		return result;
	} // end update()

	// 전화번호부 삭제
	@Override
	public int delete(Long id) {
		int result = ERR_GENERIC; // 리턴할 결과값

		// 매개변수 검증
		if (id < 1)
			throw new InventoryException("delete() id 오류: " + id, ERR_INVALID_ID);

		int index = findIndexById(id);  // id 값을 가진 데이터의 배열 인덱스 찾기
		if(index < 0)
			throw new InventoryException("delete() 존재하지 않는 id : " + id, ERR_INVALID_ID);

		list.remove(index); // List<> 에서 삭제

		result = 1;

		return result;
	} // end delete()

	// 특정 id 의 전화번호부 데이터 검색
	@Override
	public Inventory selectById(Long id) {  // 삭제, 수정 등에 사용

		int index = findIndexById(id);
		if(0 <= index) return list.get(index); // uid 값 발견하면 model 리턴

		throw new InventoryException("존재하지 않는 id : " + id, ERR_INVALID_ID);
	} // end selectById()

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

	// ※ 컨트롤러에서만 사용하는 메소드는 private 으로 만들자
	// 현재 데이터중 가장 큰 id 값을 찾아서 리턴
	private Long getMaxId() {
		if(list.isEmpty()) return 0L;  // 아무것도 없으면 0

		// List<> 로 저장되는 경우 가장 마지막 요소의 Uid값이 최대값
		return list.get(list.size() - 1).getId();
	} // end getMaxUid()

	// List 경우, 특정 id 를 가진 데이터의 index 값을 알아야 한다
	private int findIndexById(Long id) {

		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId().equals(id)) {
				return index;
			}
		} // end for

		return -1;  // 못찾으면 -1 
	} // findIndexByUid()

} // end Controller 



