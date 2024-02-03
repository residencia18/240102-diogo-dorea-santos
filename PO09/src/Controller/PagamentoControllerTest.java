package Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Fatura;
import Models.Imovel;
import Models.Pagamento;

class PagamentoControllerTest {

	@Test
	void testRealizarPagamento() {
		
		Imovel imovel = new Imovel("1212", "Rua do imovel");
		Fatura fatura = new Fatura(imovel, 100);
		Pagamento pagamento = new Pagamento(fatura, 100);
		assertNotNull(pagamento.getValor());
		assertNotNull(pagamento.getData());		
	}

}
