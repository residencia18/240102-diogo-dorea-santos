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
        ArrayList<Trecho> trechos = new ArrayList<>();
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
                	cadastrarTrecho(trechos, pontosDeParada);
					break;
                case 7:
                    cadastrarTrajeto(trajetos, trechos);
                    break;
                case 8:
                    cadastrarJornada(jornadas, trajetos, motoristas, cobradores, veiculos);
                    break;
                case 9:
                    registrarInicioDeTrajeto(jornadas, trajetos);
                    break;
                case 10:
                    registrarEmbarqueComCartao(trechos, pontosDeParada, passageiros);
                    break;
                case 11:
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
		System.out.println("6. Cadastrar Trecho");
        System.out.println("7. Cadastrar Trajeto");
        System.out.println("8. Cadastrar Jornada");
        System.out.println("9. Registrar Início de Trajeto");
        System.out.println("10. Registrar Embarque com Cartão");
        System.out.println("11. Registrar Checkpoint");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarVeiculo(ArrayList<Veiculo> veiculos) {
        //ToDo: placa, renavam e chassi nao podem ser repetidos.
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

        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
        System.out.println(veiculo.toString());
        //scanner.close();
    }

    private static void cadastrarMotorista(ArrayList<Motorista> motoristas) {
    	//ToDo: cpf, cnh, ctps não podem se repetidos 
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
		motoristas.add(motorista);
		System.out.println("Motorista cadastrado com sucesso!");
		System.out.println(motorista.toString());
		//scanner.close();
    }

    private static void cadastrarCobrador(ArrayList<Cobrador> cobradores) {
    	//ToDo: cpf, ctps não podem se repetidos
		System.out.println("\n### Cadastro de Cobrador ###");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o nome do cobrador: ");
		String nome = scanner.nextLine();
		
		System.out.print("Informe o cpf do cobrador: ");
		String cpf = scanner.nextLine();
		
		System.out.print("Informe o ctps do cobrador: ");
		String ctps = scanner.nextLine();
		
		Cobrador cobrador = new Cobrador(nome, cpf, ctps);
		cobradores.add(cobrador);
		System.out.println("Cobrador cadastrado com sucesso!");
		System.out.println(cobrador.toString());
		//scanner.close();
    }

    private static void cadastrarPassageiro(ArrayList<Cliente> passageiros) {
		//ToDO: cpf, cartão pessoal não podem se repetidos.
    	System.out.println("\n### Cadastro de Passageiro ###");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o nome do passageiro: ");
		String nome = scanner.nextLine();
		
		System.out.print("Informe o cpf do passageiro: ");
		String cpf = scanner.nextLine();
		
		System.out.print("Informe o numero do cartão do passageiro: ");
		String numeroCartao = scanner.nextLine();
				
		Card cartaoPessoal = new Card(numeroCartao);
		Cliente passageiro = new Cliente(nome, cpf, cartaoPessoal);
		passageiros.add(passageiro);
		System.out.println("Passageiro cadastrado com sucesso!");
		System.out.println(passageiro.toString());
		//scanner.close();
    }

    private static void cadastrarPontoDeParada(ArrayList<PontoParada> pontosDeParada) {
    	//ToDO: codigo ponto de parada não pode se repetido.
		System.out.println("\n### Cadastro de Ponto de Parada ###");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Informe o codigo do ponto de parada: ");
		String codigoPontoParada = scanner.nextLine();
		
		//ToDo: Validação de inteiro valido.
		System.out.print("Informe a hora do ponto de parada: ");
		int hora = scanner.nextInt();
		
		System.out.print("Informe os minutos do ponto de parada: ");
		int minuto = scanner.nextInt();
		
		LocalTime horario = LocalTime.of(hora,minuto);
		
		PontoParada pontoParada = new PontoParada(codigoPontoParada, horario);
		
		pontosDeParada.add(pontoParada);
		System.out.println("Ponto de parada cadastrado com sucesso!");
		System.out.println(pontoParada.toString());
		//scanner.close();
    }

    private static void cadastrarTrecho(ArrayList<Trecho> trechos, ArrayList<PontoParada> pontosDeParada) {
    	//ToDo: codigo do trecho não pode se repetido.
    	System.out.println("\n### Cadastro de Trecho ###");
    	
    	Scanner scanner = new Scanner(System.in);
    	
		System.out.print("Informe o codigo do trecho: ");
		String codTrecho = scanner.nextLine();
		
    	System.out.print("Informe o codigo do ponto de parada de origem: ");
    	String codigoPontoParadaOrigem = scanner.nextLine();
    	PontoParada pontoParadaOrigem = new PontoParada();
    	pontoParadaOrigem = localizaPontoParada(codigoPontoParadaOrigem, pontosDeParada);
    	
    	System.out.print("Informe o codigo do ponto de parada de destino: ");
    	String codigoPontoParadaDestino = scanner.nextLine();
    	PontoParada pontoParadaDestino = new PontoParada();
    	pontoParadaDestino = localizaPontoParada(codigoPontoParadaDestino, pontosDeParada);
    	
    	System.out.print("Informe a duração de minutos de parada no trecho: ");
    	int duracao = scanner.nextInt();
    	Duration duracaoParada = Duration.ofMinutes(duracao);
    	
    	Trecho trecho = new Trecho(codTrecho, pontoParadaOrigem, pontoParadaDestino, duracaoParada);
    	trechos.add(trecho);
		System.out.println("Trecho cadastrado com sucesso!");
		System.out.println(trecho.toString());
		//scanner.close();
    }
    
    private static void cadastrarTrajeto(ArrayList<Trajeto> trajetos, ArrayList<Trecho> trechos) {
    	
    	
		System.out.println("\n### Cadastro de Trajeto ###");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe o codigo do trajeto: ");
		String codTrajeto = scanner.nextLine();
		System.out.print("Para montar um trajeto, informe o codigo do trecho de origem: ");
		String codTrechoOrigem = scanner.nextLine();
		Trecho trechoOrigem = new Trecho();
		trechoOrigem = localizaTrecho(codTrechoOrigem, trechos);
		ArrayList<Trecho> trechosAux = new ArrayList<Trecho>();
		trechosAux.add(trechoOrigem);
		
		String resposta = "";
		do {
		System.out.print("Informe o codigo do proximo trecho: ");
		String codProxTrecho = scanner.nextLine();
		Trecho proxTrecho = new Trecho();
		proxTrecho = localizaTrecho(codProxTrecho, trechos);
			if (proxTrecho.getOrigem().equals(trechoOrigem.getDestino())) {
				trechosAux.add(proxTrecho);
				trechoOrigem = proxTrecho;
				System.out.println("Trecho adicionado com sucesso!\nDeseja adicionar outro trecho? Sim ou Nao");
				resposta = scanner.nextLine();
				if (resposta.equals("Nao")||resposta.equals("N")||resposta.equals("n")) {
					
					Trajeto trajeto = new Trajeto(codTrajeto, trechosAux);
					trajetos.add(trajeto);
					System.out.println("Trajeto criado com sucesso!");
					System.out.println(trajeto.toString());
					break;
				}
			
			}			
		} while (resposta.equals("Sim")||resposta.equals("S")||resposta.equals("s"));
	}
    
    private static void cadastrarJornada(ArrayList<Jornada> jornadas, ArrayList<Trajeto> trajetos, ArrayList<Motorista> motoristas,
                                         ArrayList<Cobrador> cobradores, ArrayList<Veiculo> veiculos) {
    	
		System.out.println("\n### Cadastro de Jornada ###");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe o codigo da jornada: ");
		String codJornada = scanner.nextLine();
		System.out.print("Para montar uma jornada, informe o codigo de pelo menos um trajeto: ");
		String codTrajeto = scanner.nextLine();
		Trajeto trajeto = new Trajeto();
		trajeto = localizaTrajeto(codTrajeto, trajetos);
		ArrayList<Trajeto> trajetosAux = new ArrayList<Trajeto>();
		System.out.println("Quantas vezes este trajeto pode ser repetido?");
		int repete = scanner.nextInt();
		for (int i = 0; i < repete; i++) {
			trajetosAux.add(trajeto);			
		}
		System.out.println("Qual cpf do motorista que deseja atribuir a esta jornada?");
		String cpfMotorista = scanner.nextLine();
		Motorista motorista = new Motorista();
		motorista = localizaMotorista(cpfMotorista, motoristas);
		System.out.println("Deseja atribuir um cobrador para esta jornada? Sim ou Nao");
		String resposta = scanner.nextLine();
		Cobrador cobrador = new Cobrador();
		if (resposta.equals("Sim")||resposta.equals("S")||resposta.equals("s")) {
			System.out.println("Qual cpf do cobrador que deseja atribuir a esta jornada?");
			String cpfCobrador = scanner.nextLine();
			cobrador = localizaCobrador(cpfCobrador, cobradores);
		}
		System.out.println("Qual placa do veiculo que deseja atribuir a esta jornada?");
		String placaVeiculo = scanner.nextLine();
		Veiculo veiculo = new Veiculo();
		veiculo = localizaVeiculo(placaVeiculo, veiculos);
		if (resposta.equals("Sim")||resposta.equals("S")||resposta.equals("s")) {
			Jornada jornada = new Jornada(codJornada, trajetosAux, motorista, cobrador, veiculo);
			jornadas.add(jornada);
			System.out.println("Jornada criada com sucesso!");
			System.out.println(jornada.toString());	
		}
		else {
			
			Jornada jornada = new Jornada(codJornada, trajetosAux, motorista, null, veiculo);
			jornadas.add(jornada);
			System.out.println("Jornada criada com sucesso!");
			System.out.println(jornada.toString());
		}
     
    }

    private static void registrarInicioDeTrajeto(ArrayList<Jornada> jornadas, ArrayList<Trajeto> trajetos) {
        // Implemente a lógica para registrar o início de um trajeto
        // ...
    	
    	
    }

    private static void registrarEmbarqueComCartao(ArrayList<Trecho> trechos, ArrayList<PontoParada> pontosDeParada, ArrayList<Cliente> passageiros) {
        // Implemente a lógica para registrar o embarque de um passageiro com cartão
        // ...
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Informe o numero do cartão:");
		String numCartao = scanner.nextLine();
		System.out.println("Informe o codigo do ponto de parada:");
		String codPontoParada = scanner.nextLine();
		System.out.println("informe o codigo do trecho:");
		String codTrecho = scanner.nextLine();
		Trecho trecho = new Trecho();
		trecho = localizaTrecho(codTrecho, trechos);
		PontoParada pontoParada = new PontoParada();
		pontoParada = localizaPontoParada(codPontoParada, pontosDeParada);
		Cliente passageiro = new Cliente();
		passageiro = localizaCliente(numCartao, passageiros);
		if (trecho.getOrigem().equals(pontoParada)) {
			
			trecho.registraEmbarque(passageiro);
			System.out.println("Passageiro registrado com sucesso");
		}
		
    	
    }

    private static void registrarCheckpoint(ArrayList<Jornada> jornadas, ArrayList<Trajeto> trajetos) {
        // Implemente a lógica para registrar um checkpoint
        // ...
    }
    
    public static PontoParada localizaPontoParada(String numeroBusca, ArrayList<PontoParada> pontosDeParada) {
        for (PontoParada ponto : pontosDeParada) {
            if (ponto.getNumero().equals(numeroBusca)) {
                return ponto;
            }
        }
        System.out.println("Ponto de parada não encontrado!");
        return null;
    }
    
    public static Trecho localizaTrecho(String codTrecho, ArrayList<Trecho> trechos) {
		for (Trecho trecho : trechos) {
			if (trecho.getCodTrecho().equals(codTrecho)) {
				return trecho;
			}
		}
		System.out.println("Trecho não encontrado!");
		return null;
	    
    }
    
    public static Trajeto localizaTrajeto(String codTrajeto, ArrayList<Trajeto> trajetos) {
	    
		for (Trajeto trajeto : trajetos) {
			if (trajeto.getCodTrajeto().equals(codTrajeto)) {
				return trajeto;
			}
		}
		System.out.println("Trajeto não encontrado!");
		return null;
    }
    
    public static Cobrador localizaCobrador(String ctpsBusca, ArrayList<Cobrador> cobradores) {
		for (Cobrador cobrador : cobradores) {
			if (cobrador.getCtps().equals(ctpsBusca)) {
				return cobrador;
			}
		}
		System.out.println("Cobrador não encontrado!");
		return null;	    
    }
    
	public static Motorista localizaMotorista(String cpfBusca, ArrayList<Motorista> motoristas) {
		for (Motorista motorista : motoristas) {
			if (motorista.getCpf().equals(cpfBusca)) {
				return motorista;
			}
		}
		System.out.println("Motorista não encontrado!");
		return null;
		
	}
	
	public static Cliente localizaCliente(String cardNumber, ArrayList<Cliente> passageiros) {
		
		for (Cliente passageiro : passageiros) {
			if (passageiro.getCartaoPessoal().getCardNumber().equals(cardNumber)) {
				return passageiro;
			}
		}
		System.out.println("Passageiro não encontrado!");
		return null;
		
	}
	
	public static Veiculo localizaVeiculo(String placaBusca, ArrayList<Veiculo> veiculos) {
		
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equals(placaBusca)) {
				return veiculo;
			}
		}
		System.out.println("Veiculo não encontrado!");
		return null;
	}
}
