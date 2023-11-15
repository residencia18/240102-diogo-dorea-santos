package ListaDeNumeros;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeNumeros {
    private ArrayList<Float> numeros;

    public ListaDeNumeros() {
        numeros = new ArrayList<>();
    }

    public void lerNumeros() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira uma série de números (Digite um número negativo para encerrar):");

        float numero = 0;
        do {
            numero = sc.nextFloat();
            if (numero >= 0) {
                numeros.add(numero);
            }
        } while (numero >= 0);

        sc.close();
    }

    public void calcularEMostrarMedia() {
        if (numeros.isEmpty()) {
            System.out.println("Nenhum número positivo inserido.");
            return;
        }

        float soma = 0;
        int quantidade = 0;
        for (float num : numeros) {
            if (num >= 0) {
                soma += num;
                quantidade++;
            }
        }

        float media = soma / quantidade;
        System.out.println("A média dos números positivos inseridos é: " + media);
    }

    public static void main(String[] args) {
        ListaDeNumeros lista = new ListaDeNumeros();
        lista.lerNumeros();
        lista.calcularEMostrarMedia();
    }
}
