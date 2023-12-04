### 1. O que é uma exceção em Java e qual é o propósito de usá-las em programas?

* Uma exceção em Java é um evento anormal que ocorre durante a execução de um programa e interrompe o fluxo normal de execução. O propósito de usar exceções em programas é lidar com erros e situações excepcionais de forma estruturada, permitindo que o programa trate essas situações de maneira apropriada e evite falhas inesperadas. As exceções permitem que o programa capture, trate e/ou propague erros, facilitando a depuração e o desenvolvimento de código mais robusto.

### 2. Pesquise sobre a diferença entre exceções verificadas e não verificadas em Java. Dê exemplos de cada uma.

 * As exceções verificadas são exceções que são verificadas em tempo de compilação. O compilador obriga o programador a lidar ou declarar essas exceções.
 * Exemplos de exceções verificadas incluem IOException, SQLException e ClassNotFoundException.
 * As exceções não verificadas são exceções que não são verificadas em tempo de compilação. O compilador não obriga o programador a lidar ou declarar essas exceções.
 * Exemplos de exceções não verificadas incluem NullPointerException, ArrayIndexOutOfBoundsException e IllegalArgumentException.
 * Este método demonstra a diferença entre exceções verificadas e exceções não verificadas em Java.
```
public void ExceptionDifference() {
    // Exemplo de Exceção Verificada
    try {
        LeitorArquivo leitorArquivo = new LeitorArquivo("arquivo.txt");
        // Realizar operações de arquivo
    } catch (IOException e) {
        // Lidar ou propagar a exceção
    }
    // Exemplo de Exceção Não Verificada
    int[] numeros = {1, 2, 3};
    System.out.println(numeros[4]); // Lança ArrayIndexOutOfBoundsException
}
```

### 3. Como você pode lidar com exceções em Java? Quais são as palavras-chave e as práticas comuns para tratamento de exceções?

* O tratamento de exceções é feito usando blocos try-catch-finally.
* try: É o bloco onde você coloca o código que pode gerar uma exceção.
* catch: Este bloco é usado para capturar exceções específicas que podem ser lançadas no bloco try. Você pode ter múltiplos blocos catch para diferentes tipos de exceções.
* finally: O bloco finally é opcional e é usado para conter o código que deve ser executado independentemente de uma exceção ser lançada ou não.
* Praticas comuns: É recomendado capturar exceçções especificas, com tratamentos diferenciados. lancar uma mensagem de erro especifica da exceção e registrar essas inforações em um log, ajuda na depuração do codigo. Não ignore exceções utilizando um bloco catch vazio.