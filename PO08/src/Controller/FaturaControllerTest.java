package Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Cliente;
import Models.Fatura;
import Models.Imovel;
import Services.ClienteService;
import Services.FaturaService;

class FaturaControllerTest {

	@Test
	final void testRealizarLeitura() {
		
		/**
		 * Caso 1: 	Recebe o imovel e a leitura
		 * 			Registra uma fatura
		 */
		
		Imovel imovel = new Imovel("1212","Rua do imovel");
		Cliente cliente = new Cliente("nomedocliente", "cpf do cliente");
		ClienteService.addCliente(cliente);
		cliente.adicionarImovel(imovel);
		
		int leitura = 100;
		
		try {
			FaturaController.realizarLeitura(imovel, leitura);
		} catch (Exception e) {
			
			fail("Exceção inesperada: " + e.getMessage());
		}
		
		/**
		 * Caso 2: 	Gera uma nova fatura no mesmo imovel
		 * e testa se a leitura atual fornecida correnponde ao valor
		 * da leitura anterior na lista de faturas, confirmando a inversão.
		 * Depois testa se aleitura fornecida
		 * Depois testa
		 */
		
		/*
		int leituraAtual = 220;
		
			
			Fatura faturaAnterior = imovel.getFaturas().get(0);
			Fatura faturaAnterior = FaturaService.getFaturas().get(0);
			FaturaService.gerarFatura(imovel, leituraAtual);
			Fatura faturaGerada = FaturaService.getFaturas().get(1);
		
			
			assertEquals(faturaAnterior.getLeituraAtual(), leituraAtual);
			assertEquals(faturaAnterior.getLeituraAtual(), faturaGerada.getLeituraAtual());
		
		*/
		
		
		
		
	}

}
