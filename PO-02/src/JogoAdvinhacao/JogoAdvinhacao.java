package JogoAdvinhacao;

import java.util.Random;
import java.util.Scanner;

public class JogoAdvinhacao {
    public static void main(String[] args) {
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(100) + 1; //+1 para garantir não ter valor 0 gerado pelo rand.nextInt()
        int tentativa, tentativas = 0;
        boolean acertou = false;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Tente adivinhar o número entre 1 e 100!");

        while (!acertou) {
            System.out.print("Digite sua tentativa: ");
            tentativa = scanner.nextInt();
            tentativas++;
            
            if (tentativa == numeroAleatorio) {
                acertou = true;
                System.out.println("Parabéns! Você acertou o número " + numeroAleatorio + " em " + tentativas + " tentativas!");
            } else if (tentativa < numeroAleatorio) {
                System.out.println("Tente um número mais alto.");
            } else {
                System.out.println("Tente um número mais baixo.");
            }
        }
        
        scanner.close();
    }
}
