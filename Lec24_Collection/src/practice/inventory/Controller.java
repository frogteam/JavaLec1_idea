package practice.inventory;

import java.util.List;

// View(InventoryMain)와 Controller(InventoryController) 사이의 인터페이스
public interface Controller {
	public abstract int insert(String name, Integer price, Integer count); // 저장한 데이터 개수 리턴
	public abstract List<Inventory> selectAll();
	public abstract Inventory selectById(Long id);
	public abstract int update(Long id, String name, Integer price, Integer count); // 수정된 데이터 개수 리턴
	public abstract int delete(Long id);// 삭제된 데이터 개수 리턴
} // end Controller

// 동작 설계

// 이름(name), 전화번호(phoneNum), 메모(memo) 를 받아서 데이터 저장

// 데이터 전체 목록을 읽어오기

// 특정 uid 의 데이터 한개 읽어오기

// 특정 uid 의 데이터를 주어진 이름(name), 전화번호(phoneNum), 메모(memo) 로 수정하기

// 특정 uid 의 데이터 삭제하기
