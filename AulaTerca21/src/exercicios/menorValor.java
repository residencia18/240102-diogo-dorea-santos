package exercicios;

public class menorValor {

	public static void main(String[] args) {
		
		float x, y;
		//double x, y;
		
		x=2;
		do {
			y=x;
			x = x/2;
		} while (x>0);
		System.out.println(y);

	}

}
