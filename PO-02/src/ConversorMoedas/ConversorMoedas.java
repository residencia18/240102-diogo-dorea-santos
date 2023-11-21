package ConversorMoedas;

import java.util.Scanner;

public class ConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor em dólares: ");
        double dolares = scanner.nextDouble();

        System.out.print("Digite a taxa de câmbio: ");
        double cambio = scanner.nextDouble();

        double valorConvertido = dolares * cambio;

        System.out.println("O valor convertido é: " + valorConvertido);
        
        scanner.close();
    }
}
