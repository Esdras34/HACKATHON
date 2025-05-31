package controller;

import model.Produto;
import java.util.ArrayList;

public class ProdutoController {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
