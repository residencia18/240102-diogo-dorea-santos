package Veiculos;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("informe 1 para exibir o numero de portas");
		System.out.print("informe 0 para não exibir o numero de portas");
		boolean flag = sc.nextBoolean();
		System.out.print("informe a cor do carro");
		String cor = sc.nextLine();
		System.out.print("informe modelo do carro");
		String modelo = sc.nextLine();
		System.out.print("informe o ano do carro");
		int ano = sc.nextInt();
		
		
		
		
		
		
		//Carro uno = new Carro(modelo, cor, ano, flag);
		
		//uno.exibir();

	}

}
