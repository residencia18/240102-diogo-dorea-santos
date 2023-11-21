package exercicio4;

import java.util.Scanner;

public class Exercicio4 {
	
	public static void verificaParidade ( int _int) {
		if (_int%2 ==0) {
			System.out.println("Numero par");
		}else {
			System.out.println("Numero impar");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite um numero: ");
		verificaParidade(sc.nextInt());
		sc.close();
		

	}

}
