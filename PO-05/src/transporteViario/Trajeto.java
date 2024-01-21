package transporteViario;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Trajeto {
	
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
	public void setCheckPoint(LocalTime checkPoint) {
		this.checkPoint = checkPoint;
	}
	public Duration getDuracaoTrajeto() {
		return duracaoTrajeto;
	}
	public void setDuracaoTrajeto(Duration duracaoTrajeto) {
		this.duracaoTrajeto = duracaoTrajeto;
	}
	public Trajeto(ArrayList<Trecho> trechos, LocalTime inicio, LocalTime checkPoint, Duration duracaoTrajeto) {
		
		this.trechos = trechos;
		this.inicio = inicio;
		this.checkPoint = checkPoint;
		this.duracaoTrajeto = duracaoTrajeto;
	}
	
	public Duration calculaDuracao () {
		
		this.setDuracaoTrajeto(Duration.ZERO);
		
		for(Trecho trecho : trechos) {
			duracaoTrajeto = duracaoTrajeto.plus(trecho.getDuracaoTrecho());
		}
		
		return duracaoTrajeto;
		
	}
	
	public void registraCheckPoint () {
		
		//Acessa o indice mediano da lista de termos
		//acesso o horario do pontoParada origem daquele trecho
		//checkPoint = trechos.get((trechos.size()/2)).getOrigem().getHorario();
		this.setCheckPoint(trechos.get((trechos.size()/2)).getOrigem().getHorario());
		
	}
	
	public void registraInicio(LocalTime inicio) {
		
		this.inicio = inicio;
		
	}
	
	

}
