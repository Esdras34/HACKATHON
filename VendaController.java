package controller;

import model.Cliente;
import model.Produto;
import model.Venda;

import javax.swing.*;

public class VendaController {

    public boolean realizarVenda(Cliente cliente, Produto produto) {
        if (cliente.getCredito() >= produto.getPreco()) {
            cliente.setCredito(cliente.getCredito() - produto.getPreco());
            JOptionPane.showMessageDialog(null,
                    "Venda realizada com sucesso!\n" +
                            "Cliente: " + cliente.getNome() + "\n" +
                            "Produto: " + produto.getNome() + "\n" +
                            "Crédito restante: R$" + cliente.getCredito());
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Crédito insuficiente para realizar a compra.");
            return false;
        }
    }
}
