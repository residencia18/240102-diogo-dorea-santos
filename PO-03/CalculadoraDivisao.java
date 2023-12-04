public class CalculadoraDivisao {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        
        try {
            int resultadoInteiro = dividirInteiro(a, b);
            System.out.println("O resultado da divisão inteira é: " + resultadoInteiro);
        } catch (DivisionByZeroException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        float c = 10.5f;
        float d = 0.0f;
        
        try {
            float resultadoFloat = dividirFloat(c, d);
            System.out.println("O resultado da divisão float é: " + resultadoFloat);
        } catch (DivisionByZeroException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public static int dividirInteiro(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
    
    public static float dividirFloat(float a, float b) throws DivisionByZeroException {
        if (b == 0.0f) {
            throw new DivisionByZeroException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
}

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}
