public class Calculadora {
    public static void main(String[] args) {
        
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
