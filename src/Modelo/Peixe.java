/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm2
 */
public class Peixe {

    Conexao conexao = new Conexao();

    private double comprimento;
    private double peso;
    private int idade;
    private int ciclo;

    public Peixe() {
        this(0.0, 0.0, 0, 0);
    }

    public Peixe(double comprimento, double peso, int idade, int ciclo) {
        this.comprimento = comprimento;
        this.peso = peso;
        this.idade = idade;
        this.ciclo = ciclo;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public List<Peixe> obterDadosSensor(ResultSet resultSet) {

        List<Peixe> Peixe = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Peixe.add(new Peixe(resultSet.getDouble("Comprimento"),
                        resultSet.getDouble("Peso"),
                        resultSet.getInt("Idade"),
                        resultSet.getInt("Ciclo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Peixe;
    }

    public void CadastrarPeixe(double comp, double peso, int idade, int ciclo) {

        String sql = "INSERT INTO Peixe (Comprimento, Peso, Idade, Ciclo) VALUES ('" + comp + "','" + peso + "','" + idade + "','" + ciclo + "' )";

        try {
            conexao.executeSQL(sql);
            JOptionPane.showMessageDialog(null, "Registrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + e.getMessage());
        }
    }
/*
    public ResultSet consultarPeixe() {
        String sql = "SELECT Comprimento, Peso, Idade, Ciclo FROM Peixe";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql);
                ResultSet tabela = null;
                tabela = conexao.RetornarResultset(sql)
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                double comprimento = resultSet.getDouble("Comprimento");
                double peso = resultSet.getDouble("Peso");
                int idade = resultSet.getInt("Idade");
                int ciclo = resultSet.getInt("Ciclo");
                System.out.println("Comprimento: " + comprimento + ", Peso: " + peso
                        + ", Idade: " + idade + ", Ciclo: " + ciclo);
            }
        } catch (SQLException sqle) {
            System.out.println("Erro ao consultar peixe: " + sqle.getMessage());
        }
        return tabela;
    }

    public ResultSet consultarPeixe() {
    String sql = "SELECT Comprimento, Peso, Idade, Ciclo FROM Peixe";
    ResultSet tabela = null;

    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
        tabela = preparedStatement.executeQuery();
        while (tabela.next()) {
            double comprimento = tabela.getDouble("Comprimento");
            double peso = tabela.getDouble("Peso");
            int idade = tabela.getInt("Idade");
            int ciclo = tabela.getInt("Ciclo");
            System.out.println("Comprimento: " + comprimento + ", Peso: " + peso
                    + ", Idade: " + idade + ", Ciclo: " + ciclo);
        }
    } catch (SQLException sqle) {
        System.out.println("Erro ao consultar peixe: " + sqle.getMessage());
    }

    return tabela;
}
*/
}
