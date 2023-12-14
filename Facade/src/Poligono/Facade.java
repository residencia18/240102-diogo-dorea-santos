package Poligono;

import java.util.Scanner;

public class Facade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Poligono de quantos pontos?");
		int n = sc.nextInt() ;
		Poligono poli = new Poligono();
		for (int i=0; i< n; i++) {
			System.out.println("Digite as coordenadas");
			float x =sc.nextInt();
			float y = sc.nextInt();
			poli.inserePonto(x, y);
		}
		System.out.println("Mostrando o perimetro: "+poli.perimetro());
	}
}
