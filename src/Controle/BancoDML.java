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

/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
 */
/**
 *
 * @author eliha
 */
public class BancoDML {

    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://127.0.0.1/";
    final private String usuario = "root";
    final private String senha = "";
    /*
    private Connection conexao;

    public BancoDML(Connection conexao) {
        this.conexao = conexao;
    }
    
    /; apenas teste 

    public void inserirTanque(int idTanque, String nome, double capacidade, Timestamp dataHoraInstalacao, int idDimensao, int idUsuario) {
        String sql = "INSERT INTO Tanque (Id_Tanque, Nome, Capacidade, Data_hora_Instalacao, fk_Dimensao_Id_Dimensao, fk_Usuario_Id_Usuario) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, idTanque);
            preparedStatement.setString(2, nome);
            preparedStatement.setDouble(3, capacidade);
            preparedStatement.setTimestamp(4, dataHoraInstalacao);
            preparedStatement.setInt(5, idDimensao);
            preparedStatement.setInt(6, idUsuario);
            preparedStatement.executeUpdate();
            System.out.println("Tanque inserido com sucesso.");
        } catch (SQLException sqle) {
            System.out.println("Erro ao inserir tanque: " + sqle.getMessage());
        }
    }

    public void consultarTanques() {
        String sql = "SELECT * FROM Tanque";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int idTanque = resultSet.getInt("Id_Tanque");
                String nome = resultSet.getString("Nome");
                double capacidade = resultSet.getDouble("Capacidade");
                Timestamp dataHoraInstalacao = resultSet.getTimestamp("Data_hora_Instalacao");
                int idDimensao = resultSet.getInt("fk_Dimensao_Id_Dimensao");
                int idUsuario = resultSet.getInt("fk_Usuario_Id_Usuario");
                System.out.println("ID Tanque: " + idTanque + ", Nome: " + nome + ", Capacidade: " + capacidade
                        + ", Data/Hora Instalação: " + dataHoraInstalacao + ", ID Dimensão: " + idDimensao
                        + ", ID Usuário: " + idUsuario);
            }
        } catch (SQLException sqle) {
            System.out.println("Erro ao consultar tanques: " + sqle.getMessage());
        }
    }

    public void atualizarTanque(int idTanque, String novoNome) {
        String sql = "UPDATE Tanque SET Nome = ? WHERE Id_Tanque = ?";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, novoNome);
            preparedStatement.setInt(2, idTanque);
            preparedStatement.executeUpdate();
            System.out.println("Tanque atualizado com sucesso.");
        } catch (SQLException sqle) {
            System.out.println("Erro ao atualizar tanque: " + sqle.getMessage());
        }
    }

    public void excluirTanque(int idTanque) {
        String sql = "DELETE FROM Tanque WHERE Id_Tanque = ?";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setInt(1, idTanque);
            preparedStatement.executeUpdate();
            System.out.println("Tanque excluído com sucesso.");
        } catch (SQLException sqle) {
            System.out.println("Erro ao excluir tanque: " + sqle.getMessage());
        }
    }
     */
    final private String usuarioSQL = "INSERT INTO Usuarios (Nome, Email, Senha, Telefone) VALUES"
            + "    ('Usuario1', 'usuario1@email.com', 'senha1', '1234567890'),"
            + "    ('Usuario2', 'usuario2@email.com', 'senha2', '9876543210'),"
            + "    ('Usuario3', 'usuario3@email.com', 'senha3', '1112223333'),"
            + "    ('Usuario4', 'usuario4@email.com', 'senha4', '4445556666'),"
            + "    ('Usuario5', 'usuario5@email.com', 'senha5', '7778889999')"
            + " ON DUPLICATE KEY UPDATE Email=VALUES(Email)";

    final private String dimensaoSQL
            = "INSERT INTO Dimensao (Comprimento, Largura, Profundidade) VALUES"
            + "(5.0, 3.0, 2.0),"
            + "(4.0, 2.5, 1.8),"
            + "(6.0, 3.5, 2.2),"
            + "(4.5, 2.8, 2.0),"
            + "(5.5, 3.2, 2.5);";

    final private String tanqueSQL
            = "INSERT INTO Tanque (Nome, Capacidade, Data_hora_Instalacao, fk_Dimensao_Id_Dimensao, fk_Usuario_Id_Usuario) VALUES"
            + "('Tanque1', 1000.0, '2023-01-01 10:00:00', 1, 1),"
            + "('Tanque2', 800.0, '2023-01-02 12:30:00', 2, 2),"
            + "('Tanque3', 1200.0, '2023-01-03 14:15:00', 3, 3),"
            + "('Tanque4', 950.0, '2023-01-04 16:45:00', 4, 4),"
            + "('Tanque5', 1100.0, '2023-01-05 18:30:00', 5, 5);";

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
            + "('2023-01-05 19:00:00', 4.9, 5);";

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
                    statement.executeUpdate(usuarioSQL);
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

    /*
    private String ultimoNome(int idUsuario) {
        String ultimoNome = "";
        String consultaSQL = "SELECT SUBSTRING_INDEX(Nome, ' ', -1) AS UltimoNome FROM Usuarios ORDER BY Id_Usuario DESC LIMIT 1";

        try (Connection conexao = DriverManager.getConnection(url + "aquasense", usuario, senha); PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL)) {

            preparedStatement.setInt(1, idUsuario);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ultimoNome = resultSet.getString("UltimoNome");
                }
            }

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao obter o último nome do usuário: " + sqle.getMessage());
        }

        return ultimoNome;
    }
    */
}
