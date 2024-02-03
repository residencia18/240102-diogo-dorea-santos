package transporteViario;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Trajeto {
	
	private String codTrajeto;
	private ArrayList<Trecho> trechos;
	private LocalTime inicio, checkPoint;
	private Duration duracaoTrajeto;
	
	public ArrayList<Trecho> getTrechos() {
		return trechos;
	}
	public void setTrechos(ArrayList<Trecho> trechos) {
		this.trechos = trechos;
	}
	public LocalTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}
	public LocalTime getCheckPoint() {
		return checkPoint;
	}
	public String getCodTrajeto() {
		return codTrajeto;
	}
	public void setCodTrajeto(String codTrajeto) {
		this.codTrajeto = codTrajeto;
	}
	public void setCheckPoint(LocalTime checkPoint) {
		this.checkPoint = checkPoint;
	}
	public Duration getDuracaoTrajeto() {
		return duracaoTrajeto;
	}
	public void setDuracaoTrajeto(Duration duracaoTrajeto) {
		this.duracaoTrajeto = duracaoTrajeto;
	}
	public Trajeto(String codTrajeto, ArrayList<Trecho> trechos) {
		
		this.codTrajeto = codTrajeto;
		this.trechos = trechos;
		this.inicio = trechos.get(0).getOrigem().getHorario();
		this.checkPoint = registraCheckPoint();
		this.duracaoTrajeto = calculaDuracao();
	}
	
	public Trajeto() {
		
	}
	
	public Duration calculaDuracao () {
		
		this.setDuracaoTrajeto(Duration.ZERO);
		
		for(Trecho trecho : trechos) {
			duracaoTrajeto = duracaoTrajeto.plus(trecho.getDuracaoTrecho());
		}
		
		return duracaoTrajeto;		
	}
	
	public LocalTime registraCheckPoint() {
		
		//Acessa o indice mediano da lista de termos
		//acesso o horario do pontoParada origem daquele trecho
		//checkPoint = trechos.get((trechos.size()/2)).getOrigem().getHorario();
		LocalTime checkPoint = trechos.get((trechos.size()/2)).getOrigem().getHorario();
		return checkPoint;
		
	}
	@Override
	public String toString() {
		return "Trajeto [codTrajeto= " + codTrajeto + ", inicio= " + inicio.toString() + ", checkPoint= "
				+ checkPoint.toString() + ", duracaoTrajeto= " + duracaoTrajeto.toHours() + " horas]";
	}
	
	
}
