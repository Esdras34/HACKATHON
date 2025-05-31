package controller;

import model.Cliente;
import java.util.ArrayList;

public class ClienteController {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
