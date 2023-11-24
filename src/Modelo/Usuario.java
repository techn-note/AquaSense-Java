/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm2
 */
public class Usuario {

    Conexao C = new Conexao();

    private String nome;
    private String email;
    private String login;
    private String senha;

    public Usuario() {
        this("", "", "", "");
    }

    public Usuario(String nome, String email, String login, String senha) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void cadastrar(String nome, String email, String senha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos antes de registrar.");
        } else {
            String sql = "INSERT INTO usuarios (nome, email, senha) VALUES ('" + nome + "','" + email + "','" + senha + "' )";
            
            try {
                C.executeSQL(sql);
            } catch (Exception e) {
            }
        }
    }

    public ResultSet fazerLogin(String email, String senha) {

        ResultSet tabela;
        tabela = null;

        String sql = "SELECT * FROM usuarios WHERE email = '" + this.getEmail() + "' AND senha = '" + this.getSenha() + "'";

        tabela = C.RetornarResultset(sql);

        return tabela;

    }
    
    
    public String NomeLogin() {
        return "";
    }
}
