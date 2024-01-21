package transporteViario;

import java.time.LocalTime;

public class PontoParada {
	
	private String cep, gps;
	private int numero;
	private LocalTime horario;
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public PontoParada(String cep, String gps, int numero, LocalTime horario) {
		
		this.cep = cep;
		this.gps = gps;
		this.numero = numero;
		this.horario = horario;
	}
	
	

}
