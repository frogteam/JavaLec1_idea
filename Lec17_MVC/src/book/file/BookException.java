package book.file;

//예외 클래스 정의
//일반적으로 예외/에러 발생하면  에러코드 + 에러메세지를 부여하여 식별할수 있게 운영 하는 것이 좋다. 
public class BookException extends RuntimeException implements C{
	
	private int errCode = ERR_GENERIC;
	
	// 생성자
	public BookException() {
		super("예외 발생");
	}
	
	public BookException(String msg) {
		super(msg);
	}
	
	public BookException(String msg, int errCode) {
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
