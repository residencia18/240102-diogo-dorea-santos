package Exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private String cpf;
    private List<ItemPedido> itens;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.itens = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public List<ItemPedido> getItens() {
    	return itens;
    }
        
    public String getCpf() {
		return cpf;
	}

	public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        itens.add(novoItem);
    }
    
    public double calcularTotalPedido() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }
    
    public double calcularTotalPedido(double _desconto) {
        double total = 0, desconto = _desconto;
        
        for (ItemPedido item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        total -= total *_desconto/100;
        return total;
    }
    
    public double calcularTotalPedido(int _prestacao, double _juros) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        total += total * (_prestacao*_juros)/100; 
        return total;
    }
    
    public void exibirInformacoesPedido() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : itens) {
            System.out.println("Produto: " + item.getProduto().getNome() +
                    ", Quantidade: " + item.getQuantidade() +
                    ", Preço Unitário: " + item.getProduto().getPreco());
        }
        System.out.println("Total do Pedido: " + calcularTotalPedido());
        System.out.println("Total a vista. 10% de desconto: "+ calcularTotalPedido(10));
        System.out.println("Total a prazo. 10X Juros 2%: "+ calcularTotalPedido(10,2));
    }
       
    public static void main(String[] args) {
        Pedido pedido = new Pedido(1);

        Produto produto1 = new Produto("Sapato", 100.99);
        Produto produto2 = new Produto("Bolsa", 180.75);

        pedido.adicionarItem(produto1, 2);
        pedido.adicionarItem(produto2, 1);

        pedido.exibirInformacoesPedido();
    }
}

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
