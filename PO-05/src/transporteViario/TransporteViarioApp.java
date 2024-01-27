package transporteViario;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class TransporteViarioApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar listas para armazenar os cadastros
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Motorista> motoristas = new ArrayList<>();
        ArrayList<Cobrador> cobradores = new ArrayList<>();
        ArrayList<Cliente> passageiros = new ArrayList<>();
        ArrayList<PontoParada> pontosDeParada = new ArrayList<>();
        ArrayList<Trajeto> trajetos = new ArrayList<>();
        ArrayList<Jornada> jornadas = new ArrayList<>();

        int opcao;
        do {
            exibirMenuPrincipal();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarVeiculo(veiculos);
                    break;
                case 2:
                    cadastrarMotorista(motoristas);
                    break;
                case 3:
                    cadastrarCobrador(cobradores);
                    break;
                case 4:
                    cadastrarPassageiro(passageiros);
                    break;
                case 5:
                    cadastrarPontoDeParada(pontosDeParada);
                    break;
                case 6:
                    cadastrarTrajeto(trajetos, pontosDeParada);
                    break;
                case 7:
                    registrarJornada(jornadas, motoristas, cobradores, veiculos);
                    break;
                case 8:
                    registrarInicioDeTrajeto(jornadas, trajetos);
                    break;
                case 9:
                    registrarEmbarqueComCartao(jornadas, passageiros);
                    break;
                case 10:
                    registrarCheckpoint(jornadas, trajetos);
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n### Sistema de Transporte - Menu Principal ###");
        System.out.println("1. Cadastrar Veículo");
        System.out.println("2. Cadastrar Motorista");
        System.out.println("3. Cadastrar Cobrador");
        System.out.println("4. Cadastrar Passageiro");
        System.out.println("5. Cadastrar Ponto de Parada");
        System.out.println("6. Cadastrar Trajeto");
        System.out.println("7. Registrar Jornada");
        System.out.println("8. Registrar Início de Trajeto");
        System.out.println("9. Registrar Embarque com Cartão");
        System.out.println("10. Registrar Checkpoint");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarVeiculo(ArrayList<Veiculo> veiculos) {
        
    	System.out.println("\n### Cadastro de Veículo ###");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a placa do veículo: ");
        String placa = scanner.nextLine();

        System.out.print("Informe a renavam do veículo: ");
        String renavam = scanner.nextLine();
        
        System.out.print("Informe a chassi do veículo: ");
        String chassi = scanner.nextLine();
			
		System.out.print("Informe o fabricante do veículo: ");
		String fabricante = scanner.nextLine();
		
		System.out.print("Informe o modelo do veículo: ");
		String modelo = scanner.nextLine();
				
		System.out.print("Informe o ano do veículo: ");
		int ano = scanner.nextInt();

        //ToDo: EM implementações futuras solicitar o tipo do veiculo.
		System.out.print("Informe o numero do veículo: ");
		int numero = scanner.nextInt();

       Veiculo veiculo = new Onibus(placa, renavam, ano, chassi, fabricante, numero, modelo);

        // Adicionar o veículo à lista de veículos
        veiculos.add(veiculo);

        System.out.println("Veículo cadastrado com sucesso!");
        
        System.out.println(veiculo.toString());
        scanner.close();
    }

    private static void cadastrarMotorista(ArrayList<Motorista> motoristas) {
		// Implemente a lógica para cadastrar um motorista
		// ...
    	System.out.println("\n### Cadastro de Motorista ###");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o nome do motorista: ");
		String nome = scanner.nextLine();
				
		System.out.print("Informe o cpf do motorista: ");
		String cpf = scanner.nextLine();
		
		System.out.print("Informe o cnh do motorista: ");
		String cnh = scanner.nextLine();
		
		System.out.print("Informe o ctps do motorista: ");
		String ctps = scanner.nextLine();
		
		Motorista motorista = new Motorista(nome, cpf, cnh, ctps);
		
		// Adicionar o motorista à lista de motoristas
		motoristas.add(motorista);
		System.out.println("Motorista cadastrado com sucesso!");
		System.out.println(motorista.toString());
		scanner.close();
    }

    private static void cadastrarCobrador(ArrayList<Cobrador> cobradores) {
        // Implemente a lógica para cadastrar um cobrador
        // ...
    	
		System.out.println("\n### Cadastro de Cobrador ###");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o nome do cobrador: ");
		String nome = scanner.nextLine();
		
		System.out.print("Informe o cpf do cobrador: ");
		String cpf = scanner.nextLine();
		
		System.out.print("Informe o ctps do cobrador: ");
		String ctps = scanner.nextLine();
		
		Cobrador cobrador = new Cobrador(nome, cpf, ctps);
		
		// Adicionar o cobrador à lista de cobradores
		cobradores.add(cobrador);
		System.out.println("Cobrador cadastrado com sucesso!");
		System.out.println(cobrador.toString());
		scanner.close();
    }

    private static void cadastrarPassageiro(ArrayList<Cliente> passageiros) {
        // Implemente a lógica para cadastrar um passageiro
        // ...
    	
		System.out.println("\n### Cadastro de Passageiro ###");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o nome do passageiro: ");
		String nome = scanner.nextLine();
		
		System.out.print("Informe o cpf do passageiro: ");
		String cpf = scanner.nextLine();
		
		System.out.print("Informe o numero do cartão do passageiro: ");
		int numeroCartao = scanner.nextInt();
				
		Card cartaoPessoal = new Card(numeroCartao);
		Cliente passageiro = new Cliente(nome, cpf, cartaoPessoal);
		
		// Adicionar o passageiro à lista de passageiros
		passageiros.add(passageiro);
		System.out.println("Passageiro cadastrado com sucesso!");
		System.out.println(passageiro.toString());
		scanner.close();
    }

    private static void cadastrarPontoDeParada(ArrayList<PontoParada> pontosDeParada) {
        // Implemente a lógica para cadastrar um ponto de parada
        // ...
    	
		System.out.println("\n### Cadastro de Ponto de Parada ###");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o numero do ponto de parada: ");
		String numero = scanner.nextLine();
		
		//ToDo: Validação de interiro valido.
		System.out.print("Informe a hora do ponto de parada: ");
		int hora = scanner.nextInt();
		
		System.out.print("Informe os minutos do ponto de parada: ");
		int minuto = scanner.nextInt();
		
		LocalTime horario = LocalTime.of(hora,minuto);
		
		PontoParada pontoParada = new PontoParada(numero, horario);
		
		// Adicionar o ponto de parada à lista de pontos de parada
		
		pontosDeParada.add(pontoParada);
		System.out.println("Ponto de parada cadastrado com sucesso!");
		System.out.println(pontoParada.toString());
		
		
    }

    private static void cadastrarTrajeto(ArrayList<Trajeto> trajetos, ArrayList<PontoParada> pontosDeParada) {
        // Implemente a lógica para cadastrar um trajeto
        // ...
    }

    private static void registrarJornada(ArrayList<Jornada> jornadas, ArrayList<Motorista> motoristas,
                                         ArrayList<Cobrador> cobradores, ArrayList<Veiculo> veiculos) {
        // Implemente a lógica para registrar uma jornada
        // ...
    }

    private static void registrarInicioDeTrajeto(ArrayList<Jornada> jornadas, ArrayList<Trajeto> trajetos) {
        // Implemente a lógica para registrar o início de um trajeto
        // ...
    }

    private static void registrarEmbarqueComCartao(ArrayList<Jornada> jornadas, ArrayList<Cliente> passageiros) {
        // Implemente a lógica para registrar o embarque de um passageiro com cartão
        // ...
    }

    private static void registrarCheckpoint(ArrayList<Jornada> jornadas, ArrayList<Trajeto> trajetos) {
        // Implemente a lógica para registrar um checkpoint
        // ...
    }
}
