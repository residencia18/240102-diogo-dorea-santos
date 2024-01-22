package quadrado;

public class Quadrado {
	private String estado;
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
		
	public Quadrado(String estado) {
		super();
		this.estado = estado;
	}

	public void clique(int k) {
		
		switch (k) {
		case 1:
			inverteChar(0);
			inverteChar(1);
			inverteChar(3);
			break;

		case 2:
			inverteChar(0);
			inverteChar(1);
			inverteChar(2);
			break;

		case 3:
			inverteChar(1);
			inverteChar(2);
			inverteChar(5);
			break;

		case 4:
			inverteChar(0);
			inverteChar(3);
			inverteChar(6);
			break;

		case 5:
			inverteChar(3);
			inverteChar(7);
			inverteChar(1);
			inverteChar(5);
			inverteChar(4);
			break;

		case 6:
			inverteChar(2);
			inverteChar(5);
			inverteChar(8);
			break;

		case 7:
			inverteChar(3);
			inverteChar(6);
			inverteChar(7);
			break;

		case 8:
			inverteChar(6);
			inverteChar(7);
			inverteChar(8);
			break;

		case 9:
			inverteChar(7);
			inverteChar(8);
			inverteChar(5);
			break;
			
		default:
			break;	
		}
		
	}
	
	public void inverteChar(int i) {
		
		char c = estado.charAt(i);
		if (c=='O') c='X';
		else c='O';
		estado = estado.substring(0,i)+c+estado.substring(i+1);	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
