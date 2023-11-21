package exercicio3;

import java.util.Scanner;

public class exercicio3 {
	String A,B;
			
	public static String concat(String _A, String _B) {
		String concatenado = _A.concat(_B);
		return concatenado;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite duas palavras");
		System.out.println(concat(sc.next(), sc.next()));
		
	
		

	}

}
