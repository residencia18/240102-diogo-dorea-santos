package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Cliente;
import Models.Imovel;
import Utils.EntityManagerUtil;
import dao.ClienteDAO;

public class ClienteService {

	private static List<Cliente> clientes;
	
	public static List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = new ArrayList<>();
		}
		
		return clientes;
	}

	public static void setClientes(List<Cliente> clientes) {
		ClienteService.clientes = clientes;
	}

	public static void addCliente(Cliente c) {
		if (clientes == null) {
			clientes = new ArrayList<>();
		}
		
		clientes.add(c);
		ClienteDAO.create(c, EntityManagerUtil.getEntityManager());	
	}
	
	public static void removeCliente(Cliente c) {
		clientes.remove(c);
	}
	
    public static void alterarDadosCliente(Cliente cliente, String novoNome, String novoCpf) {
        cliente.alterarDados(novoNome, novoCpf);
    }
	
	public static Cliente getClienteByImovel(Imovel i) {
		for (Cliente cliente : clientes) {
			List<Imovel> imoveis = cliente.getImoveis();
			
			for (Imovel imovel : imoveis) {
				if (imovel.getMatricula() == i.getMatricula()) {
					return cliente;
				}
			}
		}
		
		return null;
	}
}
