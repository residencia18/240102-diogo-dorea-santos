package transporteViario;

import java.time.Duration;
import java.util.ArrayList;

public class Trecho {
	
	private PontoParada origem, destino;
	private Duration duracaoTrecho, duracaoParada;
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
	public void setDuracaoParada(Duration duracaoParada) {
		this.duracaoParada = duracaoParada;
	}
	public ArrayList<Cliente> getEmbarques() {
		return embarques;
	}
	public void setEmbarques(ArrayList<Cliente> embarques) {
		this.embarques = embarques;
	}
	public Trecho(PontoParada origem, PontoParada destino, Duration duracaoTrecho, Duration duracaoParada,
			ArrayList<Cliente> embarques) {
		
		this.origem = origem;
		this.destino = destino;
		this.duracaoTrecho = duracaoTrecho;
		this.duracaoParada = duracaoParada;
		this.embarques = embarques;
	}
	public Duration calculaDuracao (PontoParada origem, PontoParada destino, Duration duracaoParada) {
		//calcula diferenca entre os localtime de origem e destino
		//atribui a variavel duracao e retorna o valor somado ao tempo medio de parada que foi recebido
		Duration duracao = Duration.between(origem.getHorario(), destino.getHorario());
		return duracao.plus(duracaoParada);		
	}
	
	public void registraEmbarque(Cliente cliente) {
		
		embarques.add(cliente);
		
	}

}
