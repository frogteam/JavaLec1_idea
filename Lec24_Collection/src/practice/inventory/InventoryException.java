package practice.inventory;

//예외 클래스 정의
//일반적으로 예외/에러 발생하면  에러코드 + 에러메세지를 부여하여 식별할수 있게 운영 하는 것이 좋다. 
public class InventoryException extends RuntimeException implements C{
	
	private int errCode = ERR_GENERIC;
	
	// 생성자
	public InventoryException() {
		super("PhoneBook 예외 발생");
	}
	
	public InventoryException(String msg) {
		super(msg);
	}
	
	public InventoryException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + ERR_STR[errCode] + 
							" " + super.getMessage();
		return msg;
	}

} // end PhonebookException
