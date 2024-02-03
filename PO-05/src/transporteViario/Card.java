package transporteViario;

public class Card {
	
	private String cardNumber;

	public String getCardNumber() {
		return cardNumber;
	}

	public Card(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "Card [cardNumber= " + cardNumber + "]";
	}
	
	

}
