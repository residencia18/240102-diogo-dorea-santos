package App;

import Menu.Menu;
import Mockup.Mock;
import Services.ClienteService;
import Services.FaturaService;
import Services.ImovelService;
import Services.PagamentoService;
import Services.ReembolsoService;
import dao.ClienteDAO;
import dao.DAO;
import dao.FaturaDAO;
import dao.ImovelDAO;
import dao.PagamentoDAO;
import dao.ReembolsoDAO;

public class App {

	public static void main(String[] args) {
		
		//Apenas para testes
		//Mock.gerarDadosAleatorios();
		/*
		ImovelService.setImoveis(ImovelDAO.readAll());
		ClienteService.setClientes(ClienteDAO.readAll());
		FaturaService.setFaturas(FaturaDAO.readAll());
		PagamentoService.setPagamentos(PagamentoDAO.readAll());
		ReembolsoService.setReembolsos(ReembolsoDAO.readAll());
		DAO.conectar();
		 */
		
		Menu.menuPrincipal();

	}

}
