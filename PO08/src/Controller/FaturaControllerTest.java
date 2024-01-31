package Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Models.Cliente;
import Models.Imovel;

class FaturaControllerTest {

	@Test
	final void testRealizarLeitura() {
		
		/**
		 * Caso 1: 	Recebe o imovel e a leitura
		 * 			Registra uma fatura
		 * 
		 */
		
		Imovel imovel = new Imovel("1212","Rua do imovel");
		Cliente cliente = new Cliente("nomedocliente", "cpf do cliente");
		cliente.adicionarImovel(imovel);
		
		int leitura = 100;
		
		try {
			FaturaController.realizarLeitura(imovel, leitura);
		} catch (Exception e) {
			
			assertEquals("\nErro ao gerar fatura: ", e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
