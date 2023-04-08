package phonebook07.db.old;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PhonebookModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5057274872560376651L;
	
	// 멤버변수
	private int id;     // 고유 id 값 ( 1 ~ ) 중복허용X
	private String name;     // 이름
	private String phoneNum; // 전화번호
	private String email;    // 이메일
	private String regDate;	 // 등록일
	
	// 기본생성자(디폴트생성자)
	public PhonebookModel() {
		name = "";
		phoneNum = "";
		email = "";
	}
	
	// 매개변수 생성자
	public PhonebookModel(String name, String phoneNum, String email) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	// getter & setter
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getRegDate() {return regDate;}
	public void setRegDate(String regDate) {this.regDate = regDate;}
	
	// setRegDate(){ .. } <-- regDate 값을 현재 시간의 문자열로 set 
	//     "yyyy-MM-dd kk:mm:ss" 형식으로 문자열 저장
	public void setRegDate() {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		
		this.regDate = format.format(date);
	}
	
	
	@Override
	public String toString() {
		String result = "";
//		result += "----- 전화번호부 정보 -----\n";
//		result += "ID: " + id + "\n";
//		result += "이름: " + name + "\n";
//		result += "전화번호: " + phoneNum + "\n";
//		result += "이메일: " + email + "\n";
//		result += "등록일: " + regDate + "\n";
		
		result = id + "] " + name + "|" + phoneNum + "|" + email + "|" + regDate;
				
		
		return result;
	}

}
