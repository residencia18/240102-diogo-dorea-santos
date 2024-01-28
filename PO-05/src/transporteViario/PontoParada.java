package transporteViario;

import java.time.LocalTime;

public class PontoParada {
	
	private String cep, gps, codPontoParada;
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
		return codPontoParada;
	}
	public void setNumero(String codPontoParada) {
		this.codPontoParada = codPontoParada;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	
	@Override
	public String toString() {
		return "PontoParada [codPontoParada= " + codPontoParada + ", horario= " + horario + "]";
	}
	public PontoParada(String codPontoParada, LocalTime horario) {
		
		this.codPontoParada = codPontoParada;
		this.horario = horario;
	}
	
	public PontoParada() {
		
	}
}
