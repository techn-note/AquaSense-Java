/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm2
 */
public class tanque {

    private double capacidade;
    private double nivelVolume;
    private double temperaturaAgua;
    private double pHAgua;
    private double oxigenacao;
    private double peixes;

    Conexao conexao = new Conexao();
    
    public tanque() {
        this(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    public tanque(double capacidade, double nivelVolume, double temperaturaAgua, double pHAgua, double oxigenacao, double peixes) {
        this.capacidade = capacidade;
        this.nivelVolume = nivelVolume;
        this.temperaturaAgua = temperaturaAgua;
        this.pHAgua = pHAgua;
        this.oxigenacao = oxigenacao;
        this.peixes = peixes;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public double getNivelVolume() {
        return nivelVolume;
    }

    public void setNivelVolume(double nivelVolume) {
        this.nivelVolume = nivelVolume;
    }

    public double getTemperaturaAgua() {
        return temperaturaAgua;
    }

    public void setTemperaturaAgua(double temperaturaAgua) {
        this.temperaturaAgua = temperaturaAgua;
    }

    public double getpHAgua() {
        return pHAgua;
    }

    public void setpHAgua(double pHAgua) {
        this.pHAgua = pHAgua;
    }

    public double getOxigenacao() {
        return oxigenacao;
    }

    public void setOxigenacao(double oxigenacao) {
        this.oxigenacao = oxigenacao;
    }

    public double getPeixes() {
        return peixes;
    }

    public void setPeixes(double peixes) {
        this.peixes = peixes;
    }

    public void inserirTanque(String nome, double capacidade) {
        String sql = "INSERT INTO tanque (Nome, Capacidade) VALUES ('" + nome + "','" + capacidade + "' )";

        try {
            conexao.executeSQL(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + e.getMessage());
        }
    }

    public ResultSet consultarTanques() {
        ResultSet tabela;
        tabela = null;

        String sql = "Select Nome, Capacidade, Data_hora_Instalacao from tanque";
        tabela = conexao.RetornarResultset(sql);

        return tabela;
    }

    /*
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
