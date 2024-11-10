package org.example;

import org.example.conexao.Conexao;
import org.example.conexao.ConexaoMySQL;
import org.example.entities.Usuario;
import org.example.entities.UsuarioDAO;

public class Main {
    public static void main(String[] args) {
        Conexao conn = new ConexaoMySQL();

        var user = new UsuarioDAO();
        System.out.println(user.listarUsuarios());

        var newUser1 = new Usuario("Charles","4474");
        var newUser2 = new Usuario("Joao","9999");
        var newUser3 = new Usuario("Vinicius","1258");
        user.criarUsuario(newUser1);
        user.criarUsuario(newUser2);
        user.criarUsuario(newUser3);
        System.out.println(user.listarUsuarios());
    }

}