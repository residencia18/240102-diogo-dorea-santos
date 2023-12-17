package Exercicio1;

import java.util.ArrayList;

public class Calculadora {
	
	public int somar(int a, int b) {
        return a + b;
    }
	
	public float somar(float a, float b) {
        return a + b;
    }
	
	public int somar(ArrayList<Integer> numeros) {
        int resultado = 0;
        for (int numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }
    
    public int subtrair(int a, int b) {
        return a - b;
    }
    
    public double subtrair(double a, double b) {
        return a - b;
    }
    
    public int subtrair(ArrayList<Integer> numeros) {
        int resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        return resultado;
    }
    
    public int multiplicar(int a, int b) {
        return a * b;
    }
    
    public long multiplicar(long a, long b) {
        return a * b;
    }
    
    public int multiplicar(ArrayList<Integer> numeros) {
        int resultado = 1;
        for (int numero : numeros) {
            resultado *= numero;
        }
        return resultado;
    }
    
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return a / b;
    }
    
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return a / b;
    }
    
    public double dividir(ArrayList<Double> numeros) {
        if (numeros.contains(0.0)) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }

        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado /= numeros.get(i);
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int somaInt = calculadora.somar(5, 3);
        System.out.println("Soma de dois inteiros. 5 + 3 = " + somaInt);
        float somaFloat = calculadora.somar(5, 3);
        System.out.println("Soma de doid floats com sobrecarga de metodo. 5 + 3 = " + somaFloat);

        int subtracaoInt = calculadora.subtrair(10, 4);
        System.out.println("Subtração de doi inteiros. 10 - 4 = " + subtracaoInt);
        double subtracaoDouble = calculadora.subtrair(10, 4);
        System.out.println("Subtracao de dois double com sobrecarga de metodo. 10 - 4 = "+subtracaoDouble);

        int multiplicaInt = calculadora.multiplicar(6, 7);
        System.out.println("Multiplicacao de dois inteiros. 6 * 7 = " + multiplicaInt);
        int multiplicaLong = calculadora.multiplicar(6, 7);
        System.out.println("Multiplicacao de dois Long com sobrecarga de metodo. 6 * 7 = " + multiplicaLong);
        
        
        double divisaoDouble = calculadora.dividir(15.0, 3.0);
        System.out.println("Divisão de dois double. 15 / 3 = " + divisaoDouble);
        double divisaoInt = calculadora.dividir(15, 3);
        System.out.println("Divisa de dois int. 15 / 3 = " + divisaoInt);
        
        ArrayList<Integer> numerosSoma = new ArrayList<>();
        numerosSoma.add(5);
        numerosSoma.add(3);
        int soma = calculadora.somar(numerosSoma);
        System.out.println("Soma: " + soma);

        ArrayList<Integer> numerosSubtracao = new ArrayList<>();
        numerosSubtracao.add(10);
        numerosSubtracao.add(4);
        int subtracao = calculadora.subtrair(numerosSubtracao);
        System.out.println("Subtração: " + subtracao);

        ArrayList<Integer> numerosMultiplicacao = new ArrayList<>();
        numerosMultiplicacao.add(6);
        numerosMultiplicacao.add(7);
        int multiplicacao = calculadora.multiplicar(numerosMultiplicacao);
        System.out.println("Multiplicação: " + multiplicacao);

        ArrayList<Double> numerosDivisao = new ArrayList<>();
        numerosDivisao.add(15.0);
        numerosDivisao.add(3.0);
        double divisao = calculadora.dividir(numerosDivisao);
        System.out.println("Divisão: " + divisao);            
    }
	
}
