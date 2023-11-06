/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package Controle;
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
/*
    private Connection conexao;

    public BancoDML(Connection conexao) {
        this.conexao = conexao;
    }

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
}
