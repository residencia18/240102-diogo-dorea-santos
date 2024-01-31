package Models;

import java.util.Date;

import Utils.Util;

public class Fatura {
	
	private Imovel imovel;
	private int valorConsumo;
	private Date dataEmissao;
	private int leituraAnterior;
	private int leituraAtual;
	private double valorCalculado;
	private boolean quitada;

	public Fatura() {
		// TODO Auto-generated constructor stub
	}

	public Fatura(Imovel imovel, int leituraAtual) {
        this.imovel = imovel;
        this.leituraAnterior = imovel.getLeituraAtual();
        this.leituraAtual = leituraAtual;
        this.dataEmissao = new Date();
        this.valorConsumo = leituraAtual - leituraAnterior;
        this.valorCalculado = 10 * valorConsumo;
        this.quitada = false;
    }

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public int getValorConsumo() {
		return valorConsumo;
	}

	public void setValorConsumo(int valorConsumo) {
		this.valorConsumo = valorConsumo;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public int getLeituraAnterior() {
		return leituraAnterior;
	}

	public void setLeituraAnterior(int leituraAnterior) {
		this.leituraAnterior = leituraAnterior;
	}

	public int getLeituraAtual() {
		return leituraAtual;
	}

	public void setLeituraAtual(int leituraAtual) {
		this.leituraAtual = leituraAtual;
	}

	public double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public boolean isQuitada() {
		return quitada;
	}

	public void setQuitada(boolean quitada) {
		this.quitada = quitada;
	}
	public String getDataFormatada() {
        return Util.formatDate(dataEmissao);
    }

    @Override
    public String toString() {
        return imovel.getMatricula() + "\t" + getDataFormatada() + "\t" + this.valorConsumo
                + "\t" + this.valorCalculado + "\t" + this.quitada;
    }

}
