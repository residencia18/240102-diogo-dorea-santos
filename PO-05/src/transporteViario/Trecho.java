package transporteViario;

import java.time.Duration;
import java.util.ArrayList;

public class Trecho {
	
	private String codTrecho;
	private PontoParada origem, destino;
	private Duration duracaoTrecho = Duration.ZERO, duracaoParada = Duration.ZERO;
	private ArrayList<Cliente> embarques;
	
	public String getCodTrecho() {
		return codTrecho;
	}
	public void setCodTrecho(String codTrecho) {
		this.codTrecho = codTrecho;
	}
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
	public Trecho(String codTrecho, PontoParada origem, PontoParada destino, Duration _duracaoParada) {
		
		this.codTrecho = codTrecho;
		this.origem = origem;
		this.destino = destino;
		this.duracaoParada = _duracaoParada;
		this.duracaoTrecho = calculaDuracao();
	}
	public Trecho() {
		
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
	@Override
	public String toString() {
		return "Trecho [origem=" + origem + ", destino=" + destino + ", duracaoTrecho =" + duracaoTrecho.toMinutes()
				+ " minutos , duracaoParada=" + duracaoParada.toMinutes() + " minutos, embarques=" + embarques + "]";
	}
	
	

}
