package Tabuada;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número para calcular a tabuada:");
        int numero = sc.nextInt();
        sc.close();
        
        Tabuada tabuada = new Tabuada();
        tabuada.imprimirTabuada(numero);
    }

    public void imprimirTabuada(int numero) {
        System.out.println("Tabuada de " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
    }
}

