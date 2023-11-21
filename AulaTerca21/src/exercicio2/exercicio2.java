package exercicio2;

import java.util.Scanner;

public class exercicio2 {

	

	public static float mediaPonderada(float _nota1, float _nota2, float _nota3, float _peso1, float _peso2, float _peso3) {
		float resultado;
		
		resultado = _nota1 * _peso1 + _nota2 *_peso2 + _nota3 * _peso3 / _peso1 + _peso2 + _peso3;
		return resultado;
	}
	
	public static void main(String[] args) {
		float nota1, nota2, nota3, peso1, peso2, peso3;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Informe 3 notas");
		nota1 = scanner.nextFloat();
		nota2 = scanner.nextFloat();
		nota3 = scanner.nextFloat();
		
		System.out.println("Informe 3 pesos");
		peso1 = scanner.nextFloat();
		peso2 = scanner.nextFloat();
		peso3 = scanner.nextFloat();
		scanner.close();
		
		System.out.println(mediaPonderada(nota1, nota2, nota3, peso1, peso2, peso3));
	}
	

}
