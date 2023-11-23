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

    public void CadastrarPeixe(int idade, double peso, double comprimento, int ciclo) {

        String sql = "INSERT INTO Peixe (Idade, Peso, Comprimento, Ciclo) VALUES ('" + idade + "','" + peso + "','" + comprimento + "','" + ciclo + "' )";

        try {
            conexao.executeSQL(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + e.getMessage());
        }
    }

    public ResultSet consultarPeixes() {
        ResultSet tabela;
        tabela = null;

        String sql = "Select Idade, Peso, Comprimento, Ciclo from Peixe";
        tabela = conexao.RetornarResultset(sql);
        return tabela;
    }
}
