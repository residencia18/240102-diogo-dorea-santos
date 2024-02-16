package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Fatura;
import Models.Pagamento;

public class PagamentoService {
	
	private static List<Pagamento> pagamentos;
	
	public static List<Pagamento> getPagamentos() {
		if (pagamentos == null) {
			pagamentos = new ArrayList<>();
		}
		
		return pagamentos;
	}
	
	
	
	public static void setPagamentos(List<Pagamento> pagamentos) {
		PagamentoService.pagamentos = pagamentos;
	}



	public static void addPagamento(Pagamento p) {
		if (pagamentos == null) {
			pagamentos = new ArrayList<>();
		}
		
		pagamentos.add(p);
	}
	
	public static List<Pagamento> getPagamentosByFatura(Fatura f) {
		List<Pagamento> pagamentosFatura = new ArrayList<>();
		
		for (Pagamento pagamento : getPagamentos()) {
			if (pagamento.getFatura().equals(f)) {
				pagamentosFatura.add(pagamento);
			}
		}
		
		return pagamentosFatura;
	}

}
