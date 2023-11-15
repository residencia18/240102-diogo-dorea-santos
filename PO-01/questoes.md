1. O que é uma classe em Java e qual é a diferença entre uma classe e um 
objeto? Dê 5 exemplos mostrando-os em C++ e em Java.

R: Em Java e em C++, uma classe é um modelo ou um plano para criar objetos.
Ela define os atributos (variáveis) e comportamentos (métodos) que os objetos terão.
Já um objeto é uma instância de uma classe, ou seja, é uma entidade concreta que é criada
 com base nesse modelo e que pode ser manipulada e ter seus métodos chamados.
 Exemplos simples em C++ e Java demonstrando a diferença entre uma classe e um objeto:
 
 Exemplo 1: Classe "Pessoa"
 C++:
 ```
 #include <iostream>
using namespace std;

class Pessoa {
public:
    string nome;
    int idade;
};

int main() {
    Pessoa pessoa1; // Objeto da classe Pessoa
    pessoa1.nome = "João";
    pessoa1.idade = 30;

    cout << "Nome: " << pessoa1.nome << ", Idade: " << pessoa1.idade << endl;

    return 0;
}

```
Java:
```
public class Pessoa {
    String nome;
    int idade;

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa(); // Objeto da classe Pessoa
        pessoa1.nome = "João";
        pessoa1.idade = 30;

        System.out.println("Nome: " + pessoa1.nome + ", Idade: " + pessoa1.idade);
    }
}

```

Exemplo 2: Classe "Círculo"

C++:
```
#include <iostream>
using namespace std;

class Circulo {
public:
    float raio;
    float calcularArea() {
        return 3.14 * raio * raio;
    }
};

int main() {
    Circulo circulo1; // Objeto da classe Circulo
    circulo1.raio = 5.0;

    cout << "Área do círculo: " << circulo1.calcularArea() << endl;

    return 0;
}
```

Java:
```
public class Circulo {
    float raio;
    float calcularArea() {
        return 3.14f * raio * raio;zxdcfvgbhnhytbgrf
    }

    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(); // Objeto da classe Circulo
        circulo1.raio = 5.0f;

        System.out.println("Área do círculo: " + circulo1.calcularArea());
    }
}
```

Exemplo 3: Classe "Livro"

C++:
```
#include <iostream>
using namespace std;

class Livro {
public:
    string titulo;
    string autor;
    int anoPublicacao;
};

int main() {
    Livro livro1; // Objeto da classe Livro
    livro1.titulo = "Dom Casmurro";
    livro1.autor = "Machado de Assis";
    livro1.anoPublicacao = 1899;

    cout << "Livro: " << livro1.titulo << " (" << livro1.autor << "), Ano: " << livro1.anoPublicacao << endl;

    return 0;
}
```

Java:
```
public class Livro {
    String titulo;
    String autor;
    int anoPublicacao;

    public static void main(String[] args) {
        Livro livro1 = new Livro(); // Objeto da classe Livro
        livro1.titulo = "Dom Casmurro";
        livro1.autor = "Machado de Assis";
        livro1.anoPublicacao = 1899;

        System.out.println("Livro: " + livro1.titulo + " (" + livro1.autor + "), Ano: " + livro1.anoPublicacao);
    }
}
```

Exemplo 4: Classe "Carro"

C++:
```
#include <iostream>
using namespace std;

class Carro {
public:
    string marca;
    string modelo;
    int ano;
};

int main() {
    Carro carro1; // Objeto da classe Carro
    carro1.marca = "Toyota";
    carro1.modelo = "Corolla";
    carro1.ano = 2022;

    cout << "Carro: " << carro1.marca << " " << carro1.modelo << ", Ano: " << carro1.ano << endl;

    return 0;
}
```

Java:
```
public class Carro {
    String marca;
    String modelo;
    int ano;

    public static void main(String[] args) {
        Carro carro1 = new Carro(); // Objeto da classe Carro
        carro1.marca = "Toyota";
        carro1.modelo = "Corolla";
        carro1.ano = 2022;

        System.out.println("Carro: " + carro1.marca + " " + carro1.modelo + ", Ano: " + carro1.ano);
    }
}
```

Exemplo 5: Classe "Animal"

C++:
```
#include <iostream>
using namespace std;

class Animal {
public:
    string especie;
    int idade;
};

int main() {
    Animal animal1; // Objeto da classe Animal
    animal1.especie = "Cachorro";
    animal1.idade = 5;

    cout << "Animal: " << animal1.especie << ", Idade: " << animal1.idade << " anos" << endl;

    return 0;
}
```

Java:
```
public class Animal {
    String especie;
    int idade;

    public static void main(String[] args) {
        Animal animal1 = new Animal(); // Objeto da classe Animal
        animal1.especie = "Cachorro";
        animal1.idade = 5;

        System.out.println("Animal: " + animal1.especie + ", Idade: " + animal1.idade + " anos");
    }
}
```

2. Como você declara uma variável em Java e quais são os tipos de dados 
primitivos mais comuns? Faça um paralelo entre isso e a mesma coisa na 
linguagem C++ 

R: Declaracao de variável e feita na seguinte ordem: tipo nome seguindo de ponto e virgula

tipoDaVariavel nomeDaVariavel;

Os tipos de dados primitivos mais comuns em Java são:

1 int: Para números inteiros.
2 double: Para números decimais de ponto flutuante.
3 boolean: Para valores booleanos (verdadeiro ou falso).
4 char: Para um único caractere.
5 byte: Para números inteiros pequenos.
6 short: Para números inteiros curtos.
7 long: Para números inteiros longos.
8 float: Para números decimais de ponto flutuante menores.

3. Explique o conceito de herança em Java e como você pode criar uma 
subclasse a partir de uma classe existente. Faça um paralelo com C++, 
apresentando 5 exemplos.

4. Quando declaramos uma variável em Java, temos, na verdade, um ponteiro. 
Em C++ é diferente. Discorra sobre esse aspecto.