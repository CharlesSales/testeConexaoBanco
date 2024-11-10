package org.example.entities;

import org.example.conexao.Conexao;
import org.example.conexao.ConexaoMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final Conexao conexao;
    public UsuarioDAO(){
        this.conexao = new ConexaoMySQL();
    }

    public static void criarUsuario(String nome, String email,int telefone,String endereco){
        var user = new Usuario(nome,email);
    }

    public String criarUsuario(Usuario usuario){
        String sql = "insert into usuario(nome, email, telefone, endereco) values (?,? ,? ,?)";
        try {
            PreparedStatement preparedStatement = conexao.getConnection().prepareStatement(sql);
            addValor(preparedStatement, usuario);
            preparedStatement.executeUpdate();
            return "Feito";
        }
        catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }

    private void addValor(PreparedStatement preparedStatement, Usuario usuario) throws SQLException{
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setInt(3, usuario.getTelefone());
        preparedStatement.setString(4, usuario.getEndereco());
    }


    public List<Usuario> listarUsuarios(){
        String sql = "select * from usuario";
        List<Usuario> listaDeUsuarios = new ArrayList<>();

        try{
            ResultSet result = conexao.getConnection().prepareStatement(sql).executeQuery();
            while(result.next()){
                listaDeUsuarios.add(getUsuario(result));
            }
        }
        catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return listaDeUsuarios;
    }

    private  Usuario getUsuario(ResultSet result) throws SQLException {
        Usuario user = new Usuario();
        user.setId(result.getInt("ID"));
        user.setNome(result.getString("Nome"));
        user.setTelefone(result.getInt("telefone"));
        user.setEmail(result.getString("email"));
        user.setEndereco( result.getString("endereco"));
        return user;
    }
}
