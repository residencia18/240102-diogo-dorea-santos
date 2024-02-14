package Models;

import java.util.Date;

public class Reembolso {
	
	Integer id;
	private Pagamento pagamento;
	private double valor;
	private Date data;

	public Reembolso() {
		// TODO Auto-generated constructor stub
	}

	public Reembolso(Pagamento pagamento, double valorTodosPagamentos) {
		this.pagamento = pagamento;
		this.valor = pagamento.getValor() + valorTodosPagamentos - getFatura().getValorCalculado();
		this.data = new Date();
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Fatura getFatura() {
		return this.pagamento.getFatura();
	}
	
	@Override
	public String toString() {
		return this.data + "\t" + this.getFatura().getValorCalculado() 
				+ "\t\t" + this.pagamento.getValor() + "\t" + this.valor;
	}
}
