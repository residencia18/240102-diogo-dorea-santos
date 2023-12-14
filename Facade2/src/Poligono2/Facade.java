package Poligono2;

import java.util.Scanner;

public class Facade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Poligono de quantos pontos?");
		int n = sc.nextInt();
		Poligono poli = new Poligono();
		for (int i=0; i< n; i++) {
			Ponto p = Ponto.solicitaPonto();
			poli.inserePonto(p)
		}
		
		("Mostrando o perimetro: "+poli.perimetro());
	}
	

}
