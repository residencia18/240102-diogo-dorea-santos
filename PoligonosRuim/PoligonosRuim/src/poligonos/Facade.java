package poligonos;

import java.util.Scanner;

public class Facade {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Poligono poli = new Poligono();
		System.out.println("Quantos pontos?");
		int n = sc.nextInt();
		for (int i=0;i<n;i++) {
			System.out.println("Digite as coordenadas do ponto");
			float x = sc.nextFloat();
			float y = sc.nextFloat();
			float z = sc.nextFloat();
			poli.inserePonto(x, y, z);
		}
		System.out.println("Poligono criado:");
		poli.mostraPontos();
		System.out.println("Perimetro calculado: "+poli.perimetro());
		sc.close();
	}

}
