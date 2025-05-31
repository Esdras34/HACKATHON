package model;

public class Cliente {
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getCredito() {
        return credito;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    private int id;
    private String nome;
    private double credito;

    public Cliente() { }

    public Cliente(int id, String nome, double credito) {
        this.id = id;
        this.nome = nome;
        this.credito = credito;
    }

    // getters e setters
}
