package ManipulaArray;

import java.util.Scanner;
import java.util.Random;

public class ManipulaArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int tamanho = scanner.nextInt();

        int[] numeros = new int[tamanho];

        System.out.println("Digite os números:");
        for (int i = 0; i < tamanho; i++) {
            numeros[i] = scanner.nextInt();
        }

        System.out.println("Array de números inseridos:");
        exibirArray(numeros);

        int[] numerosAleatorios = gerarNumerosAleatorios(tamanho);
        System.out.println("\nArray de números aleatórios:");
        exibirArray(numerosAleatorios);
        //System.out.println("\n");
        somaArray(numerosAleatorios);
        menorValor(numerosAleatorios);
    }

    public static void exibirArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }

    public static int[] gerarNumerosAleatorios(int tamanho) {
        Random random = new Random();
        int[] numerosAleatorios = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            numerosAleatorios[i] = random.nextInt(100);
        }

        return numerosAleatorios;
    }
    
    public static void somaArray(int[] array) {
        int soma = 0;
        for (int num : array) {
            soma += num;
        }
        System.out.println("Soma dos números do array: " + soma+"");
    }
    
    public static void menorValor(int[] array) {
        int menor = array[0];
        for (int num : array) {
            if (num < menor) {
                menor = num;
            }
        }
        System.out.println("Menor valor do array: " + menor);
    }

}
