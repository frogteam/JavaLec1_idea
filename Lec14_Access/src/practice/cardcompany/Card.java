package practice.cardcompany;

public class Card {
	// 멤버변수	
	private int cardNumber;  // 카드 고유 번호

	// 생성자	
	// 매개변수 있는 생성자
	// TODO
	public Card(int cardNumber) {
		super();
		this.cardNumber = cardNumber;
	}
	
	// getter & setter
	// TODO
	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}	
	
	
} // end class
