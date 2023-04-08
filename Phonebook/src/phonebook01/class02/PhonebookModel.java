package phonebook01.class02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok 사용
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhonebookModel {
	// 멤버변수
	private int uid;     // 고유 uid 값 ( 1 ~ ) 중복허용X
	private String name;     // 이름
	private String phoneNum; // 전화번호
	private String memo;    // 메모
	private LocalDateTime regDate;	 // 등록일

	@Override
	public String toString() {
		return String.format("%d] %s : %s : %s : %s",
				uid, name, phoneNum, memo, 
				regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
	}
} // end Model
