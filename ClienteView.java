package view;

import controller.ClienteController;
import controller.ProdutoController;
import model.Cliente;

import javax.swing.*;
import java.awt.*;

public class ClienteView extends JFrame {

    private JTextField campoId, campoNome, campoCredito;
    private ClienteController controller;
    private ProdutoController produtoController;

    public ClienteView(ProdutoController produtoController) {
        super("Gerenciar Clientes");
        this.produtoController = produtoController;
        controller = new ClienteController();

        setLayout(new GridLayout(5, 2));

        add(new JLabel("ID:"));
        campoId = new JTextField();
        add(campoId);

        add(new JLabel("Nome:"));
        campoNome = new JTextField();
        add(campoNome);

        add(new JLabel("Crédito:"));
        campoCredito = new JTextField();
        add(campoCredito);

        JButton botaoCadastrar = new JButton("Cadastrar Cliente");
        botaoCadastrar.addActionListener(e -> cadastrarCliente());
        add(botaoCadastrar);

        JButton botaoAvancar = new JButton("Ir para Vendas");
        botaoAvancar.addActionListener(e -> {
            dispose();
            new VendaView(produtoController, controller);
        });
        add(botaoAvancar);

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void cadastrarCliente() {
        try {
            int id = Integer.parseInt(campoId.getText());
            String nome = campoNome.getText();
            double credito = Double.parseDouble(campoCredito.getText());

            Cliente cliente = new Cliente(id, nome, credito);
            controller.adicionarCliente(cliente);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }
}
