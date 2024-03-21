package jogo;

import configuracao.Configuracao;

public class Jogo {

	private Configuracao configuracao;
	private String senha;
	private int qtTentativas;
	
	public Jogo(Configuracao configuracao){
		this.senha = configuracao.getSenha();
		this.qtTentativas = 0;
		
	}
	
	public String getSenha(){
		return this.senha;
	}
	
	public void setSenha(String senha){
		
		this.senha=senha;
	}
	
	public String setTentativa(String tentativa) {
		return tentativa;
		
	}
	
	public void fimDeJogo () {
		
		
	}
	
			
		
		
	
}
