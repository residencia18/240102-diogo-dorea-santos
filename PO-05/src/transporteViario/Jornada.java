package transporteViario;

import java.time.Duration;

public class Jornada {
	
	private Motorista motorista;
	private Cobrador cobrador;
	private Veiculo veiculo;
	private Duration duracaoJornada;
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
	public Jornada(Motorista motorista, Cobrador cobrador, Veiculo veiculo, Duration duracaoJornada) {
		
		this.motorista = motorista;
		this.cobrador = cobrador;
		this.veiculo = veiculo;
		this.duracaoJornada = duracaoJornada;
	}
	
	public void calculaDuracao() {
		
		this.setDuracaoJornada(Duration.ZERO);
				
		
	}
	
	
	

}
