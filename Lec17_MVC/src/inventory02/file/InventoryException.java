package inventory02.file;

public class InventoryException extends RuntimeException implements InventoryConstants {
	private int errCode = ERR_GENERIC;
	
	public InventoryException() {
		super("Phonebook 예외 발생");
	}
	
	public InventoryException(String msg) {
		super(msg);
	}
	public InventoryException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		String msg = "ERR-" + errCode +"]" + ERR_STR[errCode] +
				" " + super.getMessage();
		return msg;
	}
}
