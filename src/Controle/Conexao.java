/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm2
 */
public class Conexao {

    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://127.0.0.1/aquasense";
    final private String usuario = "root";
    final private String senha = "";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;

    public boolean conecta() {
        boolean result = true;

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);


        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver nao localizado: " + Driver);
            result = false;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte de dados: " + Fonte);
            result = false;
        }
        return result;
    }

    public void desconecta() {
        boolean result = true;
        try {
            conexao.close();
            //JOptionPane.showMessageDialog(null,"Banco fechado");
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar o banco de dados" + fecha);
            result = false;
        }
    }

    public void executeSQL(String sql) {
        conecta();
        try {
            statement = conexao.createStatement();
            statement.execute(sql);
        } catch (SQLException sqle) {
            if (sqle.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "Email já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro SQL: " + sqle.getMessage());
            }
        }
    }

    public ResultSet RetornarResultset(String sql) {
        ResultSet resultSet = null;
        conecta();
        try {
            statement = conexao.createStatement();
            resultSet = statement.executeQuery(sql);
            resultSet.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao retornar resultset" + e.getMessage());
        }
        return resultSet;
    }

    public Statement createStatement() throws SQLException {
        throw new UnsupportedOperationException("createStatement is not supported in this class.");
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
