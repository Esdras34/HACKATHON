package model;

public class Venda {
    public Cliente getCliente() {
        return cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    private Cliente cliente;
    private Produto produto;

    public Venda(Cliente cliente, Produto produto) {
        this.cliente = cliente;
        this.produto = produto;
    }

}
