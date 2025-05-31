package view;

import controller.ClienteController;
import controller.ProdutoController;
import controller.VendaController;
import model.Cliente;
import model.Produto;

import javax.swing.*;
import java.awt.*;

public class VendaView extends JFrame {

    private JComboBox<String> comboClientes, comboProdutos;
    private ProdutoController produtoController;
    private ClienteController clienteController;
    private VendaController vendaController;

    public VendaView(ProdutoController produtoController, ClienteController clienteController) {
        super("Realizar Venda");
        this.produtoController = produtoController;
        this.clienteController = clienteController;
        this.vendaController = new VendaController();

        setLayout(new GridLayout(4, 2));

        comboClientes = new JComboBox<>();
        for (Cliente c : clienteController.getClientes()) {
            comboClientes.addItem(c.getId() + " - " + c.getNome());
        }

        comboProdutos = new JComboBox<>();
        for (Produto p : produtoController.getProdutos()) {
            comboProdutos.addItem(p.getId() + " - " + p.getNome() + " - R$" + p.getPreco());
        }

        add(new JLabel("Cliente:"));
        add(comboClientes);
        add(new JLabel("Produto:"));
        add(comboProdutos);

        JButton botaoVender = new JButton("Vender Produto");
        botaoVender.addActionListener(e -> realizarVenda());
        add(botaoVender);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void realizarVenda() {
        int clienteIndex = comboClientes.getSelectedIndex();
        int produtoIndex = comboProdutos.getSelectedIndex();

        Cliente cliente = clienteController.getClientes().get(clienteIndex);
        Produto produto = produtoController.getProdutos().get(produtoIndex);

        vendaController.realizarVenda(cliente, produto);
    }
}
