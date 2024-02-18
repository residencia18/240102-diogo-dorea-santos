package Controller;

import java.util.List;
import java.util.Scanner;

import Menu.Menu;
import Models.Fatura;
import Models.Imovel;
import Models.Pagamento;
import Services.FaturaService;
import Services.ImovelService;
import Services.PagamentoService;
import Utils.Util;
import dao.PagamentoDAO;

public class PagamentoController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void realizarPagamento() {
		System.out.println("\n======================== Realizar Pagamento ========================");
		
		//Cliente clienteSelecionado = Menu.menuSelecionarCliente();
		Imovel imovelSelecionado = Menu.menuSelecionarImovel(ImovelService.getImoveis());
		
		List<Fatura> faturasPendentes = FaturaService.getFaturasPendentesByImovel(imovelSelecionado);
		Fatura faturaSelecionada = Menu.menuSelecionarFatura(faturasPendentes);
		
		if (faturaSelecionada != null) {			
			System.out.print("\nValor do pagamento: ");
			int valor = Util.stringToInt(entrada.nextLine());
			
			Pagamento pagamento = new Pagamento(faturaSelecionada, valor);
			
			List<Pagamento> pagamentosAnteriores = PagamentoService.getPagamentosByFatura(faturaSelecionada);
			double valorPagamentosAnteriores = 0;
			for (Pagamento p : pagamentosAnteriores) {
				valorPagamentosAnteriores += p.getValor();
			}
			
			if (valor == faturaSelecionada.getValorCalculado()) {
				pagamento.getFatura().setQuitada(true);
			}
			else if (valor > pagamento.getFatura().getValorCalculado()) {
				pagamento.getFatura().setQuitada(true);
				ReembolsoController.realizarReembolso(pagamento, valorPagamentosAnteriores);
			}
			
			PagamentoService.addPagamento(pagamento);
			//PagamentoDAO.create(pagamento, faturaSelecionada);
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
		
	}

	public static void listarTodos() {
		System.out.println("\n======================== Listar pagamentos ========================\n");
		List<Pagamento> pagamentos = PagamentoService.getPagamentos();
		listar(pagamentos);
	}

	public static void consultarPagFatura() {
		System.out.println("\n======================== Listar pagamentos da fatura ========================\n");
		Fatura fatura = Menu.menuSelecionarFatura(FaturaService.getFaturas());
		List<Pagamento> pagamentos = PagamentoService.getPagamentosByFatura(fatura);
		listar(pagamentos);
	}
	
	private static void listar(List<Pagamento> pagamentos) {
		if (!pagamentos.isEmpty()) {
			System.out.println("Data Pagamento \t Valor Pagamento \t Valor Fatura \t Fatura Quitada");
			System.out.println("--------------------------------------------------------------------");
			
			for (Pagamento pagamento : pagamentos) {
				System.out.println(pagamento.toString());
			}
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
	}

}
