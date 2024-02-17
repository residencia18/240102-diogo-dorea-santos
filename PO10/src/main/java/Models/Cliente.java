package Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	@OneToMany (mappedBy = "cliente")
	private List<Imovel> imoveis;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, String cpf) {
		
		this.id = null;
		this.nome = nome;
		this.cpf = cpf;
		this.imoveis = new ArrayList<>();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	
	@Override
	public String toString() {
		return this.cpf + "\t" + this.nome;
	}
	// Método para adicionar um imóvel ao cliente
    public void adicionarImovel(Imovel imovel) {
        this.imoveis.add(imovel);
    }

    // Método para alterar dados do cliente
    public void alterarDados(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

}
