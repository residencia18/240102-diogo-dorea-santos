package transporteViario;

public class Cliente extends Pessoa{
	
	private Card cartaoPessoal;

	public Card getCartaoPessoal() {
		return cartaoPessoal;
	}

	public void setCartaoPessoal(Card cartaoPessoal) {
		this.cartaoPessoal = cartaoPessoal;
	}

	public Cliente(String nome, String cpf, Card cartaoPessoal) {
		super(nome, cpf);
		this.cartaoPessoal = cartaoPessoal;
	}

	@Override
	public String toString() {
		return "Cliente [cartaoPessoal =" + cartaoPessoal.toString() + ", Nome= " + getNome() + ", CPF= " + getCpf() + "]";
	}
	
	
	
	
	
	
	
	
	

}
