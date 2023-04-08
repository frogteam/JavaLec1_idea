package practice.cardcompany;

public class Company {

	private static int serialNum = 10000;
	private static Company instance;
	
	private Company() {}
	public static Company getInstance() {		
		if( instance == null) {
			instance = new Company();
		}
		return instance;
	}
	
	public Card createCard() {
		return new Card(++serialNum);
	}
	
		
} // end class
