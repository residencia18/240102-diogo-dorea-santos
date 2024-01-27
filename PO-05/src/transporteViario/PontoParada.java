package transporteViario;

import java.time.LocalTime;

public class PontoParada {
	
	private String cep, gps, numero;
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
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
	@Override
	public String toString() {
		return "PontoParada [numero= " + numero + ", horario= " + horario + "]";
	}
	public PontoParada(String numero, LocalTime horario) {
		
		this.numero = numero;
		this.horario = horario;
	}
	
	

}
