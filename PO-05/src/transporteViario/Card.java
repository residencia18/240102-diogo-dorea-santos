package transporteViario;

public class Card {
	
	private int cardNumber;

	public int getCardNumber() {
		return cardNumber;
	}

	public Card(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "Card [cardNumber= " + cardNumber + "]";
	}
	
	

}
