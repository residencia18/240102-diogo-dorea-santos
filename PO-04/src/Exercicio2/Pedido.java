package Exercicio2;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroPedido;
    private List<ItemPedido> itens;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.itens = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        ItemPedido novoItem = new ItemPedido(produto, quantidade);
        itens.add(novoItem);
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

   
    public static void main(String[] args) {
        Pedido pedido = new Pedido(1);

        Produto produto1 = new Produto("Produto 1", 10.99);
        Produto produto2 = new Produto("Produto 2", 15.75);

        pedido.adicionarItem(produto1, 2);
        pedido.adicionarItem(produto2, 1);

        List<ItemPedido> itensPedido = pedido.getItens();
        for (ItemPedido item : itensPedido) {
            System.out.println("Produto: " + item.getProduto().getNome() +
                    ", Quantidade: " + item.getQuantidade() +
                    ", Preço Unitário: " + item.getProduto().getPreco());
        }
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
