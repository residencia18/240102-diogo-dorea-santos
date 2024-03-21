package configuracao;

public class Configuracao {
	
	private String alfabeto;
	private String nomeConfiguracao;
	private String tamanhoSenha;
	private int nroTentativas;
	private ListaConfiguracao listaConfiguracao = new ListaConfiguracao();
	
	public Configuracao() {
		
	}

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) throws Exception {
		try {
			if (alfabeto == null) {
				throw new Exception("O campo 'alfabeto' deve ser preenchido");
			}
		} catch (Exception e) {
			throw e;
		}
		try {
			if (alfabeto.length() != 8) {
				throw new Exception("O campo 'alfabeto' deve ter 8 caracteres");
			}
		} catch (Exception e) {
			throw e;
		}
		try {
			for (int i = 0; i < 8; i++) {
				char c = alfabeto.charAt(i);
				if (!Character.isLetter(c)) {
					throw new Exception("O campo 'alfabeto' deve ter apenas letras");
				}
			}
		} catch (Exception e) {
			throw e;
		}
		
		//salvar o alfabeto.
		this.alfabeto = alfabeto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws Exception {
		
		try {
			if (senha == null) {
				throw new Exception("O campo 'senha' deve ser preenchido");
			}
		} catch (Exception e) {
			throw e;
		}
		try {
			if (senha.length() != 6) {
				throw new Exception("O campo 'senha' deve ter 6 caracteres");
			}
		} catch (Exception e) {
			throw e;
		}
		try {
			for (int i = 0; i < 6; i++) {
				char c = senha.charAt(i);
				if (!Character.isDigit(c)) {
					throw new Exception("O campo 'senha' deve ter apenas digitos");
				}
		
				this.senha = senha;
			}	
		} catch (Exception e) {	
			
		}
	
	
	}
}
	


