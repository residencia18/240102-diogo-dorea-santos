package transporteViario;

import java.time.Duration;
import java.util.ArrayList;

public class Trecho {
	
	private PontoParada origem, destino;
	private Duration duracaoTrecho = Duration.ZERO, duracaoParada = Duration.ZERO;
	private ArrayList<Cliente> embarques;
	
	public PontoParada getOrigem() {
		return origem;
	}
	public void setOrigem(PontoParada origem) {
		this.origem = origem;
	}
	public PontoParada getDestino() {
		return destino;
	}
	public void setDestino(PontoParada destino) {
		this.destino = destino;
	}
	public Duration getDuracaoTrecho() {
		return duracaoTrecho;
	}
	public void setDuracaoTrecho(Duration duracaoTrecho) {
		this.duracaoTrecho = duracaoTrecho;
	}
	public Duration getDuracaoParada() {
		return duracaoParada;
	}
	public ArrayList<Cliente> getEmbarques() {
		return embarques;
	}
	public void setEmbarques(ArrayList<Cliente> embarques) {
		this.embarques = embarques;
	}
	public Trecho(PontoParada origem, PontoParada destino, ArrayList<Cliente> embarques, int _duracaoParada) {
		
		this.origem = origem;
		this.destino = destino;
		this.duracaoParada = Duration.ofMinutes(_duracaoParada);
		this.duracaoTrecho = calculaDuracao();
		this.embarques = embarques;
	}
	public Duration calculaDuracao () {
		//calcula diferenca entre os localtime de origem e destino
		//atribui a variavel duracao e retorna o valor somado ao tempo medio de parada
		Duration duracao = Duration.between(origem.getHorario(), destino.getHorario());
		duracaoTrecho = duracao.plus(duracaoParada);
		return duracaoTrecho;		
	}
	
	public void registraEmbarque(Cliente cliente) {
		
		embarques.add(cliente);
		
	}

}
