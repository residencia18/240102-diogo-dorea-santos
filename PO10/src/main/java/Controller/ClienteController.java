package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Menu.Menu;
import Models.Cliente;
import Models.Imovel;
import Services.ClienteService;
import Services.ImovelService;
import Utils.Util;
import dao.ClienteDAO;

public class ClienteController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void cadastrarCliente() {		
		System.out.println("\n======================== Cadastrar cliente ========================");
		
		if (!ImovelService.getImoveis().isEmpty()) {	
			List<Imovel> imoveis = new ArrayList<>();
			
			System.out.print("\nNome: ");
			String nome = entrada.nextLine();
			
			System.out.print("\nCPF: ");
			String cpf = entrada.nextLine();
			
			Imovel imovel = Menu.menuSelecionarImovel(ImovelService.getImoveis());
			imoveis.add(imovel);
			
			Cliente cliente = new Cliente(nome, cpf);
			cliente.setImoveis(imoveis);
			
			ClienteService.addCliente(cliente);
			ClienteDAO.create(cliente, imovel);
		}
		else {
			System.out.println("\\nNão existem dados para serem exibidos.");
		}
	}

	public static void removerCliente() {
		System.out.println("\n======================== Remover cliente ========================");
		List<Cliente> clientes = ClienteService.getClientes();

		if (!clientes.isEmpty()) {
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println((i + 1) + ". " + clientes.get(i).getNome());
			}

			System.out.print("Qual cliente deseja selecionar? Escolha pelo número de cada um: ");
			int escolha = Util.stringToInt(entrada.nextLine());

			if (escolha >= 1 && escolha <= clientes.size()) {
				Cliente clienteSelecionado = clientes.get(escolha - 1);
				ClienteService.removeCliente(clienteSelecionado);
				System.out.println("Cliente removido com sucesso.");
			} else {
				System.out.println("Número de cliente inválido.");
			}
		} else {
			System.out.println("\\nNão existem dados para serem exibidos.");
		}
	}
	
	
	public static void listarClientes() {
		System.out.println("\n======================== Listar cliente ========================\n");
		
		List<Cliente> clientes = ClienteService.getClientes();
		if (!clientes.isEmpty()) {
			System.out.println("CPF \t\t Nome");
			System.out.println("-----------------------");
			
			for (Cliente cliente : clientes) {
				System.out.println(cliente.toString());
			}
		}
		else {
			System.out.println("\\nNão existem dados para serem exibidos.");
		}
	}

}
