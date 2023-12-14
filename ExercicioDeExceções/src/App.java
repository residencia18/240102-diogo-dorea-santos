import java.util.Scanner;

import ValidadorDeIdade.ValidadorIdade;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int idade;
		Scanner sc = new Scanner(System.in);
		System.out.println("digite a idade: ");
		idade = sc.nextInt();
		System.out.println(idade);
		ValidadorIdade.validaIdade(idade);


	}

}
