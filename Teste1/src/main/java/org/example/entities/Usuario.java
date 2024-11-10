package org.example.entities;

public class Usuario {

    private static int geradorID = 1;
    private int id;
    private String nome;
    private String email;
    private int telefone;
    private String endereco;

    public Usuario() {
    }

    public Usuario(String nome, String email) {
        this.id = geradorID++;
        this.nome = nome;
        this.email = email;
        this.telefone = 12436;
        this.endereco = "Salvador";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
