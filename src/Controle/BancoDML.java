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
 * @author eliha
 */
import Modelo.Usuario;

public class BancoDML {

    Usuario U = new Usuario();

    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://127.0.0.1/";
    final private String usuario = "root";
    final private String senha = "";

    final private String dimensaoSQL
            = "INSERT INTO Dimensao (Comprimento, Largura, Profundidade) VALUES"
            + "(5.0, 3.0, 2.0),"
            + "(4.0, 2.5, 1.8),"
            + "(6.0, 3.5, 2.2),"
            + "(4.5, 2.8, 2.0),"
            + "(5.5, 3.2, 2.5);";

    final private String tanqueSQL
            = "INSERT INTO Tanque (Nome, Capacidade, Data_hora_Instalacao, fk_Dimensao_Id_Dimensao) VALUES"
            + "('Tanque1', 100.0, '2023-01-01 10:00:00', 1),"
            + "('Tanque2', 80.0, '2023-01-02 12:30:00', 2),"
            + "('Tanque3', 120.0, '2023-01-03 14:15:00', 3),"
            + "('Tanque4', 90.0, '2023-01-04 16:45:00', 4),"
            + "('Tanque5', 110.0, '2023-01-05 18:30:00', 5);";

    final private String sensoresSQL
            = "INSERT INTO Sensores (fk_Tanque_Id_Tanque) VALUES\n"
            + "(1),"
            + "(2),"
            + "(3),"
            + "(4),"
            + "(5);";

    final private String senPHSQL
            = "INSERT INTO SenPH (Data_hora_leitura, Valor, fk_Sensores_Id_Sensores) VALUES"
            + "('2023-01-01 10:15:00', 7.2, 1),"
            + "('2023-01-02 12:45:00', 7.5, 2),"
            + "('2023-01-03 14:30:00', 7.0, 3),"
            + "('2023-01-04 16:55:00', 6.8, 4),"
            + "('2023-01-05 18:45:00', 7.3, 5);";

    final private String senODSQL
            = "INSERT INTO SenOD (Data_hora_leitura, Valor, fk_Sensores_Id_Sensores) VALUES"
            + "('2023-01-01 10:20:00', 5.0, 1),"
            + "('2023-01-02 13:00:00', 4.8, 2),"
            + "('2023-01-03 14:45:00', 5.2, 3),"
            + "('2023-01-04 17:00:00', 5.5, 4),"
            + "('2023-01-05 19:00:00', 4.0, 5);";

    final private String senTempSQL
            = "INSERT INTO SenTemp (Data_hora_leitura, Valor, fk_Sensores_Id_Sensores) VALUES"
            + "('2023-01-01 10:25:00', 28.0, 1),"
            + "('2023-01-02 13:15:00', 27.5, 2),"
            + "('2023-01-03 15:00:00', 28.2, 3),"
            + "('2023-01-04 17:15:00', 26.8, 4),"
            + "('2023-01-05 19:15:00', 27.9, 5);";

    final private String peixeSQL
            = "INSERT INTO Peixe (Idade, Peso, Comprimento, Ciclo, fk_Tanque_Id_Tanque) VALUES"
            + "(1, 0.3, 10.0, 1, 1),"
            + "(2, 0.5, 12.0, 2, 2),"
            + "(3, 0.6, 13.0, 3, 3),"
            + "(4, 0.7, 14.0, 4, 4),"
            + "(5, 0.8, 15.0, 5, 5);";

    public void inserindoDados() {
        try (Connection conexao = DriverManager.getConnection(url + "aquasense", usuario, senha)) {
            if (conexao != null) {
                try (Statement statement = conexao.createStatement()) {
                    statement.executeUpdate(dimensaoSQL);
                    statement.executeUpdate(tanqueSQL);
                    statement.executeUpdate(sensoresSQL);
                    statement.executeUpdate(senODSQL);
                    statement.executeUpdate(senPHSQL);
                    statement.executeUpdate(senTempSQL);
                    statement.executeUpdate(peixeSQL);
                }
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados na tabela Usuarios: " + sqle.getMessage());
        }
    }

    
    public String primeiroNome() {
        
        String primeiroNome = "";
        String consultaSQL = "SELECT SUBSTRING_INDEX(Nome, ' ', 1) AS PrimeiroNome FROM Usuarios ORDER BY Id_Usuario DESC LIMIT 1";
        try (Connection conexao = DriverManager.getConnection(url + "aquasense", usuario, senha);
                PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL);
                ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                primeiroNome = resultSet.getString("PrimeiroNome");
            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao obter o primeiro nome do usuário: " + sqle.getMessage());
        }
        U.setNome(primeiroNome);
        return primeiroNome;
    }

}
