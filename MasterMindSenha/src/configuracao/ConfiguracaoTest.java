package configuracao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConfiguracaoTest {

	@Test
	void testSetAlfabeto() {
		
	Configuracao configuracao = new Configuracao();
	
	//caso 1: caso geral salvar uma senha valida.
	String alfabeto = "ABCDEFGH";
	
	try {
		configuracao.setAlfabeto(alfabeto);
		
	} catch (Exception e1) {
		fail("Gerou exceção indevida");
		e1.printStackTrace();
	}
	
	assertEquals(alfabeto, configuracao.getAlfabeto());
	
	//caso 2: caso especifico salvar uma senha invalida null.
	alfabeto = null;
	
	try {
		configuracao.setAlfabeto(alfabeto);
		
	} catch (Exception e) {
		assertEquals("O campo 'alfabeto' deve ser preenchido", e.getMessage());
		e.printStackTrace();
	}
	
	assertFalse(configuracao.getAlfabeto()==null);	
	}
	
	@Test
	void testSetSenha() {
		
	}

}
