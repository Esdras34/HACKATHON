package view;

import controller.ProdutoController;
import model.Produto;

import javax.swing.*;
import java.awt.*;

public class ProdutoView extends JFrame {

    private JTextField campoId, campoNome, campoPreco, campoCategoria;
    private ProdutoController controller;

    public ProdutoView() {
        super("Gerenciar Produtos");
        controller = new ProdutoController();

        setLayout(new GridLayout(6, 2));

        add(new JLabel("ID:"));
        campoId = new JTextField();
        add(campoId);

        add(new JLabel("Nome:"));
        campoNome = new JTextField();
        add(campoNome);

        add(new JLabel("Preço:"));
        campoPreco = new JTextField();
        add(campoPreco);

        add(new JLabel("Categoria:"));
        campoCategoria = new JTextField();
        add(campoCategoria);

        JButton botaoCadastrar = new JButton("Cadastrar Produto");
        botaoCadastrar.addActionListener(e -> cadastrarProduto());
        add(botaoCadastrar);

        JButton botaoAvancar = new JButton("Ir para Clientes");
        botaoAvancar.addActionListener(e -> {
            dispose();
            new ClienteView(controller); // envia produtos para a próxima janela
        });
        add(botaoAvancar);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void cadastrarProduto() {
        try {
            int id = Integer.parseInt(campoId.getText());
            String nome = campoNome.getText();
            double preco = Double.parseDouble(campoPreco.getText());
            String categoria = campoCategoria.getText();

            Produto produto = new Produto(id, nome, preco, categoria);
            controller.adicionarProduto(produto);
            JOptionPane.showMessageDialog(this, "Produto cadastrado!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }
}
