package configuracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConfiguracaoTest {

	@Test
	void testSetAlfabeto() {
		
	Configuracao configuracao = new Configuracao();
	
	//caso geral salvar uma senha valida
	String senha = "ABCDEFGH";
	
	try {
		configuracao.setAlfabeto(senha);
		
	} catch (Exception e1) {
		fail("Gerou exceção indevida");
		e1.printStackTrace();
	}
	
	assertEquals(senha, configuracao.getAlfabeto());
	
	
		
	}

}
