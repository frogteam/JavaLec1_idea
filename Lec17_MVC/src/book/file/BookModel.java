package book.file;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class BookModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2440058195771035190L;
	
	// 멤버변수
	private int uid;     // 고유 uid 값 ( 1 ~ ) 중복허용X
	private String name;     // 이름
	private Integer price; // 가격
	private String memo;    // 메모
	private LocalDateTime regDate;	 // 등록일
	
	public BookModel() {
		super();
	}

	public BookModel(int uid, String name, Integer price, String memo, LocalDateTime regDate) {
		super();
		this.uid = uid;
		this.name = name;
		this.price = price;
		this.memo = memo;
		this.regDate = regDate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return String.format("%d] %s : %s : %s : %s",
				uid, name, price, memo, 
				regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
	}
} // end Model
