package transporteViario;

import java.time.Duration;
import java.util.ArrayList;

public class Jornada {
	
	private String codJornada;
	private Motorista motorista;
	private Cobrador cobrador;
	private Veiculo veiculo;
	private Duration duracaoJornada;
	private ArrayList<Trajeto> trajetos;
	
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Cobrador getCobrador() {
		return cobrador;
	}
	public void setCobrador(Cobrador cobrador) {
		this.cobrador = cobrador;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Duration getDuracaoJornada() {
		return duracaoJornada;
	}
	public void setDuracaoJornada(Duration duracaoJornada) {
		this.duracaoJornada = duracaoJornada;
	}
	
	public String getCodJornada() {
		return codJornada;
	}
	public void setCodJornada(String codJornada) {
		this.codJornada = codJornada;
	}
	
	public Jornada(String codJornada, ArrayList<Trajeto> trajetosAux, Motorista motorista, Cobrador cobrador, Veiculo veiculo) {
		
		this.codJornada = codJornada;
		this.trajetos = trajetosAux;
		this.motorista = motorista;
		this.cobrador = cobrador;
		this.veiculo = veiculo;
		this.duracaoJornada = calculaDuracao();
	}
	
	public Duration calculaDuracao() {
		
		this.setDuracaoJornada(Duration.ZERO);
		
		for(Trajeto trajeto : trajetos) {
			
			duracaoJornada = duracaoJornada.plus(trajeto.getDuracaoTrajeto());
		
		}
		return duracaoJornada;	
	}
}
