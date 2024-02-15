package model;

public class Piloto {
	
	private String pais;
    private String piloto;
    private int vitorias;
	
    public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public Piloto(String pais, String piloto, int vitorias) {
		super();
		this.pais = pais;
		this.piloto = piloto;
		this.vitorias = vitorias;
	}
    
    

}
